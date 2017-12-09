package movil.alejandralandinez.petsapp.adapters

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import movil.alejandralandinez.petsapp.R
import movil.alejandralandinez.petsapp.databinding.TemplateParasitoBinding
import movil.alejandralandinez.petsapp.databinding.TemplateVacunaBinding
import movil.alejandralandinez.petsapp.models.Vacuna
import movil.alejandralandinez.petsapp.util.inflate


class BitacoraAdapter:RecyclerView.Adapter<BitacoraViewHolder>() {


    var datavacunas:List<Vacuna> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BitacoraViewHolder = BitacoraViewHolder(parent.inflate(R.layout.template_vacuna))



    override fun onBindViewHolder(holder: BitacoraViewHolder, position: Int) {
        holder.binding.vaccine = datavacunas[position]


    }

    override fun getItemCount(): Int = datavacunas.size
}


class BitacoraViewHolder(view:View):RecyclerView.ViewHolder(view){
    val binding:TemplateVacunaBinding = DataBindingUtil.bind(view)
}