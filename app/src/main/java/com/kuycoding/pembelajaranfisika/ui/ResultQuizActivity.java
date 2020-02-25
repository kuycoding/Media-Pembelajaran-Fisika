package com.kuycoding.pembelajaranfisika.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.kuycoding.pembelajaranfisika.R;

import java.util.Objects;

public class ResultQuizActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView tvResult;
    private Button btnHome;
    private Button btnShare;
    private Button btnRate;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try
        {
            Objects.requireNonNull(this.getSupportActionBar()).hide();
        }
        catch (NullPointerException ignored){}
        setContentView(R.layout.activity_result_quiz);

        tvResult = findViewById(R.id.txt_result);
        btnHome = findViewById(R.id.btn_home);
        btnShare = findViewById(R.id.btn_share);
        btnRate = findViewById(R.id.btn_rate);

        btnHome.setOnClickListener(this);
        btnShare.setOnClickListener(this);
        btnRate.setOnClickListener(this);

        Intent intent = getIntent();
        int score = intent.getIntExtra("score", 0);
        tvResult.setText("" + score);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_home:
                Intent intentHome = new Intent(ResultQuizActivity.this, MainActivity.class);
                startActivity(intentHome);
                finish();
                break;
            case R.id.btn_rate:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" +getPackageName())));
                break;
            case R.id.btn_share:
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
