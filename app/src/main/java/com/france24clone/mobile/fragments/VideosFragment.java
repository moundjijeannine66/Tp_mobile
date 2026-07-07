package com.france24clone.mobile.fragments;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.france24clone.mobile.R;
import com.france24clone.mobile.adapters.VideoAdapter;
import com.france24clone.mobile.data.DataProvider;

public class VideosFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View vue = inflater.inflate(R.layout.fragment_videos, container, false);

        RecyclerView recycler = vue.findViewById(R.id.recycler_videos);
        recycler.setLayoutManager(new LinearLayoutManager(getContext()));
        recycler.setAdapter(new VideoAdapter(DataProvider.getVideos()));

        return vue;
    }
}
