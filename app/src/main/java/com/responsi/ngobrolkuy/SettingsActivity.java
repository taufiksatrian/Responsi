package com.responsi.ngobrolkuy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class SettingsActivity extends AppCompatActivity {
    private TextView htvUsername, htvPassword, btnGantiPassword, btnGantiFoto;
    private ImageView btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        htvUsername = findViewById(R.id.tvUsername);
        htvPassword = findViewById(R.id.tvPassword);

        htvUsername.setText(getIntent().getStringExtra("username"));
        htvPassword.setText(getIntent().getStringExtra("password"));

        btnGantiPassword = findViewById(R.id.btnGantiPassword);
        btnGantiPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SettingsActivity.this, SettingsTerapkanActivity.class);
                i.putExtra("username", getIntent().getStringExtra("username"));
                i.putExtra("password", getIntent().getStringExtra("password"));
                startActivity(i);
            }
        });

        btnGantiFoto = findViewById(R.id.btnGantiFoto);
        btnGantiFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SettingsActivity.this, SettingsGantiActivity.class);
                startActivity(i);
            }
        });

        btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SettingsActivity.this, MainHomeChatActivity.class);
                startActivity(i);
            }
        });
    }
}