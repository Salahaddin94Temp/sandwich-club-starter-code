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

            JSONObject name = root.getJSONObject("name");

            String mainName = name.getString("mainName");

            JSONArray alsoKnownAsArray = name.getJSONArray("alsoKnownAs");
            List<String> alsoKnownAs = new ArrayList<>();
            for (int i = 0; i < alsoKnownAsArray.length(); i++)
                alsoKnownAs.add(alsoKnownAsArray.getString(i));

            String placeOfOrigin = root.getString("placeOfOrigin");

            String description = root.getString("description");

            String image = root.getString("image");

            JSONArray ingredientsArray = root.getJSONArray("ingredients");
            List<String> ingredients = new ArrayList<>();
            for (int i = 0; i < ingredientsArray.length(); i++)
                ingredients.add(ingredientsArray.getString(i));

            return new Sandwich(mainName, alsoKnownAs, placeOfOrigin, description, image, ingredients);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }
}
