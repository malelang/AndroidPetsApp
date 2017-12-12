package movil.alejandralandinez.petsapp

import android.databinding.DataBindingUtil
import android.graphics.Color
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.graphics.Palette
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.content_detail.*
import movil.alejandralandinez.petsapp.databinding.ActivityDetailBinding
import movil.alejandralandinez.petsapp.models.Veterinario
import movil.alejandralandinez.petsapp.util.Data
import movil.alejandralandinez.petsapp.util.text

class DetailActivity : AppCompatActivity(), Callback {


    lateinit var binding:ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_detail)

        setSupportActionBar(toolbar)
        val pos = intent.extras.getInt("pos",0)
        val veterinario= Data.veterinarios[pos]
        binding.veterinario = veterinario

        collapsing.title = veterinario.nombre
        Picasso.with(this).load(Uri.parse(veterinario.imagen)).into(img,this)
    }
    override fun onSuccess() {
        val drawable = img.drawable as BitmapDrawable
        val palette = Palette.from(drawable.bitmap).generate()
        val default = ContextCompat.getColor(this,R.color.colorPrimary)
        val color = palette.getVibrantColor(default)
        collapsing.setContentScrimColor(color)
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.statusBarColor = getStatusColor(color)
        }
    }

    fun getStatusColor(color:Int):Int{
        var red = Color.red(color) - 40
        var blue = Color.blue(color) - 40
        var green = Color.green(color) - 40
        red = if (red > 0)  red else 0
        blue = if (blue > 0) blue else 0
        green = if (green > 0)  green else 0

        return Color.rgb(red,green,blue)
    }

    override fun onError() {

    }

   /* fun save(){
        val direccion = direccion.toString()
        val descripcion = descripcion.toString()
        val contacto = call.toString()
        val vet = Veterinario("", "", direccion, contacto,"",descripcion)
    }*/
}
