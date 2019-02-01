package com.example.week4test.view.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.week4test.R;
import com.example.week4test.model.datasource.OkHttp.OkHttpHelper;

import static com.example.week4test.model.Constants.BASE_URL;

public class MainActivity extends AppCompatActivity implements MainActivityContract {
    MainActivityPresenter mainActivityPresenter;
    EditText etSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etSearch = findViewById(R.id.etSearch);
    }


    public void onClick(View view) {
        String query;

    }
}
