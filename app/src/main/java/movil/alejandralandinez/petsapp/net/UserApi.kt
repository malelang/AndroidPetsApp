package movil.alejandralandinez.petsapp.net

import movil.alejandralandinez.petsapp.models.Usuario

import retrofit2.Call
import retrofit2.http.*


interface UserApi{

    @GET("users")
    fun all():Call<List<Usuario>>

    @GET("users/{id}")
    fun getById(@Path("id") id:String):Call<Usuario>

    @POST("users")
    fun insert(@Body user:Usuario):Call<SimpleResponse>

    @Multipart
    @POST("users/login")
    fun loguser(@Part("username") username:String, @Part("password") password:String):Call<SimpleResponse>



}

data class SimpleResponse(val success:Boolean)