package movil.alejandralandinez.petsapp.models


class Usuario (
               var nombreusuario:String,
               var username:String,
               var contrasena:String,
               var edad:String,
               var contacto:String,
               var sexo:String,
               var imagen:String,
               var mascota:Mascota
               ){
    var iduser:Long? =null
    constructor():this("","","","","","","",Mascota())
}