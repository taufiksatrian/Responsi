package com.responsi.ngobrolkuy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.Nullable;

import android.content.Intent;
import android.os.Bundle;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;

public class ProfilePicActivity extends AppCompatActivity {
    private ImageView btnEdit, imgProfile;
    private Uri imageUri;
    private Button btnLanjut, btnLewati;
    private String uriString = null;

    private int GALLERY_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_pic);

        btnEdit = findViewById(R.id.pinkCircle);
        imgProfile = findViewById(R.id.profilePic);
        btnLanjut = findViewById(R.id.btn_Lanjut);
        btnLewati = findViewById(R.id.btn_Lewati);

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI), GALLERY_REQUEST_CODE);
            }
        });

        btnLewati.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ProfilePicActivity.this, MainHomeChatActivity.class);
                i.putExtra("KEY_URI", uriString);
                startActivity(i);
            }
        });
        btnLanjut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ProfilePicActivity.this, MainHomeChatActivity.class);
                i.putExtra("KEY_URI", uriString);
                startActivity(i);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_CANCELED) {
            Toast.makeText(this, "Gagalkan Upload Gambar", Toast.LENGTH_SHORT).show();
            return;
        }
        if (requestCode == GALLERY_REQUEST_CODE) {
            if (data != null) {
                try {
                    imageUri = data.getData();
                    uriString = imageUri.toString();
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imageUri);
                    imgProfile.setImageBitmap(bitmap);
                    btnLewati.setVisibility(View.INVISIBLE);
                    btnLanjut.setVisibility(View.VISIBLE);
                } catch (Exception e) {
                    Toast.makeText(this, "Tidak Bisa Memasukan Gambar", Toast.LENGTH_SHORT).show();
                }
            }
            else Toast.makeText(this, "Not", Toast.LENGTH_SHORT).show();
        }
    }
}