package movil.alejandralandinez.petsapp.net


import movil.alejandralandinez.petsapp.models.Veterinario
import retrofit2.Call
import retrofit2.http.GET


interface VetsApi{

    @GET("vets")
    fun all():Call<List<Veterinario>>
}

