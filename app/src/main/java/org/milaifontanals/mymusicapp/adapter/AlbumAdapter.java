package org.milaifontanals.mymusicapp.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.nostra13.universalimageloader.core.ImageLoader;

import org.milaifontanals.mymusicapp.AlbumCard;
import org.milaifontanals.mymusicapp.EditActivity;
import org.milaifontanals.mymusicapp.MusicList;
import org.milaifontanals.mymusicapp.R;

import java.util.List;

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.ViewHolder> {

    List<AlbumCard> lAlbums;
    Context c;
    Toolbar tb;

    int fichaSeleccionada = -1;

    public AlbumAdapter(Context c, List<AlbumCard> albums, Toolbar tb) {
        this.c = c;
        this.lAlbums = albums;
        this.tb = tb;
    }

    @NonNull
    @Override
    public AlbumAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View ficha = LayoutInflater.from(parent.getContext()).inflate(R.layout.ficha, parent, false);
        return new ViewHolder(ficha);
    }
    static boolean seleccionat = false;

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull AlbumAdapter.ViewHolder holder, int position) {
        AlbumCard album = lAlbums.get(position);
        holder.txvNomGrup.setText(album.getNom_Grup() + "");
        holder.txvAlbum.setText(album.getNom_Album() + "");


        holder.bttFicha.setOnLongClickListener(view -> {

            //Log.d("ALBUM_NOM_GRUP", "(setOnLongClickListener) ");
            if(!seleccionat){
                Log.d("ALBUM_NOM_GRUP", "(setOnLongClickListener)Seleccionat:  " + seleccionat);
                holder.bttFicha.setBackgroundColor(R.color.selected);
                tb.setVisibility(View.VISIBLE);
                this.fichaSeleccionada = holder.getAdapterPosition();
                seleccionat = true;
            }
            try {
                ImageButton imbEdit = tb.findViewById(R.id.bttEditar);
                imbEdit.setOnClickListener(view1 -> {
                    Intent i = new Intent(c, EditActivity.class);
                    i.putExtra("idAlbum", album.getId());
                    c.startActivity(i);
                    tb.setVisibility(View.INVISIBLE);
                });

            } catch (Exception e) {
                Log.d("ALBUM_NOM_GRUP", "(ImageButton) ERROR: " + e.getMessage());
            }
            return true;
        });

        holder.bttFicha.setOnClickListener(view -> {

            if(seleccionat && fichaSeleccionada == holder.getAdapterPosition()){
                Log.d("ALBUM_NOM_GRUP", "(setOnClickListener)Seleccionat:  "+ seleccionat);
                holder.bttFicha.setBackgroundColor(Color.parseColor("#00000000"));
                tb.setVisibility(View.INVISIBLE);
                seleccionat = false;
            }else{
                try {
                    Intent i = new Intent(c, MusicList.class);
                    i.putExtra("idAlbum", album.getId());
                    Log.d("ALBUM_NOM_GRUP", "(AlbumAdapter) ID enviat --> " + album.getId());

                    c.startActivity(i);
                } catch (Exception e) {
                    Log.d("ALBUM_NOM_GRUP", "Creació MusicList: " + e.getMessage());
                }
            }
        });


        ImageLoader il = ImageLoader.getInstance();
        if (!album.getImageURL().equals("")) {
            il.displayImage(album.getImageURL(), holder.imvFicha);
        }
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
        ConstraintLayout constraintLayoutFicha;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txvNomGrup = itemView.findViewById(R.id.txvNomGrup);
            txvAlbum = itemView.findViewById(R.id.txvAlbum);
            bttFicha = itemView.findViewById(R.id.bttFicha);
            imvFicha = itemView.findViewById(R.id.imvFicha);
            constraintLayoutFicha= itemView.findViewById(R.id.constraintLayoutFicha);
        }
    }
}
