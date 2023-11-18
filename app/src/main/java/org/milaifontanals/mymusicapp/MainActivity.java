package org.milaifontanals.mymusicapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import org.milaifontanals.mymusicapp.adapter.AlbumAdapter;

public class MainActivity extends AppCompatActivity {
    AlbumAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rcyAlbum = findViewById(R.id.rcyFitxes);

        rcyAlbum.setLayoutManager(new GridLayoutManager(this, 2));

        rcyAlbum.setHasFixedSize(true);

        adapter = new AlbumAdapter(AlbumCard.getAlbums());
        rcyAlbum.setAdapter(adapter);
    }
}