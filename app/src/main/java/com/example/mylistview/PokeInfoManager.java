package com.example.mylistview;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

public class PokeInfoManager {
    private ArrayList<PokeInfo> pokeInfos = new ArrayList<>();
    private Context _context;
    PokeInfoManager(Context context){
        _context = context;
    }
    public ArrayList<PokeInfo> getPokeInfos(){
        return pokeInfos;
    }
    public void loadAllPokeInfos(){
        String jsonString = Helper.JsonReader.readJsonFromRaw(_context, R.raw.pokedex);
        List<JsonObject> jsonObjectList = Helper.JsonReader.convertToJsonObject(jsonString);
        pokeInfos.clear();
        for (JsonObject jso :jsonObjectList){
            Gson gson = new Gson();
            PokeInfo pokeInfo = gson.fromJson(jso.getAsString(), PokeInfo.class);
            pokeInfo.getBase().setSpAttack(jso.get("base").getAsJsonObject().get("Sp. Attack").getAsInt());
            pokeInfo.getBase().setSpDefense(jso.get("base").getAsJsonObject().get("Sp. Defense").getAsInt());

            pokeInfos.add(pokeInfo);
        }
    }
    public void loadPokeInfos(int number){
        String jsonString = Helper.JsonReader.readJsonFromRaw(_context, R.raw.pokedex);
        List<JsonObject> jsonObjectList = Helper.JsonReader.convertToJsonObject(jsonString);
        pokeInfos.clear();
        int count = 0;
        for (JsonObject jso :jsonObjectList){
            if(count == number){
                break;
            }
            ++count;
            Gson gson = new Gson();
            PokeInfo pokeInfo = gson.fromJson(jso, PokeInfo.class);
            pokeInfo.getBase().setSpAttack(jso.get("base").getAsJsonObject().get("Sp. Attack").getAsInt());
            pokeInfo.getBase().setSpDefense(jso.get("base").getAsJsonObject().get("Sp. Defense").getAsInt());

            pokeInfos.add(pokeInfo);
        }
    }
}
