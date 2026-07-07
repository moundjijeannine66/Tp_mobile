package com.france24clone.mobile.adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.france24clone.mobile.ArticleDetailActivity;
import com.france24clone.mobile.R;
import com.france24clone.mobile.models.Article;

import java.util.List;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder> {

    private final List<Article> articles;

    public ArticleAdapter(List<Article> articles) {
        this.articles = articles;
    }

    @NonNull
    @Override
    public ArticleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vue = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_article, parent, false);
        return new ArticleViewHolder(vue);
    }

    @Override
    public void onBindViewHolder(@NonNull ArticleViewHolder holder, int position) {
        Article article = articles.get(position);
        holder.badge.setText(article.getNomCategorie());
        holder.titre.setText(article.getTitre());
        holder.resume.setText(article.getResume());
        holder.date.setText(article.getDate());

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(), ArticleDetailActivity.class);
            intent.putExtra("article_id", article.getId());
            v.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    static class ArticleViewHolder extends RecyclerView.ViewHolder {
        TextView badge, titre, resume, date;

        ArticleViewHolder(View itemView) {
            super(itemView);
            badge = itemView.findViewById(R.id.badge_categorie);
            titre = itemView.findViewById(R.id.titre_article);
            resume = itemView.findViewById(R.id.resume_article);
            date = itemView.findViewById(R.id.date_article);
        }
    }
}
