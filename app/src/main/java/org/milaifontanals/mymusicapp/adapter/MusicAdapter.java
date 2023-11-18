package org.milaifontanals.mymusicapp.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.nostra13.universalimageloader.core.ImageLoader;

import org.milaifontanals.mymusicapp.CancionInfo;
import org.milaifontanals.mymusicapp.R;

import java.util.List;

public class MusicAdapter  extends RecyclerView.Adapter<MusicAdapter.ViewHolder>{

    String cRojo = "https://image.spreadshirtmedia.net/image-server/v1/compositions/T31A1PA29PT10X5Y0D140169601W4851H4295CxD41C3B/views/1,width=550,height=550,appearanceId=1,backgroundColor=FFFFFF,noPt=true/contorno-corazon-taza.jpg";
    String cNegro = "❤️";
    Context c;
    List<CancionInfo> music;

    public MusicAdapter(Context c, List<CancionInfo> music) {
        this.c = c;
        this.music = music;
    }

    @NonNull
    @Override
    public MusicAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View list = LayoutInflater.from(parent.getContext()).inflate(R.layout.music_list,parent,false);
        return new MusicAdapter.ViewHolder(list);
    }

    @Override
    public void onBindViewHolder(@NonNull MusicAdapter.ViewHolder holder, int position) {
        CancionInfo m = music.get(position);

        if(m.getId()%2 == 0){
            holder.clMusicList.setBackgroundColor(Color.parseColor("#F0F0F0FF"));
        }else{
            holder.clMusicList.setBackgroundColor(Color.parseColor("#FFFFFFFF"));
        }

        holder.txvId.setText((m.getId() + 1) + "");
        holder.txvNom.setText(m.getNom() + "");

        String temps = "0" + m.getMin() + ":";
        if(m.getSeg() < 10 && m.getSeg() != 0){
            temps += "0" + m.getSeg();
        }else if(m.getSeg() == 0){
            temps += "00";
        }else{
            temps += m.getSeg();
        }
        holder.txvTemps.setText(temps);

        if(m.isFavoritos()){
            //corazon rojo
            holder.imvFavoritos.setBackground(c.getDrawable(R.drawable.cora_r));
        }else{
            //corazon negro
            holder.imvFavoritos.setBackground(c.getDrawable(R.drawable.cora_n));
        }


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
