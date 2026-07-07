package com.france24clone.mobile.models;

public class Article implements java.io.Serializable {
    private int id;
    private String titre;
    private String resume;
    private String contenu;
    private String date;
    private int idCategorie;
    private String nomCategorie;

    public Article(int id, String titre, String resume, String contenu, String date, int idCategorie, String nomCategorie) {
        this.id = id;
        this.titre = titre;
        this.resume = resume;
        this.contenu = contenu;
        this.date = date;
        this.idCategorie = idCategorie;
        this.nomCategorie = nomCategorie;
    }

    public int getId() { return id; }
    public String getTitre() { return titre; }
    public String getResume() { return resume; }
    public String getContenu() { return contenu; }
    public String getDate() { return date; }
    public int getIdCategorie() { return idCategorie; }
    public String getNomCategorie() { return nomCategorie; }
}
