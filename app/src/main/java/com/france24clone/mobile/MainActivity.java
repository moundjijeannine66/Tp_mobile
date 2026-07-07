package com.france24clone.mobile;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.france24clone.mobile.fragments.ArticlesFragment;
import com.france24clone.mobile.fragments.CategoriesFragment;
import com.france24clone.mobile.fragments.VideosFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        remplacerFragment(new ArticlesFragment());

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnItemSelectedListener(item -> {
            Fragment fragment;
            int id = item.getItemId();

            if (id == R.id.nav_categories) {
                fragment = new CategoriesFragment();
            } else if (id == R.id.nav_videos) {
                fragment = new VideosFragment();
            } else {
                fragment = new ArticlesFragment();
            }

            remplacerFragment(fragment);
            return true;
        });
    }

    private void remplacerFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit();
    }
}
