package com.kuycoding.pembelajaranfisika.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.kuycoding.pembelajaranfisika.R;
import com.kuycoding.pembelajaranfisika.model.Fisika;

import java.util.Objects;

public class DetailActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String EXTRA_FISIKA = "extra_fisika";
    private TextView tvTitle, tvMateri1, tvMateri2;
    private ImageView imgSampul, imgGambar1, imgGambar2;
    private Button btQuiz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        tvTitle = findViewById(R.id.tv_title);
        tvMateri1 = findViewById(R.id.tv_materi1);
        tvMateri2 = findViewById(R.id.tv_materi2);
        imgGambar1 = findViewById(R.id.img_materi1);
        imgGambar2 = findViewById(R.id.img_materi2);
        imgSampul = findViewById(R.id.img_sampul);

        Fisika fisika = getIntent().getParcelableExtra(EXTRA_FISIKA);

        assert fisika != null;
        tvTitle.setText(fisika.getJudul());
        tvMateri1.setText(fisika.getMateri1());
        tvMateri2.setText(fisika.getMateri2());

        Glide.with(this)
                .load(fisika.getGambar1())
                .apply(new RequestOptions().override(550, 350))
                .into(imgGambar1);

        Glide.with(this)
                .load(fisika.getGambar2())
                .apply(new RequestOptions().override(550, 350))
                .into(imgGambar2);

        Glide.with(this)
                .load(fisika.getSampul())
                .apply(new RequestOptions().override(550, 350))
                .into(imgSampul);

        getSupportActionBar().setTitle(fisika.getJudul());


    }

    @Override
    public void onClick(View v) {

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
}
