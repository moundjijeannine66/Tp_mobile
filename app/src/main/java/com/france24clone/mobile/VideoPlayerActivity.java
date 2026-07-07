package com.france24clone.mobile;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class VideoPlayerActivity extends AppCompatActivity {

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player);

        String titre = getIntent().getStringExtra("video_titre");
        String youtubeId = getIntent().getStringExtra("youtube_id");

        TextView titreView = findViewById(R.id.titre_video_player);
        titreView.setText(titre);

        WebView webView = findViewById(R.id.webview_video);
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);

        String urlEmbed = "https://www.youtube.com/embed/" + youtubeId;
        webView.loadUrl(urlEmbed);
    }
}
