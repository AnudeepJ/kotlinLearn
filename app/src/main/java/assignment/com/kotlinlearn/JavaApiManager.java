package assignment.com.kotlinlearn;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import explara.emaxio.net.RequestDto;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by anudeep on 21/06/17.
 */

public class JavaApiManager {

    APiJavService apiService;


    public JavaApiManager() {
        OkHttpClient httpClient =
                new OkHttpClient();
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://staging.emaxio.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(httpClient)
                .build();
        apiService = retrofit.create(APiJavService.class);


    }


//     fetchExhibitors(apiRequest:RequestDto):Observable<ExhibitorresponseDto> {
//        return apiService.fetchExhibitors(apiRequest).subscribeOn(Schedulers.io())
//        }


    Call<ExhibitorresponseDto> fetchExhibitorswithCall(RequestDto apiRequest) {
        return apiService.fetchExhibitorsWithooutRx(apiRequest);
    }

    ExhibitorresponseDto fetchExhibitorswithoutCall(RequestDto apiRequest) {
        return apiService.fetchExhibitors(apiRequest);
    }

}
