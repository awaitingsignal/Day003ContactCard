package com.ravebiz.day003contactcard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (getIntent().hasExtra("NAME")){
            TextView t = findViewById(R.id.myNameTextView);
            t.setText(getIntent().getStringExtra("NAME"));
//        }
//        if (getIntent().hasExtra("JOB")){
//            TextView t = findViewById(R.id.devDescTextView);
//            t.setText(getIntent().getStringExtra("JOB"));
        }
        if (getIntent().hasExtra("AGE")){
            TextView t = findViewById(R.id.ageTextView);
            t.setText(getIntent().getStringExtra("AGE"));
        }
        if (getIntent().hasExtra("ADDRESS")){
            TextView t = findViewById(R.id.addressTextView);
            t.setText(getIntent().getStringExtra("ADDRESS"));
        }
        if (getIntent().hasExtra("EMAIL")){
            TextView t = findViewById(R.id.emailTextView);
            t.setText(getIntent().getStringExtra("EMAIL"));
        }
        if (getIntent().hasExtra("PHONE")){
            TextView t = findViewById(R.id.phoneTextView);
            t.setText(getIntent().getStringExtra("PHONE"));
        }
        if (getIntent().hasExtra("DAY") && (getIntent().hasExtra("YEAR") && getIntent().hasExtra("MONTH"))){
            TextView t = findViewById(R.id.freeLanceTextView);
            String m = getIntent().getStringExtra("MONTH");
            String d = getIntent().getStringExtra("DAY");
            String y = getIntent().getStringExtra("YEAR");
            t.setText(getString(R.string.freeLanceDate, m, d, y));
        }
        if (getIntent().hasExtra("CITY") && getIntent().hasExtra("STATE") && getIntent().hasExtra("ZIP")){
            TextView t = findViewById(R.id.addressTextView);
            String c = getIntent().getStringExtra("CITY");
            String s = getIntent().getStringExtra("STATE");
            String z = getIntent().getStringExtra("ZIP");
            t.setText(getString(R.string.fullAddress, c, s, z));
        }
        /*if (getIntent().hasExtra("")){
            TextView t = findViewById(R.id.);
            t.setText(getIntent().getStringExtra(""));
        }*/

    }
    public void exitProgram(View view)
        {
        Intent homeIntent = new Intent(Intent.ACTION_MAIN);
        homeIntent.addCategory( Intent.CATEGORY_HOME );
        homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(homeIntent);
    }
}
