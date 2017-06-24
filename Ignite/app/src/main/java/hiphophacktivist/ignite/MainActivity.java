package hiphophacktivist.ignite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
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
    ProgramListingAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView listings = (RecyclerView) findViewById(R.id.recycler_view);
        listings.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        adapter = new ProgramListingAdapter(new ArrayList<CourseListing>());
        listings.setAdapter(adapter);


        final EditText search = ((EditText) findViewById(R.id.listing_search_bar));
        search.setImeOptions(EditorInfo.IME_ACTION_DONE);
        search.setOnEditorActionListener(new EditText.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {

                    String userInput = search.getText().toString();
                    try{
                        int zip = Integer.parseInt(userInput);
                        makeBoroughCall(zip);

                    }catch (NumberFormatException ex) {
                        makeBoroughCall(userInput);
                        //handle exception here
                    }

                    return true;
                }
                return false;
            }
        });


        makeDefaultCall();


        ((Button) findViewById(R.id.all_search)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeDefaultCall();
            }
        });
    }

    private void makeBoroughCall(int zip) {
        NYCOpenDataClient
                .getInstance()
                .getDataOnZip(zip)
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

    private void makeBoroughCall(String borough) {
        NYCOpenDataClient
                .getInstance()
                .getDataOnBorough(borough)
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


    private void makeDefaultCall() {
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
