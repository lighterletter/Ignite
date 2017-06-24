package hiphophacktivist.ignite.network.nyc_open_data;


import java.util.List;

import hiphophacktivist.ignite.Model.CourseListing;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

interface NYCOpenDatService {
    //https://data.cityofnewyork.us/resource/5teq-yyit.json
    String JSON_PATH = "/resource/5teq-yyit.json";

    @GET(JSON_PATH)
    Call<List<CourseListing>> getListOfPhotos();

    Call<List<CourseListing>> getListOfPhotosByBorough(@Query("borough") String borough);
}
