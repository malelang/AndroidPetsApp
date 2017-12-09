package movil.alejandralandinez.petsapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import movil.alejandralandinez.petsapp.fragments.VeterinarioFragment

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
