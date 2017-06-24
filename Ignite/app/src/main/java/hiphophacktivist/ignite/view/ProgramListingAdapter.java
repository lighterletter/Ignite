package hiphophacktivist.ignite.view;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

import hiphophacktivist.ignite.Model.CourseListing;
import hiphophacktivist.ignite.R;

public class ProgramListingAdapter extends RecyclerView.Adapter<ProgramListingViewHolder> {


    private final List<CourseListing> courseList;

    public ProgramListingAdapter(List<CourseListing> courseList) {
        this.courseList = courseList;
    }

    @Override
    public ProgramListingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ProgramListingViewHolder(LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.viewholder_job_post,parent,false));
    }

    @Override
    public void onBindViewHolder(ProgramListingViewHolder holder, int position) {
        holder.bind(courseList.get(position));
    }

    @Override
    public int getItemCount() {
        return courseList.size();
    }

    public void setListings(List<CourseListing> photoList){
        courseList.clear();
        courseList.addAll(photoList);
        notifyDataSetChanged();
    }
}
