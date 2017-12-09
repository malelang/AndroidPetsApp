package movil.alejandralandinez.petsapp.adapters

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import movil.alejandralandinez.petsapp.R
import movil.alejandralandinez.petsapp.databinding.TemplateVeterinarioBinding
import movil.alejandralandinez.petsapp.models.Veterinario
import movil.alejandralandinez.petsapp.util.inflate


class VeterinarioAdapter:RecyclerView.Adapter<VeterinarioViewHolder>(){

    var dataVets:List<Veterinario> = emptyList()
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: VeterinarioViewHolder, position: Int) {
        holder.binding.vet = dataVets[position]
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VeterinarioViewHolder  = VeterinarioViewHolder(parent.inflate(R.layout.template_veterinario))


    override fun getItemCount(): Int = dataVets.size

}


class VeterinarioViewHolder(view:View):RecyclerView.ViewHolder(view){
    val binding:TemplateVeterinarioBinding = DataBindingUtil.bind(view)
}
