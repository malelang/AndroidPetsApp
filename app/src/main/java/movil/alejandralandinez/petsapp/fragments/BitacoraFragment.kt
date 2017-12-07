package movil.alejandralandinez.petsapp.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_bitacora.*

import movil.alejandralandinez.petsapp.R
import movil.alejandralandinez.petsapp.adapters.BitacoraAdapter
import movil.alejandralandinez.petsapp.util.Data

class BitacoraFragment : Fragment() {

    val adapter:BitacoraAdapter = BitacoraAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bitacora, container, false)
    }

    override fun onResume() {
        super.onResume()
        listvacunas.adapter=adapter
        listvacunas.layoutManager = LinearLayoutManager(activity)
        adapter.datavacunas = Data.vacunas
    }


    companion object {
        fun instance():BitacoraFragment = BitacoraFragment()
    }
}


