package com.example.hello

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_courses.*



class CoursesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_courses)
    }
        data class Coursesactivity(val courses_id:Int, val courses_name:String, val course_code:Int, val instructor:String, val Description:String)
        class coursesactivity : AppCompatActivity() {
            override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
                setContentView(R.layout.activity_courses)
                rvCourses.layoutManager = LinearLayoutManager(baseContext)
                val CoursesAdapter = CoursesRecyclerViewAdapter(
                    listOf(

                        Coursesactivity(0, "Kotlin", 11, "Brenda", "Kotlin project1"),
                        Coursesactivity(1, "Java", 12, "Anne", "Java project2"),
                        Coursesactivity(2, "Html", 13, "Angel", "Html project3"),
                        Coursesactivity(4, "Css", 14, "Bella", "Css project4"),
                        Coursesactivity(5, "Python", 15, "Lisa", "Design project5"),
                        Coursesactivity(6, "Django", 16, "Felisters", "Electonics project6"),
                        Coursesactivity(7, "Kotlin", 17, "Gabriella", "Python project6"),
                        Coursesactivity(8, "Javascript", 18, "Nancy", "Machine project7"),
                        Coursesactivity(9, "Java", 19, "Shantel", "Kotli2 project9"),
                        Coursesactivity(10, "Css", 20, "Valencia", "Python2 project9")

                    )
                )

                rvCourses.adapter = CoursesAdapter

            }

        }    }













