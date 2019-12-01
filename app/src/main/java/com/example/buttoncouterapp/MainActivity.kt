package com.example.buttoncouterapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.text.method.ScrollingMovementMethod
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private var TAG = "LOGCAT: "
    private var TEXT_CONTENTS = null

    private var button: Button? = null
    private var textView: TextView?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate")
        setContentView(R.layout.activity_main)
        val editText: EditText = findViewById<EditText>(R.id.editText)
        button = findViewById<Button>(R.id.button)
        textView = findViewById<TextView>(R.id.textView)

        textView?.movementMethod = ScrollingMovementMethod()

        button?.setOnClickListener {
            var typedText: String = editText.text.toString()
            textView?.append(" $typedText \n")
            Log.d(TAG, "onClick invoked")
        }
    }
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        Log.d(TAG, "onRestoreInstance invoked")
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        outState?.putString(TEXT_CONTENTS, textView?.text.toString())
    }

}
