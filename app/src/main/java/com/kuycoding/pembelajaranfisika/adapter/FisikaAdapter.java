package com.kuycoding.pembelajaranfisika.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.kuycoding.pembelajaranfisika.ui.DetailActivity;
import com.kuycoding.pembelajaranfisika.R;
import com.kuycoding.pembelajaranfisika.model.Fisika;

import java.util.ArrayList;

public class FisikaAdapter extends RecyclerView.Adapter<FisikaAdapter.CardViewViewHolder> {
    private ArrayList<Fisika> listFisika;
    private ArrayList<Fisika> getListFisika(){
        return listFisika;
    }
    public FisikaAdapter(ArrayList<Fisika> list){
        this.listFisika = list;
    }

    @NonNull
    @Override
    public FisikaAdapter.CardViewViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_card_teori, viewGroup, false);
        return new CardViewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FisikaAdapter.CardViewViewHolder holder, int position) {
        Fisika fisika = listFisika.get(position);

        Glide.with(holder.itemView.getContext())
                .load(fisika.getPoster())
                .apply(new RequestOptions().override(350,350))
                .into(holder.imgPhoto);

        holder.tvTitle.setText(fisika.getJudul());
        holder.tvMateri.setText(fisika.getMateri1());

    }

    @Override
    public int getItemCount() {
        return listFisika.size();
    }

    class CardViewViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imgPhoto;
        TextView tvTitle, tvMateri;

        CardViewViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_sampul);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvMateri = itemView.findViewById(R.id.tv_materi);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            Fisika fisika = getListFisika().get(position);

            fisika.setJudul(fisika.getJudul());
            Intent intent = new Intent(itemView.getContext(), DetailActivity.class);
            intent.putExtra(DetailActivity.EXTRA_FISIKA, fisika);
            v.getContext().startActivity(intent);
        }
    }
}
