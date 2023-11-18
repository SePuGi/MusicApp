package org.milaifontanals.mymusicapp;

import android.graphics.Camera;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class AlbumCard {

    int id;
    String nom_Grup;
    String nom_Album;
    String imageURL;
    List<CancionInfo> musica;

    public AlbumCard() {

    }

    public AlbumCard(int id, String nom_Grup, String nom_Album, String imageURL, List<CancionInfo> musica) {
        this.id = id;
        this.nom_Grup = nom_Grup;
        this.nom_Album = nom_Album;
        this.imageURL = imageURL;
        this.musica = musica;
    }

    private static ArrayList<AlbumCard> albums;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom_Grup() {
        return nom_Grup;
    }

    public void setNom_Grup(String nom_Grup) {
        this.nom_Grup = nom_Grup;
    }

    public List<CancionInfo> getMusica() {
        return musica;
    }

    public void setMusica(List<CancionInfo> musica) {
        this.musica = musica;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getNom_Album() {
        return nom_Album;
    }

    public void setNom_Album(String nom_Album) {
        this.nom_Album = nom_Album;
    }

    public static List<AlbumCard> getAlbums() {

        if (albums == null) {
            //omplim d'info els albums
            albums = new ArrayList<AlbumCard>();
            albums.add(new AlbumCard(0, "nomGrup1", "nomAlbum1", "URL IMATGE", null));
            albums.add(new AlbumCard(1, "nomGrup2", "nomAlbum2", "URL IMATGE", null));
            albums.add(new AlbumCard(2, "nomGrup3", "nomAlbum3", "URL IMATGE", null));
            albums.add(new AlbumCard(3, "nomGrup4", "nomAlbum4", "URL IMATGE", null));
            albums.add(new AlbumCard(4, "nomGrup5", "nomAlbum5", "URL IMATGE", null));
            albums.add(new AlbumCard(5, "nomGrup6", "nomAlbum6", "URL IMATGE", null));
        }
        return albums;
    }
}
