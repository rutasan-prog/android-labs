package com.example.myfirstapplication;

import android.os.Bundle;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;


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
        EditText etLogin = findViewById(R.id.etLogin);
        Button btnSignIn = findViewById(R.id.btnSignIn);
        TextView tvLoginResult = findViewById(R.id.tvLoginResult);

        btnSignIn.setOnClickListener(view -> {
            String loginText = etLogin.getText().toString();
            Toast.makeText(LoginActivity.this, loginText, Toast.LENGTH_SHORT).show();
            tvLoginResult.setText(loginText);
        });
    }
}
