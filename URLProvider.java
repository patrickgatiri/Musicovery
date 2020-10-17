public class URLProvider {
    public URLProvider() {
    }

    public String getNewSongsURL(){
        return "http://musicovery.com/api/V6/search.php?fct=search&q=new&artist=false";
    }

    public String searchArtistURL(String searchString) {
        return "http://musicovery.com/api/V6/artist.php?fct=search&artistname=" + searchString;
    }

    public String searchSongURL(String searchString){
        return "http://musicovery.com/api/V6/track.php?fct=search&title=" + searchString;
    }

    public String similarSongsURL (String songID){
        return "http://musicovery.com/api/V6/track.php?fct=getsimilar&songsnumber=25&id=" + songID;
    }

    public String playlistFromSongURL (String songID){
        return "http://musicovery.com/api/V6/playlist.php?fct=getfromtrack&resultsnumber=25&id=190210" + songID;
    }

    public String playlistFromArtistURL (String artistID){
        return "http://musicovery.com/api/V6/playlist.php?&fct=getfromartist&resultsnumber=25&artistmbid=" + artistID;
    }

    public String playlistFromGenreURL (String genre){
        return "http://musicovery.com/api/V6/playlist.php?&fct=getfromtag&tag=" + genre;
    }
}
