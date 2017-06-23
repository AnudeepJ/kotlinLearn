package assignment.com.kotlinlearn;

import explara.emaxio.net.RequestDto;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by anudeep on 21/06/17.
 */

public interface APiJavService {


    @Headers({"Authorization: com.explara.eventconnect",
            "Content-Type: application/json"})
    @POST("api/api/fetch-exhibitors-by-event-id")
    Call<ExhibitorresponseDto> fetchExhibitorsWithooutRx(@Body RequestDto requestBody);


    @Headers({"Authorization: com.explara.eventconnect",
            "Content-Type: application/json"})
    @POST("api/api/fetch-exhibitors-by-event-id")
    ExhibitorresponseDto fetchExhibitors(@Body RequestDto requestBody);

}
