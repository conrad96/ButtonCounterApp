package com.example.buttoncouterapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private var editText: EditText? = null
    private var button: Button? = null
    private var textView: TextView?= null
    private var num = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText = findViewById<EditText>(R.id.editText)
        button = findViewById<Button>(R.id.button)
        textView = findViewById<TextView>(R.id.textView)

        textView?.movementMethod = ScrollingMovementMethod()

        button?.setOnClickListener {
            num++
            textView?.append("Clicked $num times \n")
        }
    }
}
