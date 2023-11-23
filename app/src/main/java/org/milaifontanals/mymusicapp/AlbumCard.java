package org.milaifontanals.mymusicapp;

import android.graphics.Bitmap;
import android.graphics.Camera;
import android.util.Log;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AlbumCard {

    int id;
    String nom_Grup;
    String nom_Album;
    String imageURL;

    Date data;
    List<CancionInfo> musica;

    public AlbumCard() {

    }

    public AlbumCard(int id, String nom_Grup, String nom_Album, String imageURL,Date data, List<CancionInfo> musica) {
        this.id = id;
        this.nom_Grup = nom_Grup;
        this.nom_Album = nom_Album;
        this.imageURL = imageURL;
        this.data = data;
        this.musica = musica;
    }

    Bitmap bitmap;

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
        imageURL = null;
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
            //int id, boolean favoritos, String nom, int min, int seg


            albums = new ArrayList<AlbumCard>();

            //albums.add(new AlbumCard(0, "Pink Floyd", "The Dark Side of the Moon", "https://www.rockcamp.es/blog/wp-content/uploads/2017/02/Pink-Floyd-Dark-Side-of-The-Moon.jpg", canciones));
            albums.add(new AlbumCard(0,
                    "Pink Floyd",
                    "The Dark Side of the Moon",
                    "https://www.rockcamp.es/blog/wp-content/uploads/2017/02/Pink-Floyd-Dark-Side-of-The-Moon.jpg", new Date(System.currentTimeMillis()),
                    new ArrayList<CancionInfo>() {
                        {
                            add(new CancionInfo(0, false, "Speak to Me", 1, 7));
                            add(new CancionInfo(1, true, "Breathe", 2, 49));
                            add(new CancionInfo(2, false, "On the Run", 3, 45));
                            add(new CancionInfo(3, false, "Time", 6, 53));
                            add(new CancionInfo(4, true, "The Great Gig in the Sky", 4, 44));
                            add(new CancionInfo(5, true, "Money", 6, 23));
                            add(new CancionInfo(6, false, "Us and Them", 7, 49));
                            add(new CancionInfo(7, false, "Any Colour You Like", 3, 26));
                            add(new CancionInfo(8, false, "Brain Damage", 3, 46));
                            add(new CancionInfo(9, true, "Eclipse", 2, 12));
                        }}));


            albums.add(new AlbumCard(1,
                    "Joji",
                    "Nectar ",
                    "https://m.media-amazon.com/images/I/81VWPK3PIKL._UF894,1000_QL80_.jpg", new Date(System.currentTimeMillis()),
                    new ArrayList<CancionInfo>(){
                        {
                            add(new CancionInfo(0, false, "Ew", 3, 27));
                            add(new CancionInfo(1, false, "Modus", 3, 27));
                            add(new CancionInfo(2, true, "Tick Tock", 2, 12));
                            add(new CancionInfo(3, false, "Daylight (ft. Diplo)", 2, 43));
                            add(new CancionInfo(4, false, "Upgrade", 1, 29));
                            add(new CancionInfo(5, true, "Gimme Love", 3, 34));
                            add(new CancionInfo(6, true, "Run", 3, 15));
                            add(new CancionInfo(7, false, "Sanctuary", 3, 0));
                            add(new CancionInfo(8, false, "High Hopes (ft. Omar Apollo)", 3, 2));
                            add(new CancionInfo(9, false, "Nitrous", 2, 11));
                            add(new CancionInfo(10, true, "Pretty Boy (ft. Lil Yachty)", 2, 36));
                            add(new CancionInfo(11, true, "Normal People (ft. Rei Brown)", 2, 46));
                            add(new CancionInfo(12, true, "Afterthought (Con Benee)", 3, 14));
                            add(new CancionInfo(13, false, "Mr. Hollywood", 3, 22));
                            add(new CancionInfo(14, false, "777", 3, 1));
                            add(new CancionInfo(15, false, "Reanimator (ft. Yves Tumor)", 3, 3));
                            add(new CancionInfo(16, true, "Like You Do", 4, 0));
                            add(new CancionInfo(17, false, "Your Man", 2, 43));
                        }
                    }));
            albums.add(new AlbumCard(2, "nomGrup3", "nomAlbum3", "",new Date(System.currentTimeMillis()), null));
            albums.add(new AlbumCard(3, "nomGrup4", "nomAlbum4", "",new Date(System.currentTimeMillis()), null));
            albums.add(new AlbumCard(4, "nomGrup5", "nomAlbum5", "",new Date(System.currentTimeMillis()), null));
            albums.add(new AlbumCard(5, "nomGrup6", "nomAlbum6", "",new Date(System.currentTimeMillis()), null));
            albums.add(new AlbumCard(6, "nomGrup7", "nomAlbum6", "",new Date(System.currentTimeMillis()), null));
        }
        return albums;
    }

    public static AlbumCard getAlbums(int i){

        return albums.get(i);
    }
}
