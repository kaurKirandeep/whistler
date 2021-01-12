package com.example.jobapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.jobapplication.data.JobListing;

import java.util.ArrayList;


public class JobListAdapter extends ArrayAdapter<String> {

    Context context;
    ArrayList<JobListing> listings;
    JobListing listing;

    public JobListAdapter(@NonNull Context context, int res, @NonNull ArrayList<JobListing> listings){
        super(context, res);
        this.context = context;
        this.listings =listings;
    }

    @Override
    public int getCount() {
        return listings.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(final int position, View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.activity_listing, parent, false);

        TextView jobName = (TextView) rowView.findViewById(R.id.txt_listing_JobName);
        TextView jobDesc = (TextView) rowView.findViewById(R.id.txt_listing_JobDesc);
        TextView jobSalary = (TextView) rowView.findViewById(R.id.txt_listing_JobSalary);
        ImageView jobImage = (ImageView) rowView.findViewById(R.id.img_listing_Image);

        jobName.setText(listings.get(position).getJobName());
        jobDesc.setText(listings.get(position).getJobDescription());
        String value = Double.toString(listings.get(position).getSalary());
        jobSalary.setText(value + "$");
        jobImage.setImageResource(listing.getImageID(listings.get(position).getImagePath()));

        return rowView;
    }
}
