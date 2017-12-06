package movil.alejandralandinez.petsapp.adapters

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import movil.alejandralandinez.petsapp.R
import movil.alejandralandinez.petsapp.databinding.TemplateMascotaBinding
import movil.alejandralandinez.petsapp.models.Mascota
import movil.alejandralandinez.petsapp.util.inflate


class MascotaAdapter : RecyclerView.Adapter<MascotaViewHolder>() {

    var data: List<Mascota> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onBindViewHolder(holder: MascotaViewHolder, position: Int) {
        holder.binding.movie = data[position]
        holder.binding.root.tag = position
        holder.binding.handler = this
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MascotaViewHolder
            = MascotaViewHolder(parent.inflate(R.layout.template_mascota))

    override fun getItemCount(): Int = data.size

}

class MascotaViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val binding: TemplateMascotaBinding = DataBindingUtil.bind(view)
}
