Details:

Important classes are `SampleDB.kt` and `SampleEntity.kt`.

In `SampleDB.kt` you'll find the room db scaffolding along with a `SampleEntity` data class implementation commented out. Call this condition `A`

In `SampleEntity.kt`, there are two different implementations of the `SampleEntity` data class. 

One is a standard data class with `val` properties and no extra constructors, it is also commented out. Call this condition `B`.

The other is the same data class but with `var` properties and extra constructors for non-defaulting properties. Call this condition `C`.

The issue is that only `C` works if being consumed from an external module. This is unfortunate because `C` is not a very ideal data class with is mutable properties and boilerplate constructors (they aren't actually used at runtime in my experience).

If you use `B` (with the others commented out), it will fail because it can't find setters for the `val` variables nor an appropriate constructor for it.

If you use `A` (with the others commented out), it will work because it's in the same module.

Ideal case is that `B` should work, as it's the conventional way data classes are written in Kotlin and does work if it's from the same module.
