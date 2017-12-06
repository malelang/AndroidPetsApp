package movil.alejandralandinez.petsapp.util

import movil.alejandralandinez.petsapp.models.Mascota

/**
 * Created by alejandralandinez on 12/6/17.
 */
object Data {
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

}