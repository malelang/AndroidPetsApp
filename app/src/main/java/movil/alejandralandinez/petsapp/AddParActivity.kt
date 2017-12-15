package movil.alejandralandinez.petsapp

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_add_par.*
import movil.alejandralandinez.petsapp.databinding.ActivityAddParBinding
import movil.alejandralandinez.petsapp.models.Parasito
import movil.alejandralandinez.petsapp.util.Data
import movil.alejandralandinez.petsapp.util.text

class AddParActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding:ActivityAddParBinding = DataBindingUtil.setContentView(this, R.layout.activity_add_par)
        binding.handlerpar = this
    }

    fun addparasito(){
        val fecha = fechaaddpar.text().toString()
        val peso = peso.text().toString()
        val producto = productoaddpar.text().toString()
        val proxima = proximaaddpar.text().toString()
        val par = Parasito(fecha, peso, producto,proxima)
        Data.parasitos.add(par)
        finish()
    }
}
