package movil.alejandralandinez.petsapp.adapters

import android.databinding.DataBindingUtil
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import movil.alejandralandinez.petsapp.R
import movil.alejandralandinez.petsapp.databinding.TemplatelistVeterinarioBinding
import movil.alejandralandinez.petsapp.models.Veterinario
import movil.alejandralandinez.petsapp.util.inflate


class VetListAdapter:BaseAdapter() {

    var data:List<Veterinario> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getView(pos: Int, convertView: View?, parent: ViewGroup): View {
        val view:View = convertView ?: parent.inflate(R.layout.templatelist_veterinario)
        val binding:TemplatelistVeterinarioBinding = DataBindingUtil.bind(view)
        binding.vetelista=data[pos]
        return binding.root
    }

    override fun getItem(position: Int): Any = data[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getCount(): Int = data.size
}