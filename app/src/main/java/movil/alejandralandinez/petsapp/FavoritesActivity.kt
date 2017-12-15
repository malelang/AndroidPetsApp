package movil.alejandralandinez.petsapp

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_favorites.*
import movil.alejandralandinez.petsapp.adapters.VetListAdapter
import movil.alejandralandinez.petsapp.databinding.ActivityFavoritesBinding
import movil.alejandralandinez.petsapp.db.AppDb
import movil.alejandralandinez.petsapp.db.VetsDao
import kotlin.concurrent.thread

class FavoritesActivity : AppCompatActivity() {

    private lateinit var binding:ActivityFavoritesBinding
    private val adapter:VetListAdapter = VetListAdapter()
    val dao:VetsDao = AppDb.db.vetDao()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_favorites)
        binding.handlerlist = this
        list.adapter = adapter
    }

    override fun onResume() {
        super.onResume()
        thread{
            val data = dao.allvets()
            runOnUiThread {
                adapter.data = data
            }
        }

    }
}
