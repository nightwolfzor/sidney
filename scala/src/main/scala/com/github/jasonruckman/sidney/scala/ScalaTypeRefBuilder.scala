/**
 * Copyright 2014 Jason Ruckman
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.jasonruckman.sidney.scala

import java.lang.reflect.Modifier

import com.fasterxml.jackson.databind.`type`.TypeBindings
import com.github.jasonruckman.sidney.core
import com.github.jasonruckman.sidney.core.SidneyException

import scala.reflect.runtime.universe._

object ScalaTypeRefBuilder {
  private val adapt = (x: String, isTypeArg: Boolean) => {
    val clazz = ScalaPrimitiveTypeAdapter.getJavaClassForScalaString(x, isTypeArg)
    if (clazz == null) Class.forName(x) else clazz
  }

  /**
   * Build a typeref for a given type
   */
  def typeRef[T]()(implicit tag: TypeTag[T]) = {
    decompose(tag.tpe, false)
  }

  private def decompose(t: Type, isTypeArg: Boolean): core.`type`.TypeRef = {
    val typeArgs = t match {
      case TypeRef(_, _, args) => args
    }
    val rawType = t match {
      case TypeRef(_, arg, _) => arg
    }

    decompose(t, rawType, typeArgs, isTypeArg, t.members.flatMap(x => {
      if (x.isTerm) {
        val n = x.asTerm
        if ((n.isVal || n.isVar) && !n.isStatic) {
          Some(n)
        } else {
          None
        }
      } else {
        None
      }
    }).toSeq)
  }

  private def decompose(t: Type, sym: Symbol, typeArgs: List[Type], isTypeArg: Boolean, members: Seq[TermSymbol]): core.`type`.TypeRef = {
    val ref = new core.`type`.TypeRef(adapt(sym.fullName, isTypeArg))
    ref.getType match {
      case i if i.eq(classOf[Object]) || i.eq(classOf[AnyRef]) || i.eq(classOf[Any]) => {
        throw new SidneyException("Cannot resolve type %s".format(i.getName))
      }
      case _ =>
    }
    //now we have the class for the symbol, go decompose the typeargs, then go through all the fields and bind them to the type args
    var bindings: TypeBindings = null
    val typeArgsAsRefs = typeArgs.map(x => {
      decompose(x, !isPrimitiveArray(x, ref))
    })
    typeArgsAsRefs.foreach(ref.addTypeParameter)

    val availableFields = ref.getType.getDeclaredFields.flatMap(x => {
      if (!Modifier.isStatic(x.getModifiers) && !Modifier.isTransient(x.getModifiers)) {
        Some(x.getName, x)
      } else {
        None
      }
    }).toMap

    members.foreach(member => {
      val name = member.name.decoded.trim
      val memberType = member.typeSignatureIn(t)
      val memberRef = decompose(memberType, false)
      availableFields.get(name).foreach(field => {
        ref.addField(
          memberRef.toField(field)
        )
      })
    })

    //scala arrays are generics instead of being component types
    if (ref.getType.getName.eq("scala.Array")) {
      //change scala arrays to java types
      val componentType = typeArgsAsRefs.head
      val arr = java.lang.reflect.Array.newInstance(componentType.getType, 0).getClass
      ref.setType(arr)
    }
    ref
  }

  private def isPrimitiveArray(t: Type, ref: com.github.jasonruckman.sidney.core.`type`.TypeRef): Boolean = {
    val rawType = decompose(t, false)
    ScalaPrimitiveTypeAdapter.isJavaPrimitive(rawType.getType) && ref.getType.getName.eq("scala.Array")
  }
}