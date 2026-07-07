package com.france24clone.mobile.models;

public class Video implements java.io.Serializable {
    private int id;
    private String titre;
    private String youtubeId;

    public Video(int id, String titre, String youtubeId) {
        this.id = id;
        this.titre = titre;
        this.youtubeId = youtubeId;
    }

    public int getId() { return id; }
    public String getTitre() { return titre; }
    public String getYoutubeId() { return youtubeId; }
}
