package com.example.jobapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jobapplication.data.UserDetails;

public class SearchUser extends AppCompatActivity {

    Button btnRemove, btnUpdate, btnCancel, btnLockUnlock, btnSearch;
    LinearLayout textsLayout, buttonsLayout;
    EditText txtSearch;
    TextView lblName, lblEmail, lblLock, lblAddress;
    UserDetails details = new UserDetails();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_user);

        textsLayout = (LinearLayout) findViewById(R.id.layout_search_texts);
        buttonsLayout = (LinearLayout) findViewById(R.id.layout_search_buttons);

        textsLayout.setVisibility(View.GONE);
        buttonsLayout.setVisibility(View.GONE);

        btnSearch = (Button) findViewById(R.id.btn_search);
        btnLockUnlock = (Button) findViewById(R.id.btn_search_lock_unlock);
        btnRemove = (Button) findViewById(R.id.btn_search_remove);
        btnCancel = (Button) findViewById(R.id.btn_search_cancel);
        btnUpdate = (Button) findViewById(R.id.btn_search_update);

        txtSearch = (EditText) findViewById(R.id.txt_search_for_name);

        lblName = (TextView) findViewById(R.id.txt_searching_name);
        lblEmail = (TextView) findViewById(R.id.txt_search_email);
        lblLock = (TextView) findViewById(R.id.txt_search_lock);
        lblAddress = (TextView) findViewById(R.id.txt_search_userAddress);

    }

    public void btn_search_clicked(View view){

        String name = txtSearch.getText().toString().trim();

        String[] values = details.getUser(name);

        if(values != null){

            textsLayout.setVisibility(View.VISIBLE);
            buttonsLayout.setVisibility(View.VISIBLE);

            lblName.setText(name);
            lblEmail.setText(values[3]);
            lblAddress.setText(values[4]);

            if(values[6] == "false"){
                lblLock.setText("Unlocked");
                btnLockUnlock.setText("Lock");
            }else{
                lblLock.setText("Locked");
                btnLockUnlock.setText("Unlock");
            }

        }
        else {

            textsLayout.setVisibility(View.GONE);
            buttonsLayout.setVisibility(View.GONE);

            lblName.setText("");
            lblEmail.setText("");
            lblAddress.setText("");
            lblLock.setText("");
            Toast.makeText(SearchUser.this, "Oops! user not found", Toast.LENGTH_SHORT).show();
        }

    }

    public void btn_search_update_clicked(View view){

        String name = txtSearch.getText().toString().trim();
        Intent intent = new Intent(this, UpdateProfile.class);
        intent.putExtra("uName", name);
        startActivity(intent);
    }

    public void btn_search_remove_clicked(View view){

        String name = txtSearch.getText().toString().trim();
        Toast.makeText(SearchUser.this, name, Toast.LENGTH_SHORT).show();
        details.removeAccount(name);

        recreate();
    }

    public void btn_search_lock_unlock_clicked(View view){

        String name = lblName.getText().toString().trim();
        String text = lblLock.getText().toString();

        if(text == "Unlocked") {

            textsLayout.setVisibility(View.VISIBLE);
            buttonsLayout.setVisibility(View.VISIBLE);
            details.lockUnlock(name, true);
            lblLock.setText("Locked");
            btnLockUnlock.setText("Unlock");

        }else {

            details.lockUnlock(name, false);
            lblLock.setText("Unlocked");
            btnLockUnlock.setText("Lock");
        }

    }

    public void btn_search_cancel_clicked(View view){

        startActivity(new Intent(SearchUser.this, Admin_Page.class));
    }

}