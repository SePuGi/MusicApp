package org.milaifontanals.mymusicapp.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.milaifontanals.mymusicapp.AlbumCard;
import org.milaifontanals.mymusicapp.R;

import java.util.List;

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.ViewHolder>{

    List<AlbumCard> lAlbums;

    public AlbumAdapter(List<AlbumCard> albums) {

        this.lAlbums = albums;

    }

    @NonNull
    @Override
    public AlbumAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View ficha = LayoutInflater.from(parent.getContext()).inflate(R.layout.ficha,parent,false);
        Log.d("ALBUM_NOM_GRUP", "onCreateViewHolder (AlbumAdapter) ");
        return new ViewHolder(ficha);
    }

    @Override
    public void onBindViewHolder(@NonNull AlbumAdapter.ViewHolder holder, int position) {
        AlbumCard album = lAlbums.get(position);
        holder.txvNomGrup.setText(album.getNom_Grup() + "");
        holder.txvAlbum.setText(album.getNom_Album() + "");
        Log.d("ALBUM_NOM_GRUP", "Albums(AlbumAdapter) " + position + "\n" + album.getNom_Grup() + "");
    }

    @Override
    public int getItemCount() {

        return lAlbums.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txvNomGrup;
        TextView txvAlbum;
        ImageView imvFicha;
        Button bttFicha;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txvNomGrup = itemView.findViewById(R.id.txvNomGrup);
            txvAlbum = itemView.findViewById(R.id.txvAlbum);
            bttFicha = itemView.findViewById(R.id.bttFicha);
            imvFicha = itemView.findViewById(R.id.imvFicha);
        }
    }
}
