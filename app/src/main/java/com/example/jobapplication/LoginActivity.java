package com.example.jobapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.jobapplication.data.UserDetails;

public class LoginActivity extends AppCompatActivity {

    Button btnLogin;
    EditText txtUserName, txtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin = findViewById(R.id.btn_login_signin);
        txtUserName = findViewById(R.id.txt_login_username);
        txtPassword = findViewById(R.id.txt_login_password);
    }

    public void btn_click_login(View view){

        UserDetails details = new UserDetails();
        String uName = txtUserName.getText().toString();
        String uPass = txtPassword.getText().toString();

        //check if values are empty
        if(!(uName.isEmpty() || uPass.isEmpty())){
            String[] values = details.checkCredentials(uName, uPass);

            //Checking details
            if(values != null){

                //checking the account is locked
                if(values[2] == "false"){

                    //checking the usertype
                    if(values[1] == "user") {

                        Toast.makeText(this, "You logged as : " + values[1], Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(this, JobPage.class);
                        intent.putExtra("Name", values[0]);
                        startActivity(intent);
                        finish();
                    }else {
                        Toast.makeText(this, "You logged as : " + values[1], Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(this, Admin_Page.class);
                        intent.putExtra("Name", values[0]);
                        startActivity(intent);
                        finish();
                    }

                }else{
                    Toast.makeText(this, "Sorry your account is locked.", Toast.LENGTH_SHORT).show();

                }

            }else{
                Toast.makeText(this, "Invalid Details.", Toast.LENGTH_SHORT).show();
            }

        }
        else{
            Toast.makeText(this, "The fields shouldn't be empty.", Toast.LENGTH_SHORT).show();
        }
    }

}