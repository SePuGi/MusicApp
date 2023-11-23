package org.milaifontanals.mymusicapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import org.milaifontanals.mymusicapp.adapter.AlbumAdapter;

public class MainActivity extends AppCompatActivity {
    AlbumAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton fabMain = findViewById(R.id.floatingBtnMain);
        fabMain.setOnClickListener(view -> {
            Intent i = new Intent(this, EditActivity.class);
            this.startActivity(i);
        });

        try {
            Toolbar tb = findViewById(R.id.bot_toolbar);

            setupUniversalImageLoader();
            RecyclerView rcyAlbum = findViewById(R.id.rcyFitxes);
            rcyAlbum.setLayoutManager(new GridLayoutManager(this, 2));
            rcyAlbum.setHasFixedSize(true);
            adapter = new AlbumAdapter(this, AlbumCard.getAlbums(), tb);
            rcyAlbum.setAdapter(adapter);

        } catch (Exception e) {
            Log.d("ALBUM_NOM_GRUP", "(MainActivity) Error Toolbar --> " + e.getMessage());
        }
    }

    private void setupUniversalImageLoader() {
        DisplayImageOptions dop = new DisplayImageOptions.Builder().
                showImageOnLoading(R.drawable.ic_launcher_background)
                .build();
        // Create global configuration and initialize ImageLoader with this config
        ImageLoaderConfiguration config =
                new ImageLoaderConfiguration.Builder(this)
                        //.threadPoolSize(10)
                        //.diskCacheSize(1000)
                        .defaultDisplayImageOptions(dop)
                        .build();

        ImageLoader.getInstance().init(config);
    }
}