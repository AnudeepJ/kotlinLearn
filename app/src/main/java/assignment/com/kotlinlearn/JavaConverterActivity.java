package assignment.com.kotlinlearn;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import explara.emaxio.net.RequestDto;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class JavaConverterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java_converter2);
        RequestDto apiRequest = new RequestDto("0f1eafe861681de53aa511f3570ee44a266275c5", "769", "657");

        JavaApiManager javaApiManager = new JavaApiManager();
        Call<ExhibitorresponseDto> exhibitorresponseDtoCall = javaApiManager.fetchExhibitorswithCall(apiRequest);
        exhibitorresponseDtoCall.enqueue(new Callback<ExhibitorresponseDto>() {
            @Override
            public void onResponse(Call<ExhibitorresponseDto> call, Response<ExhibitorresponseDto> response) {

            }

            @Override
            public void onFailure(Call<ExhibitorresponseDto> call, Throwable t) {

            }
        });
    }
}
