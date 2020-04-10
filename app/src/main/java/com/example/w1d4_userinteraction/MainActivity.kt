package com.example.w1d4_userinteraction

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.w1d4_userinteraction.NextActivity.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var name: String
    var age: Int = 0

    object APPROVAL_REQUEST {
        val REQUEST = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun submit(view: View) {
        name = nameText.text.toString()

        if (ageText.text.toString().isNotEmpty()) {
            age = Integer.parseInt(ageText.text.toString())
        }

        if (name.isNotEmpty() && age > 0) {
            val person = Person(name, age)
            val intent = Intent(this, NextActivity::class.java)
            intent.putExtra("person", person)
            startActivityForResult(intent, APPROVAL_REQUEST.REQUEST)
        } else {
            Toast.makeText(applicationContext,"Name or age is invalid",Toast.LENGTH_SHORT).show()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == APPROVAL_REQUEST.REQUEST) {
            if (resultCode == Activity.RESULT_OK) {
                val reply = data?.getBooleanExtra("approval", false)
                Toast.makeText(applicationContext, "Approval $reply", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
