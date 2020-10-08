package com.jatin.databindingkotlindemo

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.jatin.databindingkotlindemo.databinding.ActivityMainBinding

/*
In Build.gradle app:
under android block add following code:

    dataBinding{ enabled= true }
    then sync
----------------------------
If error use second way:

In Build.gradle app:
under android block add following code:

    buildFeatures{
        dataBinding true
    }
----------------------------
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


       // setContentView(R.layout.activity_main)

        val binding : ActivityMainBinding =
            DataBindingUtil.setContentView(this,R.layout.activity_main)

        // binding.myTitle.text = "Data Binding"
        binding.demoTitle = "Binded Title"

        binding.btnExplicit.setOnClickListener {
            val intent:Intent = Intent(this,SecondActivity::class.java)
            intent.putExtra("name",binding.userName.text.toString())
            startActivity(intent)
        }
        binding.btnSms.setOnClickListener {
            val uri = Uri.parse("smsto:+919888600809")
            val intent:Intent = Intent(Intent.ACTION_SENDTO,uri)
            intent.putExtra("sms_body", "Hii dear how are you?");
            startActivity(intent)
        }
        binding.btnBrowser.setOnClickListener {
            val uri = Uri.parse("https://www.google.com")
            val intent:Intent = Intent(Intent.ACTION_VIEW,uri)
            startActivity(intent)
        }

    }
}