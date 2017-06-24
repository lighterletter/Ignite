package hiphophacktivist.ignite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import hiphophacktivist.ignite.Model.CourseListing;
import hiphophacktivist.ignite.network.nyc_open_data.NYCOpenDataClient;
import hiphophacktivist.ignite.view.ProgramListingAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    String TAG = MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView listings = (RecyclerView) findViewById(R.id.recycler_view);
        listings.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        final ProgramListingAdapter adapter = new ProgramListingAdapter(new ArrayList<CourseListing>());
        listings.setAdapter(adapter);

        NYCOpenDataClient
                .getInstance()
                .getOpenDataResponse()
                .enqueue(new Callback<List<CourseListing>>() {
                    @Override
                    public void onResponse(Call<List<CourseListing>> call, Response<List<CourseListing>> response) {
                        List<CourseListing> list = response.body();

                        adapter.setListings(list);
                    }

                    @Override
                    public void onFailure(Call<List<CourseListing>> call, Throwable t) {
                        Toast.makeText(MainActivity.this, "Cann't reach results at the moment, try again later.", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
