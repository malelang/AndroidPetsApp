package movil.alejandralandinez.petsapp.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_parasito.*
import movil.alejandralandinez.petsapp.R
import movil.alejandralandinez.petsapp.adapters.ParasitoAdapter
import movil.alejandralandinez.petsapp.util.Data


class ParasitoFragment : Fragment() {


    val adapter:ParasitoAdapter = ParasitoAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_parasito, container, false)
    }

    override fun onResume() {
        super.onResume()
        listPar.adapter=adapter
        listPar.layoutManager = LinearLayoutManager(activity)
        adapter.dataparasitos= Data.parasitos
    }

    companion object {
        fun instance():ParasitoFragment = ParasitoFragment()
    }

}
