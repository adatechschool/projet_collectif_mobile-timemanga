package com.timemanga.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.timemanga.Domain.LastMangaDomain;
import com.timemanga.R;

import java.util.ArrayList;

public class LastMangaAdapter extends RecyclerView.Adapter<LastMangaAdapter.Viewholder> {

    ArrayList<LastMangaDomain> lastMangaDomains;

    public LastMangaAdapter(ArrayList<LastMangaDomain> lastMangaDomains) {
        this.lastMangaDomains = lastMangaDomains;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate= LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_last_manga, parent, false);

        return new Viewholder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        holder.time.setText(lastMangaDomains.get(position).getTime()+ " min");
        holder.title.setText(lastMangaDomains.get(position).getTitle());
        holder.star.setText(String.valueOf(lastMangaDomains.get(position).getStar()));

        int drawableResourceId=holder.itemView.getContext().getResources().getIdentifier(lastMangaDomains.get(position).getPic(),"drawable",holder.itemView.getContext().getPackageName());
        Glide.with(holder.itemView.getContext())
                .load(drawableResourceId)
                .into(holder.pic);
    }

    @Override
    public int getItemCount() {
        return lastMangaDomains.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder{
        TextView title, time, star;
        ImageView pic;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.title);
            pic=itemView.findViewById(R.id.pic);
            star=itemView.findViewById(R.id.star);
            time=itemView.findViewById(R.id.time);
        }
    }
}
