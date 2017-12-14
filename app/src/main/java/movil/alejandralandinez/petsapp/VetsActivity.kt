package movil.alejandralandinez.petsapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import movil.alejandralandinez.petsapp.fragments.VeterinarioFragment
import movil.alejandralandinez.petsapp.models.Veterinario
import movil.alejandralandinez.petsapp.net.AppClient
import movil.alejandralandinez.petsapp.util.Data
import org.jetbrains.anko.toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class VetsActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vets)
        Data.loadVets()

        putvetsFragment(R.id.containervets,VeterinarioFragment.instance())
    }

    override fun onResume() {
        super.onResume()
        Data.loadVets()
        putvetsFragment(R.id.containervets,VeterinarioFragment.instance())
    }


    fun putvetsFragment(container:Int,fragment: Fragment){
        supportFragmentManager.beginTransaction().replace(container,fragment).commit()
    }




}
