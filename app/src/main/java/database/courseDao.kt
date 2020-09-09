package database;

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.hello.Course

@Dao
interface CourseDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCourse(course: Course)
    @Query("SELECT * FROM courses")
    fun getAllCourses(): List<Course>
}
