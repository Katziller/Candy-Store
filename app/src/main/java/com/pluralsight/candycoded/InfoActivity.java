package com.pluralsight.candycoded;

import android.content.Intent;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.net.Uri;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class InfoActivity extends AppCompatActivity {
    EditText url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        EditText text = findViewById (R.id.url);

        text.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                Toast.makeText (getApplicationContext(), "", Toast.LENGTH_SHORT ).show ();

            }
        } );

        Uri uri = Uri.parse("android.resource://com.codeschool.candycoded/" + R.drawable.store_front);
        ImageView candyStoreImageView = (ImageView)findViewById(R.id.image_view_candy_store);
        Picasso.get().
                load(uri).
                into(candyStoreImageView);

        Intent mapIntent = getIntent ();

        if (mapIntent.resolveActivity(getPackageManager()) != null); {
            startActivity(mapIntent);

        }


    }

    public void createMapIntent(View view) {

        Uri url = Uri.parse ( "geo:0,0?q=618 E South St Orlando, FL 32801" );
        Intent intent = new Intent (Intent.ACTION_VIEW, url);
        intent.setPackage ("com.google.android.apps.maps");
        startActivity (intent);

    }



    // ***
    // TODO - Task 2 - Launch the Google Maps Activity
    // ***

    // ***
    // TODO - Task 3 - Launch the Phone Activity
    // ***

}
