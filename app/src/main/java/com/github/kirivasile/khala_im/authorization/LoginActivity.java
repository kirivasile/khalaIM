package com.github.kirivasile.khala_im.authorization;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.github.kirivasile.khala_im.R;
import com.github.kirivasile.khala_im.menu.MenuActivity;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView mCreateButton;
    private Button mLoginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mCreateButton = (TextView) findViewById(R.id.Create);
        mCreateButton.setOnClickListener(this);

        mLoginButton = (Button) findViewById(R.id.loginButton);
        mLoginButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.Create:
                Intent registerIntent = new Intent(this, RegistrationActivity.class);
                startActivity(registerIntent);
                break;
            case R.id.loginButton:
                Intent loginIntent = new Intent(this, MenuActivity.class);
                startActivity(loginIntent);
                finish();
                break;
            default:
                break;
        }
    }
}
