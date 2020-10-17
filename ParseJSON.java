import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONObject;
import org.json.JSONArray;

public class ParseJSON {
    private JSONObject jsonObject;

    private double[] jsonItems, userData;

    private HashMap<String, String> hashMap;

    public ParseJSON(String jsonString) {
        this.jsonObject = (JSONObject) new JSONObject(jsonString);
        Regression regression = new Regression(jsonItems, userData);
        hashMap = new HashMap();
    }

    public HashMap<String, String> getArtistSongs() {
        JSONArray songsArray = jsonObject.getJSONObject("tracks").getJSONArray("track");

        for (int i = 0; i < songsArray.length(); i++) {
            JSONObject songObject = songsArray.getJSONObject(i);
            hashMap.put(songObject.getString("title"), songObject.getString("releasedate"));
        }

        return hashMap;
    }

    public ArrayList<Music> recommendedSongsOnGenreOrMood() {
        JSONArray songsArray = jsonObject.getJSONObject("tracks").getJSONArray("track");
        ArrayList<Music> musicObjects = new ArrayList<>();

        for (int i = 0; i < songsArray.length(); i++) {
            JSONObject songObject = songsArray.getJSONObject(i);
            musicObjects.add(new Music(songObject.getString("title"), songObject.getString("artist_display_name")));
        }

        return musicObjects;
    }

    public HashMap<String, String> searchSongs() {
        JSONArray songsArray = jsonObject.getJSONObject("tracks").getJSONArray("track");

        for (int i = 0; i < songsArray.length(); i++) {
            JSONObject songObject = songsArray.getJSONObject(i);
            hashMap.put(songObject.getString("title"), songObject.getString("artist_display_name"));
        }

        return hashMap;
    }

    public String getArtistID() {
        return jsonObject.getJSONObject("artists").getJSONObject("artist").getJSONObject("artists")
                .getJSONObject("artist").getString("mbid");
    }
}
