package hiphophacktivist.ignite.view;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

import hiphophacktivist.ignite.Model.CourseListing;
import hiphophacktivist.ignite.R;

public class ProgramListingAdapter extends RecyclerView.Adapter<ProgramListingViewHolder> {


    private final List<CourseListing> mJobList;

    public ProgramListingAdapter(List<CourseListing> jobList) {
        this.mJobList = jobList;
    }

    @Override
    public ProgramListingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ProgramListingViewHolder(LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.viewholder_job_post,parent,false));
    }

    @Override
    public void onBindViewHolder(ProgramListingViewHolder holder, int position) {
        holder.bind(mJobList.get(position));
    }

    @Override
    public int getItemCount() {
        return mJobList.size();
    }

    public void setListings(List<CourseListing> photoList){
        mJobList.clear();
        mJobList.addAll(photoList);
        notifyDataSetChanged();
    }
}
