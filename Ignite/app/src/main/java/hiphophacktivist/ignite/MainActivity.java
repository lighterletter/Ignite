package hiphophacktivist.ignite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.List;

import hiphophacktivist.ignite.Model.JobPosting;
import hiphophacktivist.ignite.network.nyc_open_data.NYCOpenDataClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NYCOpenDataClient
                .getInstance()
                .getOpenDataResponse()
                .enqueue(new Callback<List<JobPosting>>() {
                    @Override
                    public void onResponse(Call<List<JobPosting>> call, Response<List<JobPosting>> response) {
                        System.out.println(response.body().get(0).getBorough());
                    }

                    @Override
                    public void onFailure(Call<List<JobPosting>> call, Throwable t) {
                        System.out.println(call.request().url());
                    }
                });
    }
}
