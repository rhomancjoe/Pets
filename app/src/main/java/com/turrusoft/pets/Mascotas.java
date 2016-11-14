package com.turrusoft.pets;

/**
 * Created by CFE on 13/11/2016.
 */

public class Mascotas {
    private int foto;
    private String nombre;
    private int cntLikes;

    public Mascotas(int foto, String nombre, int cntLikes){
        this.foto=foto;
        this.nombre=nombre;
        this.cntLikes=cntLikes;
    }



    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCntLikes() {
        return cntLikes;
    }

    public void setCntLikes(int cntLikes) {
        this.cntLikes = cntLikes;
    }
}

