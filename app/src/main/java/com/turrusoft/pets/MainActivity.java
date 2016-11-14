package com.turrusoft.pets;


import android.content.Intent;
import android.os.Parcelable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    public ArrayList<Mascotas> mascotas;
    public static Pmascota favoritas = new Pmascota();
    private RecyclerView listaMascotas, listaFavoritas;
    Adapter adaptador;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar miActionBar=(Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
        listaMascotas = (RecyclerView) findViewById(R.id.rvMascotas);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);
        inicializarListaMascotas();
        inicializaAdaptador();
    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.btnFavoritos:
                Intent i=new Intent(MainActivity.this, MuestraFavoritos.class);
                Bundle contenedor=new Bundle();
                contenedor.putParcelable("lista5",favoritas);
                i.putExtras(contenedor);
                startActivity(i);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void inicializarListaMascotas(){
        mascotas=new ArrayList<Mascotas>();
        mascotas.add(new Mascotas(R.drawable.perro1,"Firulais",0));
        mascotas.add(new Mascotas(R.drawable.perro2,"Dogo",0));
        mascotas.add(new Mascotas(R.drawable.perro3,"Cirilo",0));
        mascotas.add(new Mascotas(R.drawable.perro4,"Spooky",0));
        mascotas.add(new Mascotas(R.drawable.perro5,"Roco",0));
        mascotas.add(new Mascotas(R.drawable.perro6,"Campeón",0));
        mascotas.add(new Mascotas(R.drawable.perro7,"Einstein",0));
        mascotas.add(new Mascotas(R.drawable.perro8,"Rufo",0));
    }


    public void inicializaAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, this);
        listaMascotas.setAdapter(adaptador);
    }
}

