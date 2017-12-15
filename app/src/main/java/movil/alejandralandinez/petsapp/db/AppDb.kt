package movil.alejandralandinez.petsapp.db

import android.arch.persistence.room.Room
import android.content.Context


object AppDb{
    lateinit var db:Database

    fun init(context:Context) {
        db= Room.databaseBuilder(context,Database::class.java,"veterinarios").build()
    }
}