package assignment.com.kotlinlearn

import explara.emaxio.net.RequestDto
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

/**
 * Created by anudeep on 20/06/17.
 */
interface ApiService {

    @Headers("Authorization: com.explara.eventconnect")
    @POST("api/api/fetch-exhibitors-by-event-id")
    fun fetchExhibitors(@Body requestBody: RequestDto): Observable<ExhibitorresponseDto>



    @Headers("Authorization: com.explara.eventconnect",
            "Content-Type: application/json")
    @POST("api/api/fetch-exhibitors-by-event-id")
    fun fetchExhibitorsWithooutRx(@Body requestBody: RequestDto): Call<ExhibitorresponseDto>



}