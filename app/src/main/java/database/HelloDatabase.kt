package database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.hello.Course

@Database(entities = arrayOf(Course::class)),
abstract class HelloDatabase: RoomDatabase()
    fun  courseDao()
}