package movil.alejandralandinez.petsapp

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_add_par.*
import movil.alejandralandinez.petsapp.databinding.ActivityAddParBinding
import movil.alejandralandinez.petsapp.models.Parasito

class AddParActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding:ActivityAddParBinding = DataBindingUtil.setContentView(this, R.layout.activity_add_par)
        binding.handlerpar = this
    }

    fun addparasito(){
        val fecha = fechaaddpar.toString()
        val peso = peso.toString()
        val producto = productoaddpar.toString()
        val proxima = proximaaddpar.toString()
        val par = Parasito(fecha, peso, producto,proxima)
    }
}
