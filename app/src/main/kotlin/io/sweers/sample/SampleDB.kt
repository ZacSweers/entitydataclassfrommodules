package io.sweers.sample

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Database
import android.arch.persistence.room.Query
import android.arch.persistence.room.RoomDatabase

@Database(
    version = 1,
    entities = arrayOf(
        SampleEntity::class
    )
)
abstract class SampleDB : RoomDatabase() {
  abstract fun sampleDao(): SampleDao
}

@Dao
interface SampleDao {

  @Query("SELECT * FROM samples WHERE id = :id")
  fun foo(id: Long): SampleEntity
}

// Condition A
// This will work because it's in the same compilation unit
//@Entity(tableName = "samples")
//data class SampleEntity(
//    @PrimaryKey val id: Long,
//    val name: String,
//    val optionalName: String? = null
//)
