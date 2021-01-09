package cl.talentodigital.examentd.network


import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val API_DIR = "https://my-json-server.typicode.com/Himuravidal/FakeAPIdata/"
class RetrofitC {

    companion object{

        fun creaRetrofit(): EquiposApi {
            val retrofit = Retrofit.Builder()
                .baseUrl(API_DIR)
                .addConverterFactory((GsonConverterFactory.create()))
                .build()
            return retrofit.create(EquiposApi::class.java)

        }
    }
}