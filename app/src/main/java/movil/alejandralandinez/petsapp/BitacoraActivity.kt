package movil.alejandralandinez.petsapp

import android.support.v4.app.Fragment
import android.databinding.DataBindingUtil
import android.graphics.drawable.DrawableContainer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_bitacora.*
import movil.alejandralandinez.petsapp.databinding.ActivityBitacoraBinding
import movil.alejandralandinez.petsapp.fragments.BitacoraFragment
import movil.alejandralandinez.petsapp.fragments.ParasitoFragment
import movil.alejandralandinez.petsapp.models.Vacuna

class BitacoraActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bitacora)

        putVacunasFragment(R.id.containervacunas,BitacoraFragment.instance())
        putParasitosFragment(R.id.containerparasitos,ParasitoFragment.instance())
    }

    fun putVacunasFragment(container:Int, fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(container,fragment).commit()
    }

    fun putParasitosFragment(container: Int,fragment: Fragment){
        supportFragmentManager.beginTransaction().replace(container,fragment).commit()
    }
}
