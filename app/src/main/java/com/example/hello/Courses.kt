package com.example.hello

import com.google.gson.annotations.SerializedName

data class Course(
    var courseId: String,
    var courseName: String,
    var courseCode: String,
    var instructor: String,
    var description: String
    @SerializedName("course_id") var courseId: String,
    @SerializedName("course_name") var courseName: String,
    @SerializedName("course_code") var courseCode: String,
    @SerializedName("instructor") var instructor: String,
    @SerializedName("description") var description: String
)