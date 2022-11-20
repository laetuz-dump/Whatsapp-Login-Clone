package com.martin.binarrelative

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


   // val btnFB:LinearLayout = findViewById(R.id.BtnLoginFB)



    fun btnFaceBook(){
    }

    fun btnPhone(){
        val btnPhone:LinearLayout = findViewById(R.id.BtnLoginPhone)

        btnPhone.setOnClickListener {
            Intent(this,Login::class.java).also { startActivity(it) }

        }
    }


}