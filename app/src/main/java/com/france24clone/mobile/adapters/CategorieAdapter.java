package com.france24clone.mobile.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.france24clone.mobile.R;
import com.france24clone.mobile.models.Categorie;

import java.util.List;

public class CategorieAdapter extends RecyclerView.Adapter<CategorieAdapter.CategorieViewHolder> {

    public interface OnCategorieClickListener {
        void onCategorieClick(Categorie categorie);
    }

    private final List<Categorie> categories;
    private final OnCategorieClickListener listener;

    public CategorieAdapter(List<Categorie> categories, OnCategorieClickListener listener) {
        this.categories = categories;
        this.listener = listener;
    }

    @NonNull
    @Override
    public CategorieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vue = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_categorie, parent, false);
        return new CategorieViewHolder(vue);
    }

    @Override
    public void onBindViewHolder(@NonNull CategorieViewHolder holder, int position) {
        Categorie categorie = categories.get(position);
        holder.nom.setText(categorie.getNom());
        holder.itemView.setOnClickListener(v -> listener.onCategorieClick(categorie));
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    static class CategorieViewHolder extends RecyclerView.ViewHolder {
        TextView nom;

        CategorieViewHolder(View itemView) {
            super(itemView);
            nom = itemView.findViewById(R.id.nom_categorie);
        }
    }
}
