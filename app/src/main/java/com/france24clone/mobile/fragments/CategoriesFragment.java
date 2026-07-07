package com.france24clone.mobile.fragments;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.france24clone.mobile.R;
import com.france24clone.mobile.adapters.ArticleAdapter;
import com.france24clone.mobile.adapters.CategorieAdapter;
import com.france24clone.mobile.data.DataProvider;

public class CategoriesFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View vue = inflater.inflate(R.layout.fragment_categories, container, false);

        RecyclerView recycler = vue.findViewById(R.id.recycler_categories);
        recycler.setLayoutManager(new LinearLayoutManager(getContext()));
        recycler.setAdapter(new CategorieAdapter(DataProvider.getCategories(), categorie -> {
            Toast.makeText(getContext(), categorie.getNom(), Toast.LENGTH_SHORT).show();
            recycler.setAdapter(new ArticleAdapter(DataProvider.getArticlesParCategorie(categorie.getId())));
        }));

        return vue;
    }
}
