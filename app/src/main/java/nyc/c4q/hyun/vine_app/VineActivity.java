package nyc.c4q.hyun.vine_app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import nyc.c4q.hyun.vine_app.backend.VineApi;

public class VineActivity extends AppCompatActivity {

    private final String API_KEY = "https://vine.co/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vine);
        VineApi.parseData(VineApi.TEST_RESULT);
    }
}
