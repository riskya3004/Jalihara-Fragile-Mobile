package com.example.fragile_jalihara;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.content.Intent;

public class LoadingPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading_page);
    }

    public void goToLogin(View view) {
        startActivity(new Intent(LoadingPage.this, LoginPage.class));
    }
}