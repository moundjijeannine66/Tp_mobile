package com.france24clone.mobile.adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.france24clone.mobile.R;
import com.france24clone.mobile.VideoPlayerActivity;
import com.france24clone.mobile.models.Video;

import java.util.List;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.VideoViewHolder> {

    private final List<Video> videos;

    public VideoAdapter(List<Video> videos) {
        this.videos = videos;
    }

    @NonNull
    @Override
    public VideoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vue = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_video, parent, false);
        return new VideoViewHolder(vue);
    }

    @Override
    public void onBindViewHolder(@NonNull VideoViewHolder holder, int position) {
        Video video = videos.get(position);
        holder.titre.setText(video.getTitre());

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(), VideoPlayerActivity.class);
            intent.putExtra("video_titre", video.getTitre());
            intent.putExtra("youtube_id", video.getYoutubeId());
            v.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return videos.size();
    }

    static class VideoViewHolder extends RecyclerView.ViewHolder {
        TextView titre;

        VideoViewHolder(View itemView) {
            super(itemView);
            titre = itemView.findViewById(R.id.titre_video);
        }
    }
}
