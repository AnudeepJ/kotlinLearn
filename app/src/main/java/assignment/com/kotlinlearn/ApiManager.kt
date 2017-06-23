package assignment.com.kotlinlearn

import com.google.gson.Gson
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import explara.emaxio.net.RequestDto
import io.reactivex.Observable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.google.gson.GsonBuilder
import io.reactivex.schedulers.Schedulers
import retrofit2.Call


/**
 * Created by anudeep on 20/06/17.
 */
class ApiManager {

    var apiService: ApiService

    init {
        val logging = HttpLoggingInterceptor()
// set your desired log level
        logging.level = HttpLoggingInterceptor.Level.BODY

        val httpClient = OkHttpClient.Builder()
// add your other interceptors …

// add logging as last interceptor
        httpClient.addInterceptor(logging)  // <-- this is the important line!


        val gson = GsonBuilder()
                .setLenient()
                .create()

        val retrofit = Retrofit.Builder().baseUrl("https://staging.emaxio.com/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(httpClient.build())
                .build()
        apiService = retrofit.create(ApiService::class.java)
    }


    fun fetchExhibitors(apiRequest: RequestDto): Observable<ExhibitorresponseDto> {
        return apiService.fetchExhibitors(apiRequest).subscribeOn(Schedulers.io())
    }

    fun fetchExhibitorsWIthourRx(apiRequest: RequestDto): Call<ExhibitorresponseDto> {
        return apiService.fetchExhibitorsWithooutRx(apiRequest)
    }

}