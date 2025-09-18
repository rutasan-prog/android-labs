package com.example.myfirstapplication;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        boolean USE_CONSTRAINT = false;
        if (USE_CONSTRAINT) {
            setContentView(R.layout.activity_login_constraint);
        } else {
            setContentView(R.layout.activity_login_linear);
        }
    }
}
