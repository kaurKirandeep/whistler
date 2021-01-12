package com.example.jobapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.jobapplication.data.UserDetails;

public class UpdateProfile extends AppCompatActivity {

    EditText txtName, txtPassword, txtPhone, txtEmail, txtAddress, txtHrEmail;
    Button btnUpdate, btnCancel;
    UserDetails details = new UserDetails();
    String uName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_profile);

        txtName = (EditText) findViewById(R.id.txt_update_name);
        txtPassword = (EditText) findViewById(R.id.txt_update_password);
        txtPhone = (EditText) findViewById(R.id.txt_update_phone);
        txtEmail = (EditText) findViewById(R.id.txt_update_email);
        txtAddress = (EditText) findViewById(R.id.txt_update_userAddress);
        txtHrEmail = (EditText) findViewById(R.id.txt_update_hrEmail);
        btnUpdate = (Button) findViewById(R.id.btn_update);
        btnCancel = (Button) findViewById(R.id.btn_cancel);

        Intent intent = getIntent();
        uName = intent.getStringExtra("uName");

        getDetails(uName);

    }

    public void getDetails(String uName){

        String[] values = details.getUser(uName);

        if(values != null) {

            txtName.setText(values[0]);
            txtPassword.setText(values[1]);
            txtPhone.setText(values[2]);
            txtEmail.setText(values[3]);
            txtAddress.setText(values[4]);
            txtHrEmail.setText(values[5]);
        }
        else{
            Toast.makeText(this, "Empty list :" + uName, Toast.LENGTH_SHORT).show();
        }

    }
    public void btn_update_clicked(View view){

        String name = txtName.getText().toString();
        String password = txtPassword.getText().toString();
        Integer phone = Integer.parseInt(txtPhone.getText().toString());
        String email = txtEmail.getText().toString();
        String address = txtAddress.getText().toString();
        String hrEmail = txtHrEmail.getText().toString();

        if(!(name.isEmpty() || password.isEmpty() || phone == null || email.isEmpty() || address.isEmpty() || hrEmail.isEmpty())){

            details.updateDetails(name, password, phone, email, address, hrEmail);
            this.recreate();
        }else{
            Toast.makeText(this, "The fields shouldn't be empty", Toast.LENGTH_SHORT).show();
        }
    }


    public void btn_cancel_clicked(View view){

        Toast.makeText(UpdateProfile.this, "Changes not saved", Toast.LENGTH_SHORT).show();
    }


}