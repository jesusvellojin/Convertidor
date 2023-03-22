package com.jesumoreno.convertidor.signup

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ConvertidoViewModel:ViewModel() {

    val conversion: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
    val errorBasio: MutableLiveData<String?> by lazy {
        MutableLiveData<String?>()
    }
    val delTex: MutableLiveData<String?> by lazy {
        MutableLiveData<String?>()
    }


    fun convertir(moneda: String, peso1: Boolean, peso2: Boolean, dolar1: Boolean, dolar2: Boolean, euro1: Boolean, euro2: Boolean) {
        errorBasio.value= null
        delTex.value=null

        if (moneda.isEmpty()) {
            errorBasio.value= "La casilla está vacía"
            //signUpBinding.monedaLayout.error = "La casilla está vacía"
        } else {
            if (peso1 && dolar2) {
                //conversion.value = (moneda.toDouble() * 0.00021)
                conversion.value = (moneda.toDouble() * 0.00021).toString() + " Dolar"
            } else if (peso1 && euro2) {
                conversion.value = (moneda.toDouble() * 0.00020).toString() + " Euro"

            } else if (peso1 && peso2) {
                conversion.value = moneda + " Pesos colombianos"
            } else if (dolar1 && peso2) {
                conversion.value = (moneda.toDouble() * 4850.50).toString() + " Pesos colombianos"

            } else if (dolar1 && euro2) {
                conversion.value = (moneda.toDouble() * 0.93).toString() + " Euros"

            } else if (dolar1 && dolar2) {
                conversion.value = moneda + " Dolar"

            } else if (euro1 && peso2) {
                conversion.value = (moneda.toLong() * 5229.08).toString() + " Pesos Colombianos"

            } else if (euro1 && dolar2) {
                conversion.value = (moneda.toDouble() * 1.08).toString() + " Dolar"

            } else {
                conversion.value = moneda + " Euro"

            }
        }
    }
}
//final