package movil.alejandralandinez.petsapp

import android.content.Context
import android.content.SharedPreferences
import android.databinding.DataBindingUtil

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import movil.alejandralandinez.petsapp.databinding.ActivityMainBinding
import movil.alejandralandinez.petsapp.fragments.MainFragment
import movil.alejandralandinez.petsapp.models.Usuario
import movil.alejandralandinez.petsapp.net.AppClient
import movil.alejandralandinez.petsapp.util.Data
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException

class MainActivity : AppCompatActivity(), DrawerLayout.DrawerListener, Callback<Usuario> {


    val toggle: ActionBarDrawerToggle by lazy { ActionBarDrawerToggle(this,drawer,R.string.open_menu,R.string.close_menu) }
    val preferences: SharedPreferences by lazy{ getSharedPreferences("preferencias", Context.MODE_PRIVATE) }
    var nuevouser=""

    var usuario:Usuario = Usuario()

    override fun onCreate(savedInstanceState: Bundle?) {
        val binding : ActivityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        super.onCreate(savedInstanceState)
        binding.handlermain=this
        nuevouser=preferences.getString("nuevousuario","").toString()

        loadUsers()

        setContentView(R.layout.activity_main)


        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        drawer.addDrawerListener(this)

        nav.setNavigationItemSelectedListener { setContent(it) }

        putFragment(R.id.container, MainFragment.instance())



    }


    fun loadUsers(){
        AppClient.userapi.getByUsername(nuevouser).enqueue(this)
    }



    override fun onResponse(call: Call<Usuario>?, response: Response<Usuario>) {
        if (response.isSuccessful){
                usuario=response.body()!!
                Data.usuariologged=usuario
                toast("Sesion del usuario "+ nuevouser +" abierta")

        }else{
            toast("el nombre de usuario no es el requerido")
            startActivity<LoginActivity>()
            getSharedPreferences("preferencias", Context.MODE_PRIVATE).edit().putBoolean("logged",false).apply()
        }

    }

    override fun onFailure(call: Call<Usuario>?, t: Throwable?) {
        toast("Usuario no encontrado")
        getSharedPreferences("preferencias", Context.MODE_PRIVATE).edit().putBoolean("logged",false).apply()
        startActivity<LoginActivity>()
    }

    //region OptionsMenu
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }
    //endregion

    //region Fragment
    fun putFragment(container: Int, fragment: Fragment) {
        supportFragmentManager.beginTransaction()
                .replace(container, fragment)
                .commit()
    }

    fun setContent(item: MenuItem?):Boolean{
        drawer.closeDrawers()
        when(item?.itemId){
            R.id.nav_home -> putFragment(R.id.container, MainFragment.instance())
            R.id.nav_bitacora -> startActivity<BitacoraActivity>()
            R.id.nav_vets -> startActivity<VetsActivity>()
            R.id.logout -> {
                getSharedPreferences("preferencias", Context.MODE_PRIVATE).edit().putBoolean("logged",false).apply()
                startActivity<LoginActivity>()
                finish()
            }
        }
        return true
    }
    //endregion

    //region Toggle
    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        toggle.syncState()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.aboutVacunas -> {startActivity<AboutVacunasActivity>()}
            R.id.aboutCattes -> {startActivity<AboutGatosActivity>()}
            R.id.aboutDoggos -> {startActivity<AboutDogsActivity>()}
        }
        if(toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onDrawerStateChanged(newState: Int) {
        toggle.onDrawerStateChanged(newState)
    }

    override fun onDrawerSlide(drawerView: View, slideOffset: Float) {
        toggle.onDrawerSlide(drawerView,slideOffset)
    }

    override fun onDrawerClosed(drawerView: View) {
        toggle.onDrawerClosed(drawerView)
    }

    override fun onDrawerOpened(drawerView: View) {
        toggle.onDrawerOpened(drawerView)
    }
    //endregion
}
