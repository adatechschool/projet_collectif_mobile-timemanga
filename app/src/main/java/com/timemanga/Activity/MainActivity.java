package com.timemanga.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.timemanga.Adapter.CategoryAdapter;
import com.timemanga.Adapter.LastMangaAdapter;
import com.timemanga.Domain.CategoryDomain;
import com.timemanga.Domain.LastMangaDomain;
import com.timemanga.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapter,adapter2;
    private RecyclerView recyclerViewCategory, recyclerViewlastList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_LTR);

        recyclerViewCategory();
        recyclerViewlastList();
    }

    private void recyclerViewlastList() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewlastList = findViewById(R.id.view2);
        recyclerViewlastList.setLayoutManager(linearLayoutManager);

        ArrayList<LastMangaDomain> lastMangaDomains=new ArrayList<>();
        lastMangaDomains.add(new LastMangaDomain("Cheese Burger", "fast_1", 9.0, 20));
        lastMangaDomains.add(new LastMangaDomain("Pepperoni Pizza", "fast_2", 8.1, 16));
        lastMangaDomains.add(new LastMangaDomain("Vegetable Pizza", "fast_3", 9.5, 16));

        adapter2 = new LastMangaAdapter(lastMangaDomains);
        recyclerViewlastList.setAdapter(adapter2);
    }

    private void recyclerViewCategory() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewCategory=findViewById(R.id.view1);
        recyclerViewCategory.setLayoutManager(linearLayoutManager);

        ArrayList<CategoryDomain> categoryList=new ArrayList<>();
        categoryList.add(new CategoryDomain("Shonen","cat_1"));
        categoryList.add(new CategoryDomain("Seinen","cat_2"));
        categoryList.add(new CategoryDomain("Shojo","cat_3"));
        categoryList.add(new CategoryDomain("Josei","cat_4"));

        adapter=new CategoryAdapter(categoryList);
        recyclerViewCategory.setAdapter(adapter);
    }
}

