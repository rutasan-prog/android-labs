package com.example.myfirstapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Arrays;
import java.util.List;

/**
 * Активити со списком имён, который создаёт RecyclerView и заполняет его статическими данными.
 */

public class NamesListActivity extends AppCompatActivity {

    public static final String EXTRA_LOGIN = "com.example.myfirstapplication.EXTRA_LOGIN";
    public static final String EXTRA_SELECTED_NAME = "com.example.myfirstapplication.EXTRA_SELECTED_NAME";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_names_list);

        setResult(Activity.RESULT_CANCELED);

        RecyclerView namesRecyclerView = findViewById(R.id.namesRecyclerView);
        namesRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        TextView greetingTextView = findViewById(R.id.tvGreeting);
        String login = getIntent().getStringExtra(EXTRA_LOGIN);
        if (TextUtils.isEmpty(login)) {
            greetingTextView.setText(R.string.names_list_default_greeting);
        } else {
            greetingTextView.setText(getString(R.string.names_list_greeting, login));
        }

        List<String> names = Arrays.asList(
                "Мурад",
                "Тимур",
                "Артём",
                "Илья",
                "Костя",
                "Димасик",
                "Дима",
                "Данил",
                "Никита"
        );

        NamesAdapter adapter = new NamesAdapter(names, selectedName -> {
            Intent resultData = new Intent();
            resultData.putExtra(EXTRA_SELECTED_NAME, selectedName);
            setResult(Activity.RESULT_OK, resultData);
            finish();
        });
        namesRecyclerView.setAdapter(adapter);
    }
}