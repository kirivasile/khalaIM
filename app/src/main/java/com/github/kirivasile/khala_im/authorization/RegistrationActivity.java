package com.github.kirivasile.khala_im.authorization;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.github.kirivasile.khala_im.R;

public class RegistrationActivity extends AppCompatActivity {
    private Toolbar mToolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        manageToolBar();
    }

    private void manageToolBar() {
        mToolBar = (Toolbar)findViewById(R.id.toolBar);
        mToolBar.setTitle("Регистрация");
        mToolBar.setTitleTextColor(Color.WHITE);
        mToolBar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);
        setSupportActionBar(mToolBar);
        mToolBar.setNavigationOnClickListener((View view) -> {
            onBackPressed();
        });
    }
}
