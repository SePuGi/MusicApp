package org.milaifontanals.mymusicapp.adapter;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import org.milaifontanals.mymusicapp.CancionInfo;
import org.milaifontanals.mymusicapp.R;

import java.util.List;

public class MusicAdapter extends RecyclerView.Adapter<MusicAdapter.ViewHolder> {

    Context c;
    List<CancionInfo> music;
    Toolbar tb;

    public MusicAdapter(Context c, List<CancionInfo> music, Toolbar tb) {
        this.c = c;
        this.music = music;
        this.tb = tb;
    }

    @NonNull
    @Override
    public MusicAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View list = LayoutInflater.from(parent.getContext()).inflate(R.layout.music_list, parent, false);
        return new MusicAdapter.ViewHolder(list);
    }

    @Override
    public void onBindViewHolder(@NonNull MusicAdapter.ViewHolder holder, int position) {
        CancionInfo m = music.get(position);

        if (m.getId() % 2 == 0) {
            holder.clMusicList.setBackgroundColor(Color.parseColor("#F0F0F0FF"));
        } else {
            holder.clMusicList.setBackgroundColor(Color.parseColor("#FFFFFFFF"));
        }

        holder.txvId.setText((m.getId() + 1) + "");

        holder.txvNom.setText(m.getNom() + "");
        holder.txvNom.setOnClickListener(view -> {


        });

        String temps = "0" + m.getMin() + ":";
        if (m.getSeg() < 10 && m.getSeg() != 0) {
            temps += "0" + m.getSeg();
        } else if (m.getSeg() == 0) {
            temps += "00";
        } else {
            temps += m.getSeg();
        }
        holder.txvTemps.setText(temps);


        if (m.isFavoritos()) {
            //corazon rojo
            holder.imvFavoritos.setBackground(c.getDrawable(R.drawable.cora_r));
        } else {
            //corazon negro
            holder.imvFavoritos.setBackground(c.getDrawable(R.drawable.cora_n));
        }

        holder.imvFavoritos.setOnClickListener(view -> {
            if (m.isFavoritos()) {
                m.setFavoritos(false);
                holder.imvFavoritos.setBackground(c.getDrawable(R.drawable.cora_n));
            } else {
                m.setFavoritos(true);
                holder.imvFavoritos.setBackground(c.getDrawable(R.drawable.cora_r));
            }
        });

        holder.txvNom.setOnLongClickListener(view -> {
            tb.setVisibility(View.VISIBLE);
            //Log.d("ALBUM_NOM_GRUP", "MusicAdapter (OnLongClick): Nom:" + m.getNom());
            try {
                TextView txvTmp = tb.findViewById(R.id.txvNomSelected);
                txvTmp.setText(m.getNom());
            }catch (Exception e){
                Log.d("ALBUM_NOM_GRUP", "MusicAdapter (OnLongClick): Error:" + e.getMessage());
            }
            return true;
        });

        holder.txvNom.setOnClickListener(view -> {
            tb.setVisibility(View.INVISIBLE);
        });
    }

    @Override
    public int getItemCount() {
        return music.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView txvId;
        TextView txvNom;
        TextView txvTemps;
        ImageView imvFavoritos;
        ConstraintLayout clMusicList;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txvId = itemView.findViewById(R.id.txvId);
            txvNom = itemView.findViewById(R.id.txvNom);
            txvTemps = itemView.findViewById(R.id.txvTemps);
            clMusicList = itemView.findViewById(R.id.clMusicList);
            imvFavoritos = itemView.findViewById(R.id.imvFavoritos);


        }
    }
}
