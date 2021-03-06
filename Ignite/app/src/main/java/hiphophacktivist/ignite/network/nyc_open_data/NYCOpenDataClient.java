package hiphophacktivist.ignite.network.nyc_open_data;


import java.util.List;

import hiphophacktivist.ignite.Model.CourseListing;
import hiphophacktivist.ignite.network.NetworkServices;
import retrofit2.Call;

public class NYCOpenDataClient {
    //https://data.cityofnewyork.us/resource/5teq-yyit.json
    private static final String BASE_URL = "https://data.cityofnewyork.us";

    private static volatile NYCOpenDataClient instance;
    private NYCOpenDatService apiService;


    private NYCOpenDataClient() {
        apiService = (new NetworkServices()).getJSONService(BASE_URL, NYCOpenDatService.class);
    }

    public static NYCOpenDataClient getInstance() {
        if (instance == null) {
            synchronized (NYCOpenDataClient.class) {
                if (instance == null) {
                    instance = new NYCOpenDataClient();
                }
            }
        }
        return instance;
    }

    public Call<List<CourseListing>> getOpenDataResponse(){
        return apiService.getListOfCourses();
    }

    public Call<List<CourseListing>> getDataOnBorough(String borough){
        return apiService.getListOfPhotosByBorough(borough);
    }

    public Call<List<CourseListing>> getDataOnZip(int zip){
        return apiService.getListOfPhotosByZip(zip);
    }

}
