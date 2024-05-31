package com.example.fragile_jalihara;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginPage extends AppCompatActivity {

    EditText userName;
    EditText password;
    TextView errorText;
    
    Button loginbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        userName = findViewById(R.id.userName);
        password = findViewById(R.id.password);
        errorText = findViewById(R.id.errorText);
        loginbtn = findViewById(R.id.loginbtn);

        GlobalClass globalClass = (GlobalClass) getApplicationContext();
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!validateUsername()){
                    return;
                } else if (!validatePassword()) {
                    return;
                } else{
                    globalClass.setUsername(userName.getText().toString());
                    globalClass.setPassword(password.getText().toString());
                    startActivity(new Intent(LoginPage.this, HomePage.class));
                }
            }
        });
    }

    private boolean validateUsername(){
        String userVal = userName.getText().toString();

        if (userVal.isEmpty()){
            errorText.setText("Username can't be Empty");
//            userName.setError("Field Cannot be Empty");
            return false;
        } else if (userVal.length()<=5) {
            errorText.setText("Username must be more than 5");
//            userName.setError("Username must be more than 5");
            return false;
        } else {
            userName.setError(null);
            return true;
        }
    }

    private boolean validatePassword(){
        String userVal = password.getText().toString();

        if (userVal.isEmpty()){
            errorText.setText("Password can't be Empty");
//            userName.setError("Field Cannot be Empty");
            return false;
        } else if (userVal.length()<=5) {
            errorText.setText("password must be more than 8");
//            userName.setError("Username must be more than 5");
            return false;
        } else {
            password.setError(null);
            return true;
        }
    }

    public void goToHome(View view) {
        if (!validateUsername() | !validatePassword()){
            return;
        }else{
            startActivity(new Intent(LoginPage.this, AboutUs.class));
        }
    }
}