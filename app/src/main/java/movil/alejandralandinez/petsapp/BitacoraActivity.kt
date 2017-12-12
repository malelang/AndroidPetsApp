package movil.alejandralandinez.petsapp

import android.support.v4.app.Fragment
import android.databinding.DataBindingUtil
import android.graphics.drawable.DrawableContainer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_bitacora.*
import movil.alejandralandinez.petsapp.databinding.ActivityBitacoraBinding
import movil.alejandralandinez.petsapp.databinding.ActivityLoginBinding
import movil.alejandralandinez.petsapp.fragments.BitacoraFragment
import movil.alejandralandinez.petsapp.fragments.ParasitoFragment
import org.jetbrains.anko.startActivity


class BitacoraActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        val binding : ActivityBitacoraBinding = DataBindingUtil.setContentView(this,R.layout.activity_bitacora)
        binding.handlerbit = this


        putVacunasFragment(R.id.containervacunas,BitacoraFragment.instance())
        putParasitosFragment(R.id.containerparasitos,ParasitoFragment.instance())
    }

    fun putVacunasFragment(container:Int, fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(container,fragment).commit()
    }

    fun putParasitosFragment(container: Int,fragment: Fragment){
        supportFragmentManager.beginTransaction().replace(container,fragment).commit()
    }

    fun newvac(){
        startActivity<AddVacActivity>()
    }

    fun newpar(){
        startActivity<AddParActivity>()
    }
}
