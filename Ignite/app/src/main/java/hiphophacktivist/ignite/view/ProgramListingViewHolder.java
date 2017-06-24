package hiphophacktivist.ignite.view;


import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import hiphophacktivist.ignite.DetailsActivity;
import hiphophacktivist.ignite.Model.CourseListing;
import hiphophacktivist.ignite.R;

class ProgramListingViewHolder extends RecyclerView.ViewHolder {
    public ProgramListingViewHolder(View itemView) {
        super(itemView);
    }

    public void bind(final CourseListing courseListing) {
        ((TextView)itemView.findViewById(R.id.listing)).setText(courseListing.getCourseName());
        ((TextView) itemView.findViewById(R.id.listing_borough)).setText(courseListing.getBorough());
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(itemView.getContext(), DetailsActivity.class);
                intent.putExtra(DetailsActivity.DESCRIPTION, courseListing.getCourseDescription());
                intent.putExtra(DetailsActivity.ADDRESS, courseListing.getAddress());
                intent.putExtra(DetailsActivity.PHONE_NUMBER, courseListing.getPhoneNumber());
                intent.putExtra(DetailsActivity.WEBSITE,courseListing.getWebsite());
                intent.putExtra(DetailsActivity.DURATION, courseListing.getDuration());
                itemView.getContext().startActivity(intent);
            }
        });
    }
}
