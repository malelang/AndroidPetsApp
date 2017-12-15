package movil.alejandralandinez.petsapp

import android.app.Application
import movil.alejandralandinez.petsapp.db.AppDb


class App : Application(){
    override fun onCreate() {
        super.onCreate()
        AppDb.init(this)
    }
}