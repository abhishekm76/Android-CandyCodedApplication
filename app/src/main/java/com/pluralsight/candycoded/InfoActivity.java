package com.pluralsight.candycoded;

import android.content.Intent;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.net.Uri;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.ImageView;
import com.squareup.picasso.Picasso;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class InfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        Uri uri = Uri.parse("android.resource://com.codeschool.candycoded/" + R.drawable.store_front);
        ImageView candyStoreImageView = (ImageView)findViewById(R.id.image_view_candy_store);
        Picasso.with(this).
                load(uri).
                into(candyStoreImageView);


    }

    // ***
    // TODO - Task 2 - Launch the Google Maps Activity
    // ***
    public void createMapIntent(View view){
        Uri uri = Uri.parse("geo:0,0?q=618 E South St Orlando, FL 32801");
        Intent intent = new Intent(Intent.ACTION_VIEW,uri);
        intent.setPackage("com.google.android.apps.maps");

        if(intent.resolveActivity(getPackageManager())!= null){
            startActivity(intent);
        }
    }
    // TODO: 21-07-2021 created an Uri with a tag for a map, then intent with actionview with uri created (uri passed at creation) then set package for google maps (check on activity and then started)

    // ***
    // TODO - Task 3 - Launch the Phone Activity
    // ***
    public void createPhoneIntent(View view){
        Intent phoneIntent = new Intent(Intent.ACTION_DIAL);
        Uri uri = Uri.parse("tel:0123456789");
        phoneIntent.setData(uri);
        startActivity(phoneIntent);
    }
// TODO: 21-07-2021 created a phone intent with action dial and uri phone number set as data to the intent
}
