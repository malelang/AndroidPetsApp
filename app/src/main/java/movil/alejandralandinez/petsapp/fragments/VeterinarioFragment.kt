package movil.alejandralandinez.petsapp.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_veterinario.*

import movil.alejandralandinez.petsapp.R
import movil.alejandralandinez.petsapp.adapters.VeterinarioAdapter
import movil.alejandralandinez.petsapp.util.Data


class VeterinarioFragment : Fragment() {

    val adapter:VeterinarioAdapter = VeterinarioAdapter()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_veterinario, container, false)
    }

    override fun onResume() {
        super.onResume()
        listvets.adapter=adapter
        listvets.layoutManager = LinearLayoutManager(activity)
        adapter.dataVets = Data.veterinarios
    }

    companion object {
        fun instance():VeterinarioFragment = VeterinarioFragment()
    }

}// Required empty public constructor
