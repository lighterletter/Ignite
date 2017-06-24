package hiphophacktivist.ignite.view;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import hiphophacktivist.ignite.Model.JobPosting;
import hiphophacktivist.ignite.R;

public class JobPostsAdapter extends RecyclerView.Adapter<JobPostViewHolder> {


    private final List<JobPosting> mJobList;

    public JobPostsAdapter(List<JobPosting> jobList) {
        this.mJobList = jobList;
    }

    @Override
    public JobPostViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new JobPostViewHolder(LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.viewholder_job_post,parent,false));
    }

    @Override
    public void onBindViewHolder(JobPostViewHolder holder, int position) {
        holder.bind(mJobList.get(position));
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public void setJobPostList(List<JobPosting> photoList){
        mJobList.clear();
        mJobList.addAll(photoList);
        notifyDataSetChanged();
    }
}
