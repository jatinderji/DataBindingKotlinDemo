package com.jatin.databindingkotlindemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SecondActivity : AppCompatActivity() {

   lateinit var name:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        name = findViewById(R.id.textView)
        // no need to call      getIntent().getStringExtra("name")
        name.text = "Hey, Welcome "+intent.getStringExtra("name")
    }
}