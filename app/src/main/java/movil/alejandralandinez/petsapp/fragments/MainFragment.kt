package movil.alejandralandinez.petsapp.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_main.*
import movil.alejandralandinez.petsapp.R
import movil.alejandralandinez.petsapp.adapters.MascotaAdapter
import movil.alejandralandinez.petsapp.util.Data

/**
 * Created by alejandralandinez on 12/6/17.
 */
class MainFragment : Fragment() {

    val adapter: MascotaAdapter = MascotaAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onResume() {
        super.onResume()
        list.adapter = adapter
        list.layoutManager = LinearLayoutManager(activity)
        adapter.data = Data.peliculas
    }


    companion object {
        fun instance():MainFragment = MainFragment()
    }

}