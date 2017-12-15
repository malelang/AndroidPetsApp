package movil.alejandralandinez.petsapp.models

import android.arch.persistence.room.Entity
import android.arch.persistence.room.Ignore
import android.arch.persistence.room.PrimaryKey

@Entity
data class Veterinario (var nombre:String,
                        var direccion: String,
                        var contacto:String,
                        var imagen:String,
                        var descripcion:String){
    @PrimaryKey(autoGenerate = true)
    var id:Long? = null

    @Ignore
    constructor():this("","","","","")
}