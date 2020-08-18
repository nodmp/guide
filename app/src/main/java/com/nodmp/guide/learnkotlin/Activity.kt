package com.nodmp.guide.learnkotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


open class Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    open fun helloword() {
    }
}
class App : Activity() {
    override  fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    final override fun helloword() {

    }
}