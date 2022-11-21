package com.martin.binarrelative

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.*
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatSpinner
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.view.get

class Login : AppCompatActivity() {

    lateinit var option: AppCompatSpinner
    lateinit var tvResult: AppCompatTextView
    lateinit var etNumber: AppCompatEditText
    lateinit var button1: AppCompatButton
    lateinit var relTwo: RelativeLayout

    val options = arrayOf("Choose a country", "Indonesia", "Malaysia", "Singapore")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        setUpView()
        setSpinnerObject()
        setUpAction()
        showKeyboard(etNumber)
    }

    private fun setUpView() {

        tvResult = findViewById(R.id.tv_result)
        etNumber = findViewById(R.id.editTextPhone)
        button1 = findViewById(R.id.btn_next)
        option = findViewById(R.id.spinnerCountry)
        relTwo = findViewById(R.id.RelTwo)
    }

    private fun setUpAction() {

        // setSpinnerObject()

        val adapter2 = ArrayAdapter<String>(
            this,
            androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
            options
        )
        option.adapter = adapter2

        button1.setOnClickListener {
            val inputSpinner = tvResult.text

            val inputNumber = etNumber.text.toString()

            Toast.makeText(
                this,
                "Your number is $inputNumber and your country is $inputSpinner",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    private fun setSpinnerObject() {
        option.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                adapterView: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                hideKeyboard(etNumber)
                adapterView?.getItemAtPosition(position).toString()
                tvResult.text = adapterView?.getItemAtPosition(position).toString()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                print("Nothing is selected")
            }
        }
    }

    private fun showKeyboard(view: View){
        val imm:InputMethodManager = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        etNumber.requestFocus()
        imm.showSoftInput(relTwo,0)
    }

    /*fun Context.showKeyboard() {
        etNumber.requestFocus()
        val inputMethodManager = getSysService<InputMethodManager>(Context.INPUT_METHOD_SERVICE)
        inputMethodManager?.toggleSoftInput(
            InputMethodManager.SHOW_IMPLICIT,
            InputMethodManager.HIDE_IMPLICIT_ONLY
        )
    }*/

    fun Context.hideKeyboard(view: View) {
        val inputManager = getSysService<InputMethodManager>(Context.INPUT_METHOD_SERVICE)
        inputManager?.hideSoftInputFromWindow(view.windowToken, 0)
    }

    inline fun <reified T> Context.getSysService(systemService: String): T? {
        return getSystemService(systemService) as T
    }


}