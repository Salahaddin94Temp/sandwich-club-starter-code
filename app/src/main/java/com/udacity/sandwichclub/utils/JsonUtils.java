package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {

        try {
            JSONObject root = new JSONObject(json);

            String mainName = "";
            List<String> alsoKnownAs = null;
            if (root.has("name")) {
                JSONObject name = root.getJSONObject("name");
                mainName = name.getString("mainName");

                JSONArray alsoKnownAsArray = name.getJSONArray("alsoKnownAs");
                alsoKnownAs = new ArrayList<>();
                for (int i = 0; i < alsoKnownAsArray.length(); i++)
                    alsoKnownAs.add(alsoKnownAsArray.getString(i));
            }

            String placeOfOrigin = "";
            if (root.has("placeOfOrigin"))
                placeOfOrigin = root.getString("placeOfOrigin");


            String description = "";
            if (root.has("description"))
                description = root.getString("description");

            String image = "";
            if (root.has("image"))
                image = root.getString("image");

            List<String> ingredients = null;
            if (root.has("ingredients")) {
                JSONArray ingredientsArray = root.getJSONArray("ingredients");
                ingredients = new ArrayList<>();
                for (int i = 0; i < ingredientsArray.length(); i++)
                    ingredients.add(ingredientsArray.getString(i));
            }

            return new Sandwich(mainName, alsoKnownAs, placeOfOrigin, description, image, ingredients);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }
}