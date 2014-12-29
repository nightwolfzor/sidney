sidney
======

Sidney is an experimental serializer, state of the art encoding techniques and code generation. 

It's named after my dog Sid.

Currently a WIP, not usable at all to anyone. 

Planned features: 

* Columnar storage of field values using state of the art encoding techniques
* Code generation on hot paths to avoid megamorphic call sites (if benchmarking shows that it actually does anything)
* Roaring bitmaps to encode null values

Not intended for any sort of long term storage, its main use case is in something like Apache Spark for RDD serialization.

State: 

Encodings: 

Boolean: Bit Packed / Ewah DONE

Int32: Bit Packed / BitPacking-Delta / Plain DONE / RLE PLANNED

Int64: Plain / GroupVarInt : DONE

Float32: Plain: DONE / RLE: PLANNED

Float64: Plain: DONE / RLE: PLANNED

String: Plain / Delta Length / CharAsInt : DONE
