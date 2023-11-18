package org.milaifontanals.mymusicapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

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

        setupUniversalImageLoader();

        RecyclerView rcyAlbum = findViewById(R.id.rcyFitxes);

        rcyAlbum.setLayoutManager(new GridLayoutManager(this, 2));

        rcyAlbum.setHasFixedSize(true);

        adapter = new AlbumAdapter(this,AlbumCard.getAlbums());
        rcyAlbum.setAdapter(adapter);
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