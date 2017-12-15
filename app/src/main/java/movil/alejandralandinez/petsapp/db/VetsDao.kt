package movil.alejandralandinez.petsapp.db


import android.arch.persistence.room.*
import movil.alejandralandinez.petsapp.models.Veterinario

@Dao
interface VetsDao{

    @Insert
    fun insert(veterinario:Veterinario)

    @Delete
    fun delete(veterinario:Veterinario)

    @Query("SELECT * FROM veterinario")
    fun allvets():List<Veterinario>
}
