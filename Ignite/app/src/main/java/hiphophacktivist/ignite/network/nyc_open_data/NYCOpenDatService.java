package hiphophacktivist.ignite.network.nyc_open_data;


import android.graphics.Path;

import java.util.List;

import hiphophacktivist.ignite.Model.JobPosting;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

interface NYCOpenDatService {
    //https://data.cityofnewyork.us/resource/5teq-yyit.json
    String JSON_PATH = "/resource/5teq-yyit.json";

    @GET(JSON_PATH)
    Call<List<JobPosting>> getListOfPhotos();

    Call<List<JobPosting>> getListOfPhotosByBorough(@Query("borough") String borough);
}
