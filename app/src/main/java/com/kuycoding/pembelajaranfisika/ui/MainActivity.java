package com.kuycoding.pembelajaranfisika.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.kuycoding.pembelajaranfisika.R;

import java.util.Objects;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btMateriPage, btInfoPage, btnQuiz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try
        {
            Objects.requireNonNull(this.getSupportActionBar()).hide();
        }
        catch (NullPointerException ignored){}
        setContentView(R.layout.activity_main);

        btMateriPage = findViewById(R.id.btMateri_page);
        btMateriPage.setOnClickListener(this);
        btInfoPage = findViewById(R.id.bt_info);
        btInfoPage.setOnClickListener(this);
        btnQuiz = findViewById(R.id.btnQuiz_page);
        btnQuiz.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btMateri_page:
                Intent intent = new Intent(MainActivity.this, MateriActivity.class);
                startActivity(intent);
                break;
            case R.id.bt_info:
                Intent intent1 = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(intent1);
                break;
            case R.id.btnQuiz_page:
                Intent intent2 = new Intent(MainActivity.this, QuizActivity.class);
                startActivity(intent2);
                break;
        }
    }
}
