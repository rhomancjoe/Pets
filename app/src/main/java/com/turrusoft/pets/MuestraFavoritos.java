package com.turrusoft.pets;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.Adapter;

import java.util.ArrayList;

public class MuestraFavoritos extends AppCompatActivity {

    Pmascota misfavoritas;
    private RecyclerView listaFavoritas;
    Adapter adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_muestra_favoritos);
        Toolbar miActionBar=(Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Bundle contenedor=getIntent().getExtras();
        misfavoritas=contenedor.getParcelable("lista5");
        listaFavoritas = (RecyclerView) findViewById(R.id.rvMascotas);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaFavoritas.setLayoutManager(llm);
        inicializaAdaptador();
    }

    public void inicializaAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(misfavoritas, this);
        listaFavoritas.setAdapter(adaptador);
    }
}

