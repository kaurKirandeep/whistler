package com.example.jobapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.jobapplication.data.AdminData;
import java.util.ArrayList;
import java.util.List;

public class AdminAdapter extends ArrayAdapter<String> {

    Context context;
    ArrayList<AdminData> listings;
    AdminData listing;

    public AdminAdapter(@NonNull Context context, int res, @NonNull ArrayList<AdminData> listings){
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
        View rowView = inflater.inflate(R.layout.activity_admin__listing, parent, false);

        TextView jobName = (TextView) rowView.findViewById(R.id.txt_Admin_JobName);
        TextView appName = (TextView) rowView.findViewById(R.id.txt_admin_UName);
        ImageView jobImage = (ImageView) rowView.findViewById(R.id.img_admin_listing_Image);

        jobName.setText("Job name: " + listings.get(position).getJobNameApplied());
        appName.setText("Applicant name: " + listings.get(position).getApplicantName());
        jobImage.setImageResource(listing.getImageID(listings.get(position).getImagePath()));

        return rowView;
    }

}
