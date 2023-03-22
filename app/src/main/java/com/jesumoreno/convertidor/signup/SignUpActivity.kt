package com.jesumoreno.convertidor.signup

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.jesumoreno.convertidor.R
import com.jesumoreno.convertidor.databinding.ActivityMainBinding
import com.jesumoreno.convertidor.databinding.ActivitySignUpBinding
import kotlin.concurrent.thread

class SignUpActivity : AppCompatActivity() {
    private  lateinit var signUpBinding:ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        signUpBinding = ActivitySignUpBinding.inflate(layoutInflater)
        val view = signUpBinding.root
        setContentView(view)


        signUpBinding.calcularButton.setOnClickListener {
            signUpBinding.resultadoTextView.setText(null)

            val moneda = signUpBinding.monedaTextoEditLayout.text.toString()

            if (moneda.isEmpty()) {
                signUpBinding.monedaLayout.error = "La casilla está vacía"
            } else {
                if (signUpBinding.pesoRadioButton1.isChecked && signUpBinding.dolarRadioButton2.isChecked) {
                    val conversion = (moneda.toDouble() * 0.00021)
                    //Log.d("convercion",conversion.toString());
                    signUpBinding.resultadoTextView.text = "\$: $conversion Dolares"
                }
                else if (signUpBinding.pesoRadioButton1.isChecked && signUpBinding.euroRadioButton2.isChecked) {
                    val conversion = (moneda.toDouble() * 0.00020)
                    signUpBinding.resultadoTextView.text = "\$: $conversion Euros"
                }
                else if (signUpBinding.pesoRadioButton1.isChecked && signUpBinding.pesoRadioButton1.isChecked) {

                    signUpBinding.resultadoTextView.text = "\$: $moneda Pesos Colombianos"
                }
                else if (signUpBinding.dolarRadioButton1.isChecked && signUpBinding.pesoRadioButton2.isChecked) {
                    val conversion = (moneda.toDouble() * 4850.50)
                    signUpBinding.resultadoTextView.text = "\$: $conversion Pesos Colombianos"
                }
                else if (signUpBinding.dolarRadioButton1.isChecked && signUpBinding.euroRadioButton2.isChecked) {
                    val conversion = (moneda.toDouble() * 0.93)
                    signUpBinding.resultadoTextView.text = "\$: $conversion Euros"
                }
                else if (signUpBinding.dolarRadioButton1.isChecked && signUpBinding.dolarRadioButton2.isChecked) {

                    signUpBinding.resultadoTextView.text = "\$: $moneda Dolares"
                }
                else if (signUpBinding.euroRadioButton1.isChecked && signUpBinding.pesoRadioButton2.isChecked) {
                    val conversion = (moneda.toLong() * 5229.08)
                    signUpBinding.resultadoTextView.text = "\$: $conversion Pesos Colombianos"
                }
                else if (signUpBinding.euroRadioButton1.isChecked && signUpBinding.dolarRadioButton2.isChecked) {
                    val conversion = (moneda.toDouble() * 1.08)
                    signUpBinding.resultadoTextView.text = "\$: $conversion Dolares"
                }
                else  {

                    signUpBinding.resultadoTextView.text = "\$: $moneda Euros"

                }

            }
        }



    }

}