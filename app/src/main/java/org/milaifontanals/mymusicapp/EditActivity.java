package org.milaifontanals.mymusicapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import org.w3c.dom.Text;

public class EditActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_album);

        setSupportActionBar(findViewById(R.id.toolbar_edit_album));
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent i = getIntent();
        int idAlbum = i.getIntExtra("idAlbum", -1);
        AlbumCard ab = AlbumCard.getAlbums(idAlbum);

        ImageView ivAlbum = findViewById(R.id.imgAlbumEditar);
        EditText txvNomAlbum = findViewById(R.id.txtNomAlbumEditar);


        //Cargar Imatge Album
        ImageLoader il = ImageLoader.getInstance();
        if(!ab.getImageURL().equals("")){
            il.displayImage(ab.getImageURL(), ivAlbum);
        }

        txvNomAlbum.setText(ab.getNom_Album());

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
