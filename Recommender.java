import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.*;

public class Recommender {
    public Recommender() {
    }

    public String searchSongs(String songName) throws Exception {
        HashMap<String, String> matchingSongs = new ParseJSON(
                new HTTPRequest().makeRequest(new URLProvider().searchSongURL(songName))).searchSongs();

        return readMap(matchingSongs);
    }

    public String searchSongsByArtist(String artistName) throws Exception {
        String artistID = new ParseJSON(new HTTPRequest().makeRequest(new URLProvider().searchArtistURL(artistName)))
                .getArtistID();
        HashMap<String, String> artistSongs = new ParseJSON(
                new HTTPRequest().makeRequest(new URLProvider().playlistFromArtistURL(artistID))).getArtistSongs();

        return readMap(artistSongs);
    }

    public ArrayList<Music> recommendOnGenreOrMood(String genreName) throws Exception {
        return new ParseJSON(new HTTPRequest().makeRequest(new URLProvider().playlistFromGenreURL(genreName)))
                .recommendedSongsOnGenreOrMood();
    }

    private String readMap(HashMap<String, String> hashMap) throws Exception {
        Set<Map.Entry<String, String>> mapSet = hashMap.entrySet();

        String mapEntries = "";

        for (Map.Entry<String, String> mapEntry : mapSet) {
            mapEntries += mapEntry.getKey() + " : " + mapEntry.getValue() + ". \n";
        }

        return mapEntries;
    }
}
