package movil.alejandralandinez.petsapp.adapters

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import movil.alejandralandinez.petsapp.R
import movil.alejandralandinez.petsapp.databinding.TemplateParasitoBinding
import movil.alejandralandinez.petsapp.models.Parasito
import movil.alejandralandinez.petsapp.util.inflate


class ParasitoAdapter:RecyclerView.Adapter<ParasitoViewHolder>(){

    var dataparasitos:List<Parasito> = emptyList()
    set(value) {
        field = value
        notifyDataSetChanged()
    }
    override fun getItemCount(): Int = dataparasitos.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ParasitoViewHolder = ParasitoViewHolder(parent.inflate(R.layout.template_parasito))



    override fun onBindViewHolder(holder: ParasitoViewHolder, position: Int) {
        holder.binding.parasite = dataparasitos[position]
    }

}


class ParasitoViewHolder(view:View):RecyclerView.ViewHolder(view){
    val binding:TemplateParasitoBinding = DataBindingUtil.bind(view)
}