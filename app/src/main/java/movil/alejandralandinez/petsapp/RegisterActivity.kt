package movil.alejandralandinez.petsapp

import android.content.Context
import android.content.SharedPreferences
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioGroup
import kotlinx.android.synthetic.main.activity_reg_mascota.*
import kotlinx.android.synthetic.main.activity_register.*
import movil.alejandralandinez.petsapp.databinding.ActivityRegisterBinding
import movil.alejandralandinez.petsapp.models.Mascota
import movil.alejandralandinez.petsapp.models.Usuario

import movil.alejandralandinez.petsapp.util.text
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class RegisterActivity : AppCompatActivity() {

    var sex=""
    var imagen=""
    val preferences: SharedPreferences by lazy{ getSharedPreferences("preferencias", Context.MODE_PRIVATE) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityRegisterBinding = DataBindingUtil
                .setContentView(this, R.layout.activity_register)

        binding.handler1 = this



        if(radioGroup.checkedRadioButtonId != -1){
            if (gMujer.isChecked){
                sex = "m"
                imagen = "https://www.sportdata.org/wkf/competitor_pics/19885.jpg"
            }
            if(gHombre.isChecked){
                sex = "f"
                imagen="https://i.ytimg.com/vi/sa26yDGqD5I/maxresdefault.jpg"
            }
        }
    }



    fun next() {
        val nombre= name.text()
        val username = username.text()
        val contrasena = password.text()
        val edad = age.text()
        val contacto = contact.text()
        /*if(age.toString().toInt()<18 || age.toString().toInt()>100){
            if(edad.toInt()<18) toast("Debe ser mayor de 18 años para continuar")
            if(edad.toInt()>100) toast("Ingrese una edad válida")
        }else {*/

        preferences.edit().putString("name",nombre).apply()
        preferences.edit().putString("username",username).apply()
        preferences.edit().putString("contrasena",contrasena).apply()
        preferences.edit().putString("edad",edad).apply()
        preferences.edit().putString("contacto",contacto).apply()
        preferences.edit().putString("sexo",sex).apply()
        preferences.edit().putString("imagen",imagen).apply()

        startActivity<RegMascotaActivity>()
        finish()
        //}

    }
}
