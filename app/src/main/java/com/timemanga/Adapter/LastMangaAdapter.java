package com.timemanga.Adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.timemanga.R;

public class LastMangaAdapter {

    public class Viewholder extends RecyclerView.ViewHolder{
        TextView title, time, star;
        ImageView pic;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.title);
            pic=itemView.findViewById(R.id.pi);
        }
    }
}
