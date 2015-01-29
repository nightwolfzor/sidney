package org.sidney.scala

import java.lang.reflect.Modifier

import com.fasterxml.jackson.databind.`type`.TypeBindings
import org.sidney.core
import org.sidney.core.TypeRef.TypeFieldRef
import org.sidney.core.serde.serializer.Types
import org.sidney.core.{Fields, JavaTypeRefBuilder}

import scala.collection.JavaConversions._
import scala.reflect.runtime.universe._

object ScalaTypeRefBuilder {
  private val adapt = (x: String, isTypeArg: Boolean) => {
    val clazz = ScalaPrimitiveTypeAdapter.getJavaClassForScalaString(x, isTypeArg)
    if (clazz == null) Class.forName(x) else clazz
  }
  val arrClass = Class.forName("scala.Array")

  def typeRef[T]()(implicit tag: TypeTag[T]) = {
    decompose(tag.tpe, null, false)
  }

  def decompose(t: Type, parentBindings: TypeBindings, isTypeArg: Boolean): core.TypeRef = {
    val typeArgs = t match {
      case TypeRef(_, _, args) => args
    }
    val rawType = t match {
      case TypeRef(_, arg, _) => arg
    }

    decompose(t, rawType, typeArgs, parentBindings, isTypeArg, t.members.flatMap(x => {
      if(x.isTerm) {
        val n = x.asTerm
        if((n.isVal || n.isVar) && !n.isStatic) {
          Some(n)
        } else {
          None
        }
      } else {
        None
      }
    }).toSeq)
  }

  def decompose(t : Type, sym : Symbol, typeArgs: List[Type], parentBindings: TypeBindings, isTypeArg: Boolean, members : Seq[TermSymbol]): core.TypeRef = {
    val ref = new core.TypeRef(adapt(sym.fullName, isTypeArg))
    //now we have the class for the symbol, go decompose the typeargs, then go through all the fields and bind them to the type args
    var bindings: TypeBindings = null
    val typeArgsAsRefs = typeArgs.map(x => {
      decompose(x, parentBindings, !isPrimitiveArray(x, ref))
    })
    typeArgsAsRefs.foreach(ref.addTypeParameter)

    bindings = typeArgs.length match {
      case 0 => Types.binding(ref.getType, parentBindings)
      case _ => Types.binding(ref)
    }

    val availableFields = ref.getType.getDeclaredFields.filterNot(f => {
      Modifier.isStatic(f.getModifiers) || Modifier.isTransient(f.getModifiers)
    }).map(f => (f.getName, f)).toMap

    members.foreach(member => {
      val name = member.name.decoded.trim
      val memberType = member.typeSignatureIn(t)
      val memberRef = decompose(memberType, bindings, false)
      availableFields.get(name).foreach(field => {
        ref.addField(
          memberRef.toField(field)
        )
      })
    })

    if(ref.getType.getName.eq("scala.Array")) {
      //change scala arrays to java types
      val componentType = typeArgsAsRefs.head
      val arr = java.lang.reflect.Array.newInstance(componentType.getType, 0).getClass
      ref.setType(arr)
    }
    ref
  }

  private def isPrimitiveArray(t : Type, ref : org.sidney.core.TypeRef) : Boolean = {
    val rawType = decompose(t, null, false)
    ScalaPrimitiveTypeAdapter.isJavaPrimitive(rawType.getType) && ref.getType.getName.eq("scala.Array")
  }
}