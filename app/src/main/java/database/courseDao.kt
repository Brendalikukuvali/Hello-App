package database;

import androidx.room.Insert
import androidx.room.OnConflictStrategy

interface courseDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCourse(course:Course)
}