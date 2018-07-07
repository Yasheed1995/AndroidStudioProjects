package com.example.logan1436.mmmo;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private ImageView image_cover;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // def
        // widgets
        image_cover = findViewById(R.id.imageView_cover);
        Button button_switch_to_clothes = findViewById(R.id.switch_to_clothes);
        Button button_switch_to_cards = findViewById(R.id.switch_to_cards);
        // firebase references
        StorageReference mStorageRef = FirebaseStorage.getInstance().getReference();

        // cover_path
        StorageReference riversRef = mStorageRef.child("20170228_170301_0016.jpg");

        // switch to clothes button
        button_switch_to_clothes.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Log.v("click", "button_profile");
                switchToClothes();
            }
        });

        // switch to cards button
        button_switch_to_cards.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Log.v("click", "button_profile");
                switchToCards();
            }
        });

        File localFile = null;
        try {
            // temp file path
            localFile = File.createTempFile("images", "jpg");
        } catch (IOException e) {
            e.printStackTrace();
        }
        final File finalLocalFile = localFile;
        assert localFile != null;
        riversRef.getFile(localFile)
                .addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                        // Successfully downloaded data to local file
                        // ...
                        image_cover.setImageBitmap(BitmapFactory.decodeFile(String.valueOf(finalLocalFile)));
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                // Handle failed download
                // ...
            }
        });
    }

    private void switchToClothes()
    {
        final Intent _intent = new Intent();
        _intent.setClass(MainActivity.this, ClothesActivity.class);
        startActivity(_intent);
    }

    private void switchToCards()
    {
        Intent _intent = new Intent();
        _intent.setClass(MainActivity.this, CardsActivity.class);
        Bundle _bundle = new Bundle();
        _intent.putExtras(_bundle);
        startActivity(_intent);
    }
}
