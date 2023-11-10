package com.example.mylistview;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import org.json.JSONArray;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class Helper {
    static class JsonReader {

        public static String readJsonFromRaw(Context context, int rawResourceId) {
            try {
                // Open the raw resource input stream
                InputStream inputStream = context.getResources().openRawResource(rawResourceId);

                // Read the data from the input stream and convert it to a string
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder jsonStringBuilder = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    jsonStringBuilder.append(line);
                }

                // Close the input stream
                inputStream.close();

                // Return the JSON string
                return jsonStringBuilder.toString();

            } catch (Exception e) {
                Log.e("JsonReader", "Error reading JSON from raw resource", e);
                return null;
            }
        }

        public static List<JsonObject> convertToJsonObject(String jsonString){
            Gson gson = new Gson();
            JsonArray jsonArray = null;
            List<JsonObject> jsonObjectList = new ArrayList<>();
            if (jsonString != null) {
                // Convert the JSON string to a JsonObject using Gson

                jsonArray = gson.fromJson(jsonString, JsonArray.class);
                for(int i = 0; i < jsonArray.size(); i++){
                    jsonObjectList.add(jsonArray.get(i).getAsJsonObject());
                }
            }
            return jsonObjectList;
        }
    }
}
