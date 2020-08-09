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
                CoursesActivityRecyclerViewAdapter(
                    coursesActivity = listOf(
                        Coursesactivity(0, "mercy", 11, "Brenda", "Kotlin project1"),
                        Coursesactivity(1, "mercy", 12, "Anne", "Java project2"),
                        Coursesactivity(2, "mercy", 13, "Angel", "Html project3"),
                        Coursesactivity(4, "mercy", 14, "Bella", "Css project4"),
                        Coursesactivity(5, "mercy", 15, "Lisa", "Design project5"),
                        Coursesactivity(6, "mercy", 16, "Felisters", "Electonics project6"),
                        Coursesactivity(7, "mercy", 17, "Gabriella", "Python project6"),
                        Coursesactivity(8, "mercy", 18, "Nancy", "Machine project7"),
                        Coursesactivity(9, "mercy", 19, "Shantel", "Kotli2 project9"),
                        Coursesactivity(10, "mercy", 20, "Valencia", "Python2 project9")

                    )
                );


                val rvCoursesActivity = null
                val coursesAdapter = null
                val value: Nothing? = rvCoursesActivity



            }

            private fun CoursesActivityRecyclerViewAdapter(
                listOf: List<Any>,
                coursesActivity: List<Coursesactivity>
            ) = Unit

        }
    }













