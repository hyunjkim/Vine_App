package nyc.c4q.hyun.vine_app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import nyc.c4q.hyun.vine_app.network.VinePOJO;
import nyc.c4q.hyun.vine_app.network.VineService;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class VineActivity extends AppCompatActivity {

    private final String TAG = "VineActivity";
    private final String API_KEY = "https://vine.co/";
    private List<Objects> listofPojo = new ArrayList<>();
    private VinePOJO vinePOJO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vine);

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor).build();

        Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl(API_KEY)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        VineService vineService = retrofit.create(VineService.class);
        Call<VinePOJO> vinePOJOCall = vineService.getVine();

        vinePOJOCall.enqueue(new Callback<VinePOJO>() {
            @Override
            public void onResponse(Call<VinePOJO> call, Response<VinePOJO> response) {

                vinePOJO = response.body();
//                Log.d(TAG,vinePOJO.toString());

                Toast.makeText(getApplicationContext(), "VINE RESPONSE SUCCESSFUL", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<VinePOJO> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "VINE RESPONSE FAILURE", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
