package com.france24clone.mobile.data;

import com.france24clone.mobile.models.Article;
import com.france24clone.mobile.models.Categorie;
import com.france24clone.mobile.models.Video;

import java.util.ArrayList;
import java.util.List;

public class DataProvider {

    public static List<Categorie> getCategories() {
        List<Categorie> liste = new ArrayList<>();
        liste.add(new Categorie(1, "Afrique"));
        liste.add(new Categorie(2, "International"));
        liste.add(new Categorie(3, "Économie"));
        liste.add(new Categorie(4, "Sport"));
        liste.add(new Categorie(5, "Culture"));
        return liste;
    }

    public static List<Article> getArticles() {
        List<Article> liste = new ArrayList<>();
        liste.add(new Article(1,
                "Le Tchad renforce ses infrastructures numériques",
                "Un nouveau plan national vise à améliorer la connectivité dans tout le pays.",
                "Le gouvernement tchadien a annoncé un vaste programme d'investissement dans les infrastructures numériques afin de réduire la fracture numérique entre les zones urbaines et rurales. Ce plan prévoit notamment l'extension de la fibre optique et l'amélioration de la couverture 4G dans les prochaines années.",
                "06 juillet 2026", 1, "Afrique"));

        liste.add(new Article(2,
                "Sommet économique régional à N'Djamena",
                "Les chefs d'État de la sous-région se réunissent pour discuter d'intégration économique.",
                "N'Djamena a accueilli un sommet réunissant plusieurs chefs d'État de la région dans le but de renforcer la coopération économique et de faciliter les échanges commerciaux transfrontaliers.",
                "05 juillet 2026", 3, "Économie"));

        liste.add(new Article(3,
                "Coupe d'Afrique des Nations : les favoris de l'édition",
                "Retour sur les équipes les plus attendues de la compétition.",
                "À quelques semaines du coup d'envoi de la Coupe d'Afrique des Nations, plusieurs sélections se dégagent comme favorites grâce à leurs performances récentes et à la qualité de leur effectif.",
                "04 juillet 2026", 4, "Sport"));

        liste.add(new Article(4,
                "Un nouveau festival culturel voit le jour à N'Djamena",
                "La ville accueillera bientôt un événement dédié aux arts et à la musique locale.",
                "Ce nouveau festival ambitionne de mettre en avant les artistes tchadiens émergents et de dynamiser la scène culturelle locale, avec des concerts, expositions et ateliers ouverts au public.",
                "03 juillet 2026", 5, "Culture"));

        return liste;
    }

    public static List<Article> getArticlesParCategorie(int idCategorie) {
        List<Article> resultat = new ArrayList<>();
        for (Article a : getArticles()) {
            if (a.getIdCategorie() == idCategorie) {
                resultat.add(a);
            }
        }
        return resultat;
    }

    public static Article getArticleById(int id) {
        for (Article a : getArticles()) {
            if (a.getId() == id) return a;
        }
        return null;
    }

    public static List<Video> getVideos() {
        List<Video> liste = new ArrayList<>();
        liste.add(new Video(1, "Reportage : la vie quotidienne à N'Djamena", "aqz-KE-bpKQ"));
        liste.add(new Video(2, "Interview : les enjeux économiques régionaux", "aqz-KE-bpKQ"));
        liste.add(new Video(3, "Culture : festival des arts locaux", "aqz-KE-bpKQ"));
        return liste;
    }
}
