package movil.alejandralandinez.petsapp

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.view.MenuItem
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import movil.alejandralandinez.petsapp.fragments.MainFragment
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity(), DrawerLayout.DrawerListener  {

    val toggle: ActionBarDrawerToggle by lazy { ActionBarDrawerToggle(this,drawer,R.string.open_menu,R.string.close_menu) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        drawer.addDrawerListener(this)

        nav.setNavigationItemSelectedListener { setContent(it) }

        putFragment(R.id.container, MainFragment.instance())

    }

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

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        toggle.syncState()
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if(toggle.onOptionsItemSelected(item)){

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
}
