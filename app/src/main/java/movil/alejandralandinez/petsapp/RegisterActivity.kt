package movil.alejandralandinez.petsapp

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import movil.alejandralandinez.petsapp.databinding.ActivityRegisterBinding
import org.jetbrains.anko.startActivity

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityRegisterBinding = DataBindingUtil
                .setContentView(this, R.layout.activity_register)

        binding.handler1 = this
    }

    fun next() {
        startActivity<RegMascotaActivity>()
        finish()

    }
}
