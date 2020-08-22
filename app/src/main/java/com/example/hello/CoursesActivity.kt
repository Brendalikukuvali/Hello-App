package com.example.hello

import android.os.Bundle
import android.preference.PreferenceManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_courses.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class CoursesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_courses)
        setContentView(R.layout.activity_courses)
        var courseList = listOf<courses>(

                    Courses(0, "Kotlin", 11, "Brenda", "Kotlin project1"),
                    Courses(1, "Java", 12, "Anne", "Java project2"),
                    Courses(2, "Html", 13, "Angel", "Html project3"),
                    Courses(4, "Css", 14, "Bella", "Css project4"),
                    Courses(5, "Python", 15, "Lisa", "Design project5"),
                    Courses(6, "Django", 16, "Felisters", "Electonics project6"),
                    Courses(7, "Kotlin", 17, "Gabriella", "Python project6"),
                    Courses(8, "Javascript", 18, "Nancy", "Machine project7"),
                    Courses(9, "Java", 19, "Shantel", "Kotli2 project9"),
                    Courses(10, "Css", 20, "Valencia", "Python2 project9")


            )
            rvCourses.layoutManager = LinearLayoutManager(baseContext)
            rvCourses.adapter = CoursesAdapter(coursesList)

            fetchCourses()
        }

        fun fetchCourses() {
            val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(baseContext)
            val accessToken = sharedPreferences.getString("ACCESS_TOKEN_KEY", "")

            val apiClient = APiClient.buildService(ApiInterface::class.java)
            val coursesCall = apiClient.getCourses("Bearer " + accessToken)
            coursesCall.enqueue(object : Callback<CourseResponse> {
                override fun onFailure(call: Call<CourseResponse>, t: Throwable) {
                    Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
                }

                override fun onResponse(
                    call: Call<CoursesResponse>,
                    response: Response<CoursesResponse>
                ) = if (response.isSuccessful) {
                    var courseList = response.body()?.courses as List<courses>
                    var coursesAdapter = (courseList)
                    rvCourses.layoutManager = LinearLayoutManager(baseContext)
                    rvCourses.adapter = CoursesAdapter
                } else {
                    Toast.makeText(baseContext, response.errorBody().toString(), Toast.LENGTH_LONG)
                        .show()
                }
            })
        }
    }
}










