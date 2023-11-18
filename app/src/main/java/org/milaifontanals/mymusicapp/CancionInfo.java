package org.milaifontanals.mymusicapp;

public class CancionInfo {

    int id;
    boolean favoritos;
    String nom;
    int min;
    int seg;

    public CancionInfo(int id, boolean favoritos, String nom, int min, int seg) {
        this.id = id;
        this.favoritos = favoritos;
        this.nom = nom;
        this.min = min;
        this.seg = seg;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isFavoritos() {
        return favoritos;
    }

    public void setFavoritos(boolean favoritos) {
        this.favoritos = favoritos;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getSeg() {
        return seg;
    }

    public void setSeg(int seg) {
        this.seg = seg;
    }
}
