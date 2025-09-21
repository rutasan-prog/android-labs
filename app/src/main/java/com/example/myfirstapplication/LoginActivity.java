package com.example.myfirstapplication;

import android.os.Bundle;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Экран авторизации: подключает нужный макет и обрабатывает ввод пользователя,
 * показывая введённый логин всплывающим сообщением и в текстовом поле.
 * Также при переключения языка на эмуляторе меняется значение строковых данных, благодаря strings(en) и strings.
 * Все используемые цвета и размеры были структурированы по отдельным файлам.
 * Добавлена собственная иконка, скачанная с интернета формата png 512x512. Всё пропаисано в AndroidManifest.
 * Шестую лабораторнуб работу начну с перехода на NamesListActivity.
 */

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        boolean USE_CONSTRAINT = true;
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
