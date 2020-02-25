package com.kuycoding.pembelajaranfisika.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;

import com.kuycoding.pembelajaranfisika.R;
import com.kuycoding.pembelajaranfisika.adapter.FisikaAdapter;
import com.kuycoding.pembelajaranfisika.model.Fisika;

import java.util.ArrayList;
import java.util.Objects;

public class MateriActivity extends AppCompatActivity {
    private RecyclerView rvMateri;
    private ArrayList<Fisika> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_ACTION_BAR_OVERLAY);
        setContentView(R.layout.activity_materi);

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        rvMateri = findViewById(R.id.rv_teori);
        rvMateri.setHasFixedSize(true);
        list.addAll(getListFisika());
        showRecyclerCardView();
        getSupportActionBar().setTitle("");
    }

    private void showRecyclerCardView(){
        rvMateri.setLayoutManager(new LinearLayoutManager(this));
        FisikaAdapter fisikaAdapter = new FisikaAdapter(list);
        rvMateri.setAdapter(fisikaAdapter);
    }

    public ArrayList<Fisika> getListFisika() {
        String[] dataTile = getResources().getStringArray(R.array.data_judul);
        String[] dataMateri1 = getResources().getStringArray(R.array.data_materi1);
        String[] dataMateri2 = getResources().getStringArray(R.array.data_materi2);
        @SuppressLint("Recycle") TypedArray dataGambar1 = getResources().obtainTypedArray(R.array.data_gambar1);
        @SuppressLint("Recycle") TypedArray dataGambar2 = getResources().obtainTypedArray(R.array.data_gambar2);
        @SuppressLint("Recycle") TypedArray dataSampul = getResources().obtainTypedArray(R.array.data_sampul);
        @SuppressLint("Recycle") TypedArray dataPoster = getResources().obtainTypedArray(R.array.data_poster);

        ArrayList<Fisika> listFisika = new ArrayList<>();
        for (int i=0; i < dataTile.length;i++){
            Fisika fisika = new Fisika();
            fisika.setJudul(dataTile[i]);
            fisika.setMateri1(dataMateri1[i]);
            fisika.setMateri2(dataMateri2[i]);
            fisika.setGambar1(dataGambar1.getResourceId(i, -1));
            fisika.setGambar2(dataGambar2.getResourceId(i, -1));
            fisika.setSampul(dataSampul.getResourceId(i,-1));
            fisika.setPoster(dataPoster.getResourceId(i,-1));

            listFisika.add(fisika);
        }
        return listFisika;
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
