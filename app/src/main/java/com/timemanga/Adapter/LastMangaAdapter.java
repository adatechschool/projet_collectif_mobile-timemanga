package com.timemanga.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

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

        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {

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
