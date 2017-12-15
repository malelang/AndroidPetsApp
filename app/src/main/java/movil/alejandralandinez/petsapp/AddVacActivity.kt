package movil.alejandralandinez.petsapp

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_add_vac.*
import movil.alejandralandinez.petsapp.databinding.ActivityAddVacBinding
import movil.alejandralandinez.petsapp.models.Vacuna
import movil.alejandralandinez.petsapp.util.Data

class AddVacActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding:ActivityAddVacBinding = DataBindingUtil.setContentView(this,R.layout.activity_add_vac)
        binding.handleraddvac = this
    }

    fun addvacuna(){
        val fecha = fechaaddvac.toString()
        val enfermedad = sickaddvac.toString()
        val doctor = doctoraddvac.toString()
        val vac = Vacuna(fecha,enfermedad,doctor)
        Data.vacunas.add(vac)
        finish()
    }
}
