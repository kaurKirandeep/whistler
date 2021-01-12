package com.example.jobapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jobapplication.data.AdminData;
import com.example.jobapplication.data.JobListing;

import java.util.ArrayList;

public class JobPage extends AppCompatActivity {

    ListView listView;
    Context context;
    ArrayList arrayList;
    JobListing listing;
    ArrayList<JobListing> jobListings;
    TextView txtLabel;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_page);

        txtLabel = findViewById(R.id.txt_job_label);
        listView = (ListView) findViewById(R.id.menu_list_job);
        JobListing jobListing = new JobListing();

        ArrayList<JobListing> list = new ArrayList<JobListing>();
        list = jobListing.getAll();

        JobListAdapter jobListAdapter = new JobListAdapter(JobPage.this, R.id.gone, list);
        listView.setAdapter(jobListAdapter);

        Intent intent = getIntent();
        name = intent.getStringExtra("Name");
        txtLabel.setText("Welcome : " + name);

        ArrayList<JobListing> finalList = list;

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String nameJob = finalList.get(position).getJobName().toString();
                String image = finalList.get(position).getJobName().toString();
                Toast.makeText(JobPage.this, nameJob, Toast.LENGTH_SHORT).show();

                alertDialog(name, nameJob, image);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.user_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.menu_update_profile:

                Intent newIntent = getIntent();
                Intent intentUpdate = new Intent(this, UpdateProfile.class);
                intentUpdate.putExtra("uName", newIntent.getStringExtra("Name"));
                startActivity(intentUpdate);
                break;

            case R.id.menu_logout:
                startActivity(new Intent(this, MainActivity.class));
                finish();
                break;
        }

        return super.onOptionsItemSelected(item);
    }


    public void alertDialog(String name, String jobName, String image){

        String jName = jobName;

        AlertDialog.Builder dialog = new AlertDialog.Builder(JobPage.this);
        dialog.setMessage(jName);
        dialog.setTitle("Confirm application");

        dialog.setPositiveButton("YES",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,
                                        int which) {
                        AdminData data = new AdminData();
                        data.addNewAdminData(name, jobName, image);
                        Toast.makeText(JobPage.this,"Successfully submitted.",Toast.LENGTH_LONG).show();
                    }
                });

        dialog.setNegativeButton("Cancel",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(JobPage.this,"Application cancelled.",Toast.LENGTH_LONG).show();
            }
        });

        AlertDialog alertDialog = dialog.create();
        alertDialog.show();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }


}