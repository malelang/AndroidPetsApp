package movil.alejandralandinez.petsapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import movil.alejandralandinez.petsapp.fragments.VeterinarioFragment
import movil.alejandralandinez.petsapp.models.Veterinario
import movil.alejandralandinez.petsapp.net.AppClient
import org.jetbrains.anko.toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class VetsActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vets)

        putvetsFragment(R.id.containervets,VeterinarioFragment.instance())
    }


    fun putvetsFragment(container:Int,fragment: Fragment){
        supportFragmentManager.beginTransaction().replace(container,fragment).commit()
    }


}
