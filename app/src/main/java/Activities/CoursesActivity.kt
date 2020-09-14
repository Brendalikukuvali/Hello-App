package Activities

import android.os.Bundle
import android.preference.PreferenceManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.hello.*
import database.HelloDatabase
import kotlinx.android.synthetic.main.activity_courses.*
import okhttp3.Call
import okhttp3.Callback
import okhttp3.MultipartBody
import okhttp3.Response


class CoursesActivity : AppCompatActivity(), CourseItemClickListener {

    lateinit var database: HelloDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_courses)

        database = Room.databaseBuilder(baseContext, HelloDatabase::class.java, "hello-db").build()

        fetchCourses()


    }

    private fun fetchCourses() {
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(baseContext)
        val accessToken = sharedPreferences.getString("ACCESS_TOKEN_KEY", "")

        val apiClient = APiClient.buildService(ApiInterface::class.java)
        val coursesCall = apiClient.getCourses("Bearer $accessToken").also {


            it.enqueue(object :<CoursesActivity> {
                fun onFailure(call: <CoursesActivity>, t: Throwable) {
                    Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()

                    fetchCoursesFromDatabase()
                }

                fun onResponse(
                    call: Call<CoursesActivity>,
                    response: Response<CoursesActivity>
                ) {
                    if (response.isSuccessful) {
                        var courseList = response.body()?.courses as List<Course>
                        Thread {
                            courseList.forEach { course ->
                                database.courseDao().insertCourse(course)
                            }
                        }.start()

                        displayCourses(courseList)
                    } else {
                        Toast.makeText(baseContext, response.errorBody().toString(), Toast.LENGTH_LONG)
                            .show()
                    }
                }
            })
        }
    }

    fun fetchCoursesFromDatabase() {
        Thread {
            val courses = database.courseDao().getAllCourses()

            runOnUiThread {
                displayCourses(courses)
            }
        }.start()
    }

    fun displayCourses(courses: List<Course>) {
        var coursesAdapter = CoursesAdapter(courses, this)
        rvCourses.layoutManager = LinearLayoutManager(baseContext)
        rvCourses.adapter = coursesActivity
    }

    override fun onItemClick(course: Course) {

        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(baseContext)
        val accessToken = sharedPreferences.getString("ACCESS_TOKEN_KEY", "")
        val studentId = sharedPreferences.getString("STUDENT_ID_KEY", "")
        var courseId = course.courseId

        var requestBody = MultipartBody.Builder()
            .setType(MultipartBody.FORM)
            .addFormDataPart("course_id", courseId)
            .addFormDataPart("student_id", studentId!!)
            .build()


        val apiClient = APiClient.buildService(ApiInterface::class.java)
        val coursesCall = apiClient.registerCourse(requestBody,"Bearer $accessToken")


        coursesCall.enqueue(object : <RegisterationActivity> {
            override fun onFailure(call: Call<RegisterationActivity>, t: Throwable) {
                TODO("Not yet implemented")
            }

            override fun onResponse(
                call: Call<RegisterationActivity>,
                response: Response<RegisterationActivity>
            ) {
                if(response.isSuccessful){
                    Toast.makeText(this@CoursesActivity, "Registered", Toast.LENGTH_SHORT).show()
                }
            }


        })
    }

}

private infix fun Any.RegisterationActivity(any: Any): Callback<RegisterationActivity>? {

}

private infix fun Any.CoursesActivity(any: Any): Callback<CoursesResponse>? {

}

class RegisterationActivity {

}

interface CourseItemClickListener {
    abstract t: Any
    abstract val coursesActivity: RecyclerView.Adapter<RecyclerView.ViewHolder>?

    abstract fun CoursesAdapter(courses: List<Course>, coursesActivity: CoursesActivity): Any

}








