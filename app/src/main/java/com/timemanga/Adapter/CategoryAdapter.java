package com.timemanga.Adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.timemanga.Activity.JoseiActivity;
import com.timemanga.Activity.NextActivity;
import com.timemanga.Activity.SeinenActivity;
import com.timemanga.Activity.ShojoActivity;
import com.timemanga.Activity.ShonenActivity;
import com.timemanga.Domain.CategoryDomain;
import com.timemanga.R;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {

    private ArrayList<CategoryDomain> categoryDomains;

    public CategoryAdapter(ArrayList<CategoryDomain> categoryDomains) {
        this.categoryDomains = categoryDomains;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_category, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.categoryName.setText(categoryDomains.get(position).getTitle());
        String picUrl = "";
        switch (position) {
            case 0: {
                picUrl = "cat_1";
                break;
            }
            case 1: {
                picUrl = "cat_2";
                break;
            }
            case 2: {
                picUrl = "cat_3";
                break;
            }
            case 3: {
                picUrl = "cat_4";
                break;
            }
        }
        int drawableResourceId = holder.itemView.getContext().getResources().getIdentifier(picUrl, "drawable", holder.itemView.getContext().getPackageName());
        Glide.with(holder.itemView.getContext())
                .load(drawableResourceId)
                .into(holder.categoryPic);

        // Ajoute un écouteur de clic à l'élément
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Récupère la catégorie sélectionnée
                CategoryDomain selectedCategory = categoryDomains.get(holder.getAdapterPosition());

                // Crée une intention pour démarrer l'activité correspondante
                Intent intent;
                switch (selectedCategory.getTitle()) {
                    case "Shonen":
                        intent = new Intent(view.getContext(), ShonenActivity.class);
                        break;
                    case "Seinen":
                        intent = new Intent(view.getContext(), SeinenActivity.class);
                        break;
                    case "Shojo":
                        intent = new Intent(view.getContext(), ShojoActivity.class);
                        break;
                    case "Josei":
                        intent = new Intent(view.getContext(), JoseiActivity.class);
                        break;
                    default:
                        // Par défaut, démarrer une activité générique ou afficher un message d'erreur
                        intent = new Intent(view.getContext(), NextActivity.class);
                        break;
                }

                // Démarrer l'activité correspondante
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return categoryDomains.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView categoryName;
        ImageView categoryPic;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            categoryName = itemView.findViewById(R.id.categoryName);
            categoryPic = itemView.findViewById(R.id.categoryPic);
        }
    }
}
