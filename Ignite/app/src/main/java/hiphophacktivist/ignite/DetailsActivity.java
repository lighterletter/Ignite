package hiphophacktivist.ignite;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity{
    public static final String DESCRIPTION = "DESCRIPTION";
    public static final String ADDRESS = "ADDRESS";
    public static final String PHONE_NUMBER = "PHONE NUMBER";
    public static final String WEBSITE = "WEBSITE";
    public static final String DURATION = "DURATION";
    public static final String ORGANIZATION = "ORGANIZATION";
    public static final String COURSE = "COURSE";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        TextView descriptionTV = (TextView) findViewById(R.id.textview_description);
        TextView addressTV = (TextView) findViewById(R.id.textview_address);
        TextView phoneNumberTV = (TextView) findViewById(R.id.textview_phone_number);
        TextView websiteTV = (TextView) findViewById(R.id.textview_website);
        TextView durationTV = (TextView) findViewById(R.id.textview_duration);
        TextView courseTV = (TextView) findViewById(R.id.textview_course);


        String description = getIntent().getStringExtra(DESCRIPTION);
        String address = getIntent().getStringExtra(ADDRESS);
        String phoneNumber = getIntent().getStringExtra(PHONE_NUMBER);
        String website = getIntent().getStringExtra(WEBSITE);
        String duration = getIntent().getStringExtra(DURATION);
        String organization = getIntent().getStringExtra(ORGANIZATION);
        String course = getIntent().getStringExtra(COURSE);

        //getActionBar().setTitle(organization);
        getSupportActionBar().setTitle(organization);


        courseTV.setText(course);
        descriptionTV.setText(" \u2022 " + description);
        addressTV.setText(" \u2022 " + address);
        phoneNumberTV.setText(" \u2022 " + phoneNumber);
        websiteTV.setText(" \u2022 " + website);
        durationTV.setText(" \u2022 " + duration);

    }
}
