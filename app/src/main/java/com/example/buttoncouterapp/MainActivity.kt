package com.example.buttoncouterapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private var button: Button? = null
    private var textView: TextView?= null

    private var buttonLand: Button?= null
    private var textViewLand: TextView?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setContentView(R.layout.landscape_layout)

        val editText: EditText = findViewById<EditText>(R.id.editText)
        val editTextLand: EditText = findViewById<EditText>(R.id.editTextLand)
        textViewLand = findViewById<TextView>(R.id.textViewLand)

        button = findViewById<Button>(R.id.button)
        textView = findViewById<TextView>(R.id.textView)

        textView?.movementMethod = ScrollingMovementMethod()

        button?.setOnClickListener {
            var typedText: String = editText.text.toString()
            textView?.append(" $typedText \n")
        }
        //landscape
        buttonLand = findViewById<Button>(R.id.buttonLand)
        buttonLand?.setOnClickListener {
            var typedTextLand: String = editTextLand.text.toString()
            textViewLand?.append("$typedTextLand \n")
        }
    }
}
