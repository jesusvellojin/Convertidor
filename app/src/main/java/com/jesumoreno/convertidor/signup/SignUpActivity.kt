package com.jesumoreno.convertidor.signup


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.jesumoreno.convertidor.databinding.ActivitySignUpBinding


class SignUpActivity : AppCompatActivity() {
    private  lateinit var signUpBinding:ActivitySignUpBinding
    private  lateinit var convertidoViewModel: ConvertidoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        signUpBinding = ActivitySignUpBinding.inflate(layoutInflater)
        convertidoViewModel=ViewModelProvider(this)[ConvertidoViewModel::class.java]
        val view = signUpBinding.root
        setContentView(view)

        val conversionObserver = Observer<String>{ conversion ->
            signUpBinding.resultadoTextView.text= "$: $conversion"

        }
        val erroBasioObserver = Observer<String?>{ erroBasio ->
            signUpBinding.monedaLayout.error= erroBasio

        }
        val deltexObserver = Observer<String?>{ erroBasio ->
            signUpBinding.resultadoTextView.setText(erroBasio)

        }

        convertidoViewModel.conversion.observe(this, conversionObserver)
        convertidoViewModel.errorBasio.observe(this, erroBasioObserver)
        convertidoViewModel.delTex.observe(this, deltexObserver)


        signUpBinding.calcularButton.setOnClickListener {
            val moneda = signUpBinding.monedaTextoEditLayout.text.toString()
            val peso1 =signUpBinding.pesoRadioButton1.isChecked
            val peso2 =signUpBinding.pesoRadioButton2.isChecked
            val dolar1=signUpBinding.dolarRadioButton1.isChecked
            val dolar2=signUpBinding.dolarRadioButton2.isChecked
            val euro1=signUpBinding.euroRadioButton1.isChecked
            val euro2=signUpBinding.euroRadioButton2.isChecked
            convertidoViewModel.convertir(moneda,peso1,peso2,dolar1,dolar2,euro1,euro2)
        }



    }

}