package com.example.myfirstapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
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

    private TextView tvLoginResult;
    private ActivityResultLauncher<Intent> namesListLauncher;

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
        tvLoginResult = findViewById(R.id.tvLoginResult);

        namesListLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == Activity.RESULT_OK && result.getData() != null) {
                        String selectedName = result.getData().getStringExtra(NamesListActivity.EXTRA_SELECTED_NAME);
                        if (!TextUtils.isEmpty(selectedName)) {
                            String message = getString(R.string.selected_name_result, selectedName);
                            tvLoginResult.setText(message);
                            Toast.makeText(LoginActivity.this, message, Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );

        btnSignIn.setOnClickListener(view -> {
            String loginText = etLogin.getText().toString();
            Toast.makeText(LoginActivity.this, loginText, Toast.LENGTH_SHORT).show();
            tvLoginResult.setText(loginText);

            Intent intent = new Intent(LoginActivity.this, NamesListActivity.class);
            intent.putExtra(NamesListActivity.EXTRA_LOGIN, loginText);
            namesListLauncher.launch(intent);
        });
    }
}
