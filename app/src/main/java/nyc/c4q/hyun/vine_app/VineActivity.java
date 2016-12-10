package nyc.c4q.hyun.vine_app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.List;

import nyc.c4q.hyun.vine_app.network.Data;
import nyc.c4q.hyun.vine_app.network.Record;
import nyc.c4q.hyun.vine_app.network.VinePOJO;
import nyc.c4q.hyun.vine_app.network.VineService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class VineActivity extends AppCompatActivity {

    private final String API_KEY = "https://vine.co/";
    private VinePOJO vinePOJO;
    private RecyclerView mRecyclerView;
    private Data data;
    private List<Record> recordList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vine);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_KEY)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        VineService vineService = retrofit.create(VineService.class);
        final Call<VinePOJO> vinePOJOCall = vineService.getVine();

        vinePOJOCall.enqueue(new Callback<VinePOJO>() {
            @Override
            public void onResponse(Call<VinePOJO> call, Response<VinePOJO> response) {

                vinePOJO = response.body();
                data = vinePOJO.getData();
                recordList = data.getRecords();

                mRecyclerView = (RecyclerView) findViewById(R.id.vine_RV);
                mRecyclerView.setLayoutManager(new LinearLayoutManager(getParent()));
                mRecyclerView.setAdapter(new VineAdapter(recordList));

                Toast.makeText(getApplicationContext(), "VINE RESPONSE SUCCESSFUL", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<VinePOJO> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "VINE RESPONSE FAILURE", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
