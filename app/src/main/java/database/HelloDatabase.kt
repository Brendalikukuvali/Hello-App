package database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.hello.Course

@Database(entities = arrayOf(Course::class), version = 1)
abstract class HelloDatabase: RoomDatabase() {
    abstract fun courseDao(): CourseDao
}