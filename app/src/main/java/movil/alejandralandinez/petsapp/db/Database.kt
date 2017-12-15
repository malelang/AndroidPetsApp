package movil.alejandralandinez.petsapp.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import movil.alejandralandinez.petsapp.models.Veterinario

@Database(entities = arrayOf(Veterinario::class),version = 1)
abstract class Database : RoomDatabase(){
    abstract fun vetDao():VetsDao
}
