package com.example.hello


import com.example.Student
import com.google.gson.annotations.SerializedName

data class RegistrationResponse (
    @SerializedName ("message") var message: String,
    @SerializedName("student") var student: Student
)
