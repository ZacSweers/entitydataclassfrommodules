package io.sweers.sample

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

// This won't work when consumed from the :app module because of the `val` properties and no constructor for nonnull
// This _does_ work if used in the same module as :app though
// This is condition B
//@Entity(tableName = "samples")
//data class SampleEntity(
//    @PrimaryKey val id: Long,
//    val name: String,
//    val optionalName: String? = null
//)

// This is condition C
// This is the only way that works from external modules right now
@Entity(tableName = "samples")
data class SampleEntity(
    @PrimaryKey var id: Long,
    var name: String,
    var optionalName: String? = null
) {
  constructor() : this(0, "")
}
