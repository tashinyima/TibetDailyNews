package com.potalainfotech.tibetdailynews;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.potalainfotech.tibetdailynews.dashboard.DashboardActivity;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    EditText userNameorEmailet,userPasswordet;
    Button loginButton;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initView();
        setupToolbar();


    }

    private void setupToolbar() {

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TextView textViewTitle = (TextView) toolbar.findViewById(R.id.textViewTitle);


    }

    private void initView() {
        userNameorEmailet = (EditText) findViewById(R.id.userNameEditText);
        userPasswordet = (EditText) findViewById(R.id.passwordEditText);
        loginButton = (Button) findViewById(R.id.submitButton) ;
        loginButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.submitButton:
                showMessage("Thank you");
                Login();
                break;
        }
    }

    private void Login() {

        Intent intent= new Intent(LoginActivity.this, DashboardActivity.class);
        startActivity(intent);



    }

    private void showMessage(String s) {

        Toast.makeText(this,s, Toast.LENGTH_SHORT).show();
    }
}
