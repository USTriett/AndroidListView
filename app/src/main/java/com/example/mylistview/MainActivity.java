package com.example.mylistview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ListView;

import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ExpandableListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("POKEDEX");
        toolbar.setTitleTextColor(Color.WHITE);
        toolbar.setBackgroundColor(Color.RED);
        setSupportActionBar(toolbar);
        ArrayList<PokeInfo> pokes;
        PokeInfoManager pokeInfoManager = new PokeInfoManager(this);
        pokeInfoManager.loadPokeInfos(30);
        pokes = pokeInfoManager.getPokeInfos();
        PokemonAdapter pokemonAdapter = new PokemonAdapter(this, pokes);
        listView = (ExpandableListView) findViewById(R.id.myListView);
        listView.setAdapter(pokemonAdapter);


    }
}