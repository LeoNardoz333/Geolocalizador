package com.example.geolocalizadorpro.ui.administrador

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AdministradorViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Login Administradores"
    }
    val text: LiveData<String> = _text
}