package com.turrusoft.pets;

/**
 * Created by CFE on 13/11/2016.
 */
import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder>{

    ArrayList<Mascotas> mascotas;
    /*ArrayList<Mascotas> favoritas = new ArrayList<Mascotas>();*/
    Activity activity;


    public MascotaAdaptador(ArrayList<Mascotas> mascotas,Activity activity){
        this.mascotas=mascotas;
        this.activity=activity;
    }

    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v=LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota,parent,false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final MascotaViewHolder mascotaViewHolder, int position) {
        final Mascotas mascota = mascotas.get(position);
        mascotaViewHolder.imgFoto.setImageResource(mascota.getFoto());
        mascotaViewHolder.nombre.setText(mascota.getNombre());
        mascotaViewHolder.cntLikes.setText(String.valueOf(mascota.getCntLikes()));
        mascotaViewHolder.btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i;
                i=mascota.getCntLikes();
                i=i+1;
                mascota.setCntLikes(i);
                mascotaViewHolder.cntLikes.setText(String.valueOf(mascota.getCntLikes()));
                int k=MainActivity.favoritas.size();
                if (k==5){
                    MainActivity.favoritas.remove(0);
                    MainActivity.favoritas.add(mascota);
                } else {
                    MainActivity.favoritas.add(mascota);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgFoto;
        private TextView nombre;
        private TextView cntLikes;
        private ImageButton btnLike;

        public MascotaViewHolder(View itemView) {
            super(itemView);
            imgFoto         = (ImageView) itemView.findViewById(R.id.imgFoto);
            nombre          = (TextView) itemView.findViewById(R.id.tvNombre);
            cntLikes        = (TextView) itemView.findViewById(R.id.tvLikes);
            btnLike        = (ImageButton) itemView.findViewById(R.id.btnLike);

        }
    }
}
