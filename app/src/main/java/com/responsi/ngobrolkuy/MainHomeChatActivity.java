package com.responsi.ngobrolkuy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainHomeChatActivity extends AppCompatActivity {
    ExtendedFloatingActionButton btnLogout;
    ConstraintLayout chat1;
    ImageView btnSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_home_chat);

        btnLogout = findViewById(R.id.btn_Keluar);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainHomeChatActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        chat1 = findViewById(R.id.chat1);
        chat1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainHomeChatActivity.this, RoomChatActivity.class);
                startActivity(intent);
            }
        });

        btnSettings = findViewById(R.id.btn_Setting);
        btnSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainHomeChatActivity.this, SettingsActivity.class);
                intent.putExtra("username", getIntent().getStringExtra("username"));
                intent.putExtra("password", getIntent().getStringExtra("password"));
                startActivity(intent);
            }
        });
    }
}