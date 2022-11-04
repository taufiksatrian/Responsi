package com.responsi.ngobrolkuy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class SettingsTerapkanActivity extends AppCompatActivity {
    private EditText etEditPassword;
    private TextView btnTerapkan;
    private ImageView btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_terapkan);

        etEditPassword = findViewById(R.id.etEditPassword);

        btnTerapkan = findViewById(R.id.btnTerapkan);
        btnTerapkan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SettingsTerapkanActivity.this, MainHomeChatActivity.class);
                intent.putExtra("password", getIntent().getStringExtra("password"));
                startActivity(intent);
            }
        });

        btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SettingsTerapkanActivity.this, MainHomeChatActivity.class);
                startActivity(intent);
            }
        });
    }
}