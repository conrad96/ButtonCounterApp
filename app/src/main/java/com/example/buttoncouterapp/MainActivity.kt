package com.example.buttoncouterapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.text.method.ScrollingMovementMethod
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

private const val TEXT_CONTENTS = "TextContents"
private var TAG = "LOGCAT: "

class MainActivity : AppCompatActivity() {
    private var button: Button? = null
    private var textView: TextView?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val editText: EditText = findViewById<EditText>(R.id.editText)
        button = findViewById<Button>(R.id.button)
        textView = findViewById<TextView>(R.id.textView)
        textView?.movementMethod = ScrollingMovementMethod()
        button?.setOnClickListener {
            var typedText: String = editText.text.toString()
            textView?.append(" $typedText \n")
        }
    }
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        textView?.text = savedInstanceState.getString(TEXT_CONTENTS, "")
    }
    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        outState.putString(TEXT_CONTENTS, textView?.text.toString())
    }
}
