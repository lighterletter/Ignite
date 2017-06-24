package hiphophacktivist.ignite.view;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import hiphophacktivist.ignite.Model.CourseListing;
import hiphophacktivist.ignite.R;

class ProgramListingViewHolder extends RecyclerView.ViewHolder {
    public ProgramListingViewHolder(View itemView) {
        super(itemView);
    }

    public void bind(CourseListing courseListing) {
        ((TextView)itemView.findViewById(R.id.listing)).setText(courseListing.getCourseName());
        ((TextView) itemView.findViewById(R.id.listing_borough)).setText(courseListing.getBorough());
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
