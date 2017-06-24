package hiphophacktivist.ignite.view;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import hiphophacktivist.ignite.Model.CourseListing;
import hiphophacktivist.ignite.R;

class JobPostViewHolder extends RecyclerView.ViewHolder {
    private final TextView textview;

    public JobPostViewHolder(View itemView) {
        super(itemView);
        textview = (TextView) itemView.findViewById(R.id.tv_view);
    }

    public void bind(CourseListing courseListing) {
        textview.setText(courseListing.getCourseDescription());
    }
}
