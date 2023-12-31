package org.milaifontanals.mymusicapp;

import android.app.Notification;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import org.milaifontanals.mymusicapp.adapter.AlbumAdapter;
import org.milaifontanals.mymusicapp.adapter.MusicAdapter;

import java.util.List;

public class MusicList extends AppCompatActivity {

    MusicAdapter adapter;
    List<AlbumCard> albums;
    List<CancionInfo> music;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.album_music_list);

        Toolbar tb = findViewById(R.id.bot_toolbar_music_list);

        FloatingActionButton fabAlbum = findViewById(R.id.floatingBtnAlbum);
        fabAlbum.setOnClickListener(view -> {
            Log.d("ALBUM_NOM_GRUP", "(MusicList) FloatingActionButton");
        });

        Intent i = getIntent();
        TextView textNoMusica = findViewById(R.id.textNoMusica);
        
        int idAlbum = i.getIntExtra("idAlbum", -1);

        Log.d("ALBUM_NOM_GRUP","(MusicList) ID rebut --> "+ idAlbum);

        //botó enrere en la finestra nova
        setSupportActionBar(findViewById(R.id.my_toolbar));
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Toolbar Inferior


        try {
            ImageButton editButton = findViewById(R.id.bttEditar_album);
            editButton.setOnClickListener(view -> {
                Log.d("ALBUM_NOM_GRUP", "(MusicList) editButton");
            });

            ImageButton deleteButton = findViewById(R.id.bttEliminar_album);
            deleteButton.setOnClickListener(view -> {
                Log.d("ALBUM_NOM_GRUP", "(MusicList) deleteButton");
            });
        }catch (Exception e) {
            Log.d("ALBUM_NOM_GRUP", "(MusicList) ERROR CLICKLISTENER: " + e.getMessage());
        }

        if(idAlbum != -1){
            music = AlbumCard.getAlbums(idAlbum).getMusica();
            if(music == null){
                textNoMusica.setText("No s'han trobat dades");
            }else {
                try {
                    setupUniversalImageLoader();
                    RecyclerView rcyAlbum = findViewById(R.id.rcyMusic);
                    rcyAlbum.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
                    rcyAlbum.setHasFixedSize(true);
                    adapter = new MusicAdapter(this, music, tb);
                    rcyAlbum.setAdapter(adapter);

                    Log.d("ALBUM_NOM_GRUP", "MusicList (RecyclerView): \nMusic:" + music.toString());

                } catch (Exception e) {
                    Log.d("ALBUM_NOM_GRUP", "MusicList (RecyclerView): \nMusic:" + music.toString() + "\nERROR: " + e.getMessage());
                }
            }
        }else{
            textNoMusica.setText("No s'han trobat dades");
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
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
