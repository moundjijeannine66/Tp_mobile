package com.france24clone.mobile;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.france24clone.mobile.data.DataProvider;
import com.france24clone.mobile.models.Article;

public class ArticleDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article_detail);

        int articleId = getIntent().getIntExtra("article_id", -1);
        Article article = DataProvider.getArticleById(articleId);

        TextView badge = findViewById(R.id.badge_categorie_detail);
        TextView titre = findViewById(R.id.titre_detail);
        TextView date = findViewById(R.id.date_detail);
        TextView contenu = findViewById(R.id.contenu_detail);

        if (article != null) {
            badge.setText(article.getNomCategorie());
            titre.setText(article.getTitre());
            date.setText("Publié le " + article.getDate());
            contenu.setText(article.getContenu());
        } else {
            titre.setText("Article introuvable");
        }
    }
}
