package hiphophacktivist.ignite;

import android.support.annotation.MainThread;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import hiphophacktivist.ignite.Model.CourseListing;
import hiphophacktivist.ignite.network.nyc_open_data.NYCOpenDataClient;
import hiphophacktivist.ignite.view.JobPostsAdapter;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rc_test);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        JobPostsAdapter adapter = new JobPostsAdapter(new ArrayList<>());
        recyclerView.setAdapter(adapter);
        NYCOpenDataClient
                .getInstance()
                .getOpenDataResponse()
                .subscribeOn(Schedulers.io())
                .flatMapIterable(courseListings -> courseListings)
                .filter(courseListing -> courseListing.getCourseDescription().contains("course"))
                .toList()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(courseListings -> {
                    adapter.setJobPostList(courseListings);
                });
    }
}
