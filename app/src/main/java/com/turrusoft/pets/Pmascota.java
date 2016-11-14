package com.turrusoft.pets;

/**
 * Created by CFE on 13/11/2016.
 */

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by CFE on 13/11/2016.
 */

public class Pmascota extends ArrayList<Mascotas> implements Parcelable{

    public Pmascota(){};

    protected Pmascota(Parcel in) {
        readfromParcel(in);
    }

    private void readfromParcel(Parcel in){
        this.clear();
        int size=in.readInt();
        for (int i=0;i<size;i++){
            Mascotas pmascota=new Mascotas(R.drawable.perro1,"Dogo",0);
            pmascota.setFoto(in.readInt());
            pmascota.setNombre(in.readString());
            pmascota.setCntLikes(in.readInt());
            this.add(pmascota);
        }
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        int size=this.size();
        dest.writeInt(size);
        for (int i=0;i<size;i++){
            Mascotas pmascota = this.get(i);
            dest.writeInt(pmascota.getFoto());
            dest.writeString(pmascota.getNombre());
            dest.writeInt(pmascota.getCntLikes());
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Pmascota> CREATOR = new Creator<Pmascota>() {
        @Override
        public Pmascota createFromParcel(Parcel in) {
            return new Pmascota(in);
        }

        @Override
        public Pmascota[] newArray(int size) {
            return new Pmascota[size];
        }
    };
}
