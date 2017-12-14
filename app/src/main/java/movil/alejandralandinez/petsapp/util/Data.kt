package movil.alejandralandinez.petsapp.util

import movil.alejandralandinez.petsapp.models.Mascota
import movil.alejandralandinez.petsapp.models.Parasito
import movil.alejandralandinez.petsapp.models.Vacuna
import movil.alejandralandinez.petsapp.models.Veterinario
import movil.alejandralandinez.petsapp.net.AppClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import org.jetbrains.anko.support.v4.toast


object Data : Callback<List<Veterinario>> {


    var peliculas: MutableList<Mascota> = mutableListOf(
            Mascota("Wonder", "Abisinio", "3",
                    "http://2.bp.blogspot.com/-Dj3bRpeki5s/Tm_2ngBXDKI/AAAAAAAACFg/XowWT6WuVzo/s1600/gato_asi%25C3%25A1tico_humo_atigrado.jpg",
                    "p","f"),

            Mascota("Covenan", "French Poodle", "1",
                    "https://http2.mlstatic.com/espectacular-french-poodle-mini-toy-D_NQ_NP_385215-MCO25185641326_112016-F.jpg",
                    "p","m"),

            Mascota("Justice League", "Cocker Spaniel", "1",
                    "http://www.petmd.com/sites/default/files/mammary-gland-tumor-dogs.jpg",
                    "p","f"),

            Mascota("La Momia", "Ovejero", "8",
                    "https://www.muyperruno.com/wp-content/uploads/2016/10/BOBTAIL-perros-de-raza-ovejero.jpg",
                    "p","m"),

            Mascota("Spiderman", "Chihuahua", "14",
                    "http://mediad.publicbroadcasting.net/p/shared/npr/201309/200804403.jpg",
                    "p","f")

    )

    var vacunas: MutableList<Vacuna> = mutableListOf (
            Vacuna("2/Feb/2017","Triple Viral","Doctor Lopez"),
            Vacuna("10/Mar/2017","Rabia","Doctor Garcia"),
            Vacuna("13/Abr/2017","Ojeras","Doctor Lopez")
    )

    var parasitos: MutableList<Parasito> = mutableListOf(
            Parasito("10/May/2014","3","ACME","10/May/2015"),
            Parasito("10/May/2014","3","ACME","10/May/2015"),
            Parasito("10/May/2014","3","ACME","10/May/2015")
    )

    var veterinarios: List<Veterinario> = emptyList()

    fun loadVets(){
        AppClient.vetapi.all().enqueue(this)
    }

    override fun onFailure(call: Call<List<Veterinario>>?, t: Throwable?) {

    }

    override fun onResponse(call: Call<List<Veterinario>>?, response: Response<List<Veterinario>>) {
        if (response.isSuccessful){
            veterinarios = response.body()!!
        }
    }

}