package com.example.myfirstapplication;

import android.os.Bundle;

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

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_names_list);

        RecyclerView namesRecyclerView = findViewById(R.id.namesRecyclerView);
        namesRecyclerView.setLayoutManager(new LinearLayoutManager(this));

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

        NamesAdapter adapter = new NamesAdapter(names);
        namesRecyclerView.setAdapter(adapter);
    }
}