package com.martin.binarrelative

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.widget.Button
import android.widget.TextView

class WhatsappMain : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_whatsapp_main)

        val btnAgree:Button = findViewById(R.id.btn_agree)
        setupHyperlink()

        btnAgree.setOnClickListener { Intent(this, Login::class.java).also { startActivity(it) } }
    }

    private fun setupHyperlink() {
        val linkTextView = findViewById<TextView>(R.id.tvDescWa)
        linkTextView.movementMethod = LinkMovementMethod.getInstance()
    }
}