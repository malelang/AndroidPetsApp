package movil.alejandralandinez.petsapp

import android.content.Context
import android.content.SharedPreferences
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_login.*
import movil.alejandralandinez.petsapp.databinding.ActivityLoginBinding
import movil.alejandralandinez.petsapp.models.Mascota
import movil.alejandralandinez.petsapp.models.Usuario
import movil.alejandralandinez.petsapp.net.AppClient
import movil.alejandralandinez.petsapp.net.SimpleResponse
import org.jetbrains.anko.startActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import movil.alejandralandinez.petsapp.util.text
import org.jetbrains.anko.toast

class LoginActivity : AppCompatActivity(), Callback<SimpleResponse> {

    companion object {
        const val DEVELOPER_TAG = "developertag"
    }
    val preferences: SharedPreferences by lazy{ getSharedPreferences("preferencias", Context.MODE_PRIVATE) }
    var username=""
    var password=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val logged=preferences.getBoolean("logged",false)
        if(logged){
            startActivity<MainActivity>()
            finish()
            return
        }
        val binding: ActivityLoginBinding = DataBindingUtil
                .setContentView(this, R.layout.activity_login)

        binding.handler = this
    }


    fun login(){
        username=user.text()
        password=pass.text()
        AppClient.userapi.loguser(username,password).enqueue(this)

    }

    fun signin(){
        startActivity<RegisterActivity>()

    }

    override fun onResponse(call: Call<SimpleResponse>?, response: Response<SimpleResponse>?) {
        toast("Usuario encontrado. Iniciando sesión...")
        preferences.edit().putBoolean("logged",true).apply()
        startActivity<MainActivity>()
    }

    override fun onFailure(call: Call<SimpleResponse>?, t: Throwable?) {
        toast("Usuario no encontrado. Intente de nuevo")
    }
    }

