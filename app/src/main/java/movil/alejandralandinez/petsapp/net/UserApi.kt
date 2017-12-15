package movil.alejandralandinez.petsapp.net

import movil.alejandralandinez.petsapp.models.Usuario

import retrofit2.Call
import retrofit2.http.*


interface UserApi{

    @GET("users")
    fun all():Call<List<Usuario>>

    @GET("users/{username}")
    fun getByUsername(@Path("username") username:String):Call<Usuario>

    @GET("users/{contrasena}")
    fun getByPassword(@Path("contrasena") contrasena:String):Call<Usuario>

    @POST("users")
    fun insert(@Body user:Usuario):Call<SimpleResponse>

    @POST("users/login")
    fun loguser(@Body username:String):Call<SimpleResponse>



}

data class SimpleResponse(val success:Boolean)