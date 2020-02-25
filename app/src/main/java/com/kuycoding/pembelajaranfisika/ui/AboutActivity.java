package com.kuycoding.pembelajaranfisika.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.kuycoding.pembelajaranfisika.R;

import org.w3c.dom.Text;

import java.util.Objects;

public class AboutActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView imgRate, imgShare;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_ACTION_BAR_OVERLAY);
        setContentView(R.layout.activity_about);

        imgRate = findViewById(R.id.img_rate);
        imgShare = findViewById(R.id.img_share);
        imgShare.setOnClickListener(this);
        imgRate.setOnClickListener(this);

        String namaafif = "Afif Nor Yusuf";
        TextView tv_afif = findViewById(R.id.txt_afif);
        tv_afif.setText(namaafif);

        String contributorafif = "Android Developer";
        TextView tv_contributorafif = findViewById(R.id.txt_contributor_afif);
        tv_contributorafif.setText(contributorafif);

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Tentang");
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.img_rate:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" +getPackageName())));
                break;
            case R.id.img_share:
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT,
                        "Hai, ayo download dan belajar Fisika bersama di https://play.google.com/store/apps/details?id="+getPackageName());
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
                break;
        }
    }
}
