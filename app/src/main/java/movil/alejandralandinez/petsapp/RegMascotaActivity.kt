package movil.alejandralandinez.petsapp

import android.content.Context
import android.content.SharedPreferences
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import kotlinx.android.synthetic.main.activity_reg_mascota.*
import movil.alejandralandinez.petsapp.databinding.ActivityRegMascotaBinding
import movil.alejandralandinez.petsapp.models.Mascota
import movil.alejandralandinez.petsapp.models.Usuario
import movil.alejandralandinez.petsapp.net.AppClient
import movil.alejandralandinez.petsapp.net.SimpleResponse


import movil.alejandralandinez.petsapp.util.text

import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegMascotaActivity : AppCompatActivity(), Callback<SimpleResponse> {



    val preferences: SharedPreferences by lazy{ getSharedPreferences("preferencias", Context.MODE_PRIVATE) }
    var tipo=""
    var petsex=""
    var nombre=""
    var username=""
    var contrasena=""
    var edad=""
    var contacto=""
    var sexo =""
    var imagen=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityRegMascotaBinding = DataBindingUtil.setContentView(this, R.layout.activity_reg_mascota)
        nombre=preferences.getString("name","").toString()
        username=preferences.getString("username","").toString()
        contrasena=preferences.getString("contrasena","").toString()
        edad=preferences.getString("edad","").toString()
        contacto=preferences.getString("contacto","").toString()
        sexo=preferences.getString("sexo","").toString()
        imagen=preferences.getString("imagen","").toString()


        binding.handregmasc = this

        //region RadiobuttonType
        if (radioGroup2.checkedRadioButtonId != -1) {
            if (typedog.isChecked) {
                tipo = "p"
            }
            if (typecat.isChecked) {
                tipo = "g"
            }
        }
        //endregion

        //region RadiobuttonSex
        if (radioGroup3.checkedRadioButtonId != -1) {
            if (sexmale.isChecked) {
                petsex = "m"
            }
            if (sexfemale.isChecked) {
                petsex = "h"
            }
        }
        //endregion



    }

    fun finalizar() {
        val petnombre = petname.text()
        val petedad = petage.text()
        val petraza = spinner.text()
        val mascota = Mascota(petnombre,petraza,petedad,"",tipo,petsex)
        val usuario = Usuario(nombre,username,contrasena,edad,contacto,sexo,imagen,mascota)
        Log.i(LoginActivity.DEVELOPER_TAG, "Crear usuario con: "+nombre+" mascota de nombre "+mascota.nombre)
        AppClient.userapi.insert(usuario).enqueue(this)

    }

    override fun onFailure(call: Call<SimpleResponse>?, t: Throwable?) {
        toast("Error al ingresar usuario, intente de nuevo")
        finish()
    }

    override fun onResponse(call: Call<SimpleResponse>?, response: Response<SimpleResponse>?) {
        toast("Usuario agregado!")
        startActivity<LoginActivity>()
    }



}
