package movil.alejandralandinez.petsapp.net

import android.content.Context
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object AppClient {
    private val retrofit:Retrofit = Retrofit.Builder().baseUrl("http://192.168.1.60:3000/api/")
            .addConverterFactory(GsonConverterFactory.create()).build()

    val userapi:UserApi = retrofit.create(UserApi::class.java)

    val vetapi:VetsApi = retrofit.create(VetsApi::class.java)


}