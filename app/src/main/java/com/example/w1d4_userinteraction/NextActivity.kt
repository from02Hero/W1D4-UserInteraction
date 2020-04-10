package com.example.w1d4_userinteraction

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_next.*

class NextActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_next)

        val person: Person? = intent.getParcelableExtra("person")
        person?.let {
            name.text = it.name
            age.text = it.age.toString()
        }
        switch1.setOnClickListener {
            val replyIntent = Intent()
            replyIntent.putExtra("approval", true)
            setResult(Activity.RESULT_OK, replyIntent)
            finish()
        }
    }
}
