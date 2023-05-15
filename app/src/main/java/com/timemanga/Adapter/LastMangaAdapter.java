package com.timemanga.Adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class LastMangaAdapter {

    public class Viewholder extends RecyclerView.ViewHolder{
        TextView title;
        ImageView pic;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
