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

import java.util.ArrayList;

public class Admin_Page extends AppCompatActivity {

    ListView listView;
    Context context;
    ArrayList arrayList;
    AdminData listing;
    ArrayList<AdminData> jobListings;
    TextView txtLabel;
    public String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin__page);

        txtLabel = findViewById(R.id.txt_admin_Label);
        Intent intent = getIntent();
        name = intent.getStringExtra("Name");
        txtLabel.setText("Welcome admin : " + name);

        addList();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.admin_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.menu_search_user:
                startActivity(new Intent(this, SearchUser.class));
                break;

            case R.id.menu_admin_logout:
                startActivity(new Intent(this, MainActivity.class));
                finish();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    public void addList(){

        listView = (ListView) findViewById(R.id.menu_admin_jobs);
        AdminData adminData = new AdminData();

        ArrayList<AdminData> list = new ArrayList<AdminData>();
        list = adminData.getAll();

        AdminAdapter adminAdapter = new AdminAdapter(Admin_Page.this, R.id.gone, list);
        listView.setAdapter(adminAdapter);

        ArrayList<AdminData> finalList = list;
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String nameJob = finalList.get(position).getJobNameApplied().toString();
                String appName = finalList.get(position).getApplicantName().toString();
                Toast.makeText(Admin_Page.this, nameJob, Toast.LENGTH_SHORT).show();

                alertDialog(appName, nameJob);
            }
        });
    }

    public void alertDialog(String name, String jobName){

        String appName = name;

        AlertDialog.Builder dialog = new AlertDialog.Builder(Admin_Page.this);
        dialog.setMessage("Do you want to delete this application: " + appName);
        dialog.setTitle("Confirm application");

        dialog.setPositiveButton("Delete",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,
                                        int which) {
                        AdminData data = new AdminData();
                        data.removeApplication(jobName, name);
                        Toast.makeText(Admin_Page.this,"Successfully deleted.",Toast.LENGTH_LONG).show();
                        addList();
                    }
                });

        dialog.setNegativeButton("Cancel",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(Admin_Page.this,"Application cancelled.",Toast.LENGTH_LONG).show();
            }
        });

        AlertDialog alertDialog = dialog.create();
        alertDialog.show();

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    public void btn_Click_Admin_Logout(View view){

        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}