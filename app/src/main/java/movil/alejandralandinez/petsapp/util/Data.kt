package movil.alejandralandinez.petsapp.util

import movil.alejandralandinez.petsapp.models.Mascota
import movil.alejandralandinez.petsapp.models.Parasito
import movil.alejandralandinez.petsapp.models.Vacuna
import movil.alejandralandinez.petsapp.models.Veterinario


object Data {
    var peliculas: MutableList<Mascota> = mutableListOf(
            Mascota("3312","Wonder", "Abisinio", "3",
                    "http://2.bp.blogspot.com/-Dj3bRpeki5s/Tm_2ngBXDKI/AAAAAAAACFg/XowWT6WuVzo/s1600/gato_asi%25C3%25A1tico_humo_atigrado.jpg",
                    "p","f"),

            Mascota("3313","Covenan", "French Poodle", "1",
                    "https://http2.mlstatic.com/espectacular-french-poodle-mini-toy-D_NQ_NP_385215-MCO25185641326_112016-F.jpg",
                    "p","m"),

            Mascota("3314","Justice League", "Cocker Spaniel", "1",
                    "http://www.petmd.com/sites/default/files/mammary-gland-tumor-dogs.jpg",
                    "p","f"),

            Mascota("3315","La Momia", "Ovejero", "8",
                    "https://www.muyperruno.com/wp-content/uploads/2016/10/BOBTAIL-perros-de-raza-ovejero.jpg",
                    "p","m"),

            Mascota("3316","Spiderman", "Chihuahua", "14",
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

    var veterinarios: MutableList<Veterinario> = mutableListOf(
            Veterinario("3317","Pelos y Patas" ,"Cra. 10N #12 A-102","8222222","http://clubpremiumdecolombia.com/wp-content/uploads/2017/09/pelos-y-patas-logo.jpg", "PELOS Y PATAS SPA es el mejor sitio donde atendemos a lo que tu mas quieres como se lo merece. Servicios de Pet Shop, Sala de Belleza Spa, Clinica, VeteChip y Servicios a Domicilio.  VETECHIP es un microchip de identificación (No GPS) con un código único  programado desde fabrica que permite llevar un registro del animal en una base de datos externa, en esta base de datos se pueden almacenar datos de vital importancia para encontrar el dueño de una mascota y así mismo información medica relevante."),
            Veterinario("3318","Cannis e Cattus","Carrera 9 # 21N - 36","8232856","https://igx.4sqi.net/img/general/600x600/15020349_fZpPl2DZQ2aRnaQ5hfflKM_-Hbb1AWOp2WVCxAA57Cc.jpg", "Canis e Cattus es fundada en la ciudad de Popayán el 1 de julio de 2008, bajo el nombre de Medicina Veterinaria Praga por los Doctores Beatriz Elena Valencia Miller y David Silva Pineda, con el objetivo de suplir las necesidades de una atención integral en medicina veterinaria para las mascotas de la ciudad, fue así como en su primera sede en el centro histórico de la ciudad funcionó la clínica durante los tres primeros años, luego se trasladó a la sede actual en el barrio ciudad jardín, donde funciona desde junio del 2011. Nuestra visión es mantenernos como la empresa prestadora de servicios médicos veterinarios líder en Popayán; consolidando un equipo humano unido y capacitado, utilizando tecnología de vanguardia y procurando el bienestar de sus pacientes, la satisfacción de sus clientes, y la calidad de vida de sus empleados y asociados; y nuestra misión es reunir en una planta física adecuada, un equipo humano, proactivo y capacitarlo permanentemente, para atender de manera idónea las necesidades de salud, nutrición y bienestar de las mascotas de nuestros clientes, bajo el profesionalismo, la ética, la tecnología y el amor.")
    )

}