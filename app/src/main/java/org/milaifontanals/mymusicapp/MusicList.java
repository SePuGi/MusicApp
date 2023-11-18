package org.milaifontanals.mymusicapp;

import android.app.Notification;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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

        Intent i = getIntent();
        TextView textNoMusica = findViewById(R.id.textNoMusica);
        //String nomAlbum = i.getStringExtra("valor");
        int idAlbum = i.getIntExtra("idAlbum", -1);
        albums = AlbumCard.getAlbums();

        Log.d("ALBUM_NOM_GRUP","(MusicList) ID rebut --> "+ idAlbum);


        //botó enrere en la finestra nova
        setSupportActionBar(findViewById(R.id.my_toolbar));
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        if(idAlbum != -1){
            for (int idx=0;idx < albums.size();idx++ ){
                if(idAlbum == albums.get(idx).getId()){
                    music = albums.get(idx).getMusica();
                    break;
                }
            }
            if(music == null){
                textNoMusica.setText("No s'han trobat dades");
            }else {
                try {
                    setupUniversalImageLoader();
                    RecyclerView rcyAlbum = findViewById(R.id.rcyMusic);
                    rcyAlbum.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
                    rcyAlbum.setHasFixedSize(true);
                    adapter = new MusicAdapter(this, music);
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
            // Realiza la acción deseada cuando se presiona el botón de retroceso
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
