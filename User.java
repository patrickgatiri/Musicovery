public class User{
    private FullName fullName;
    private String[] favouriteArtists;
    private String[] favouriteSongs;
    private String favouriteGenre;   

    public User(String firstName, String lastName, String[] favouriteArtists, String[] favouriteSongs, String favouriteGenre){
        this.fullName = new FullName(firstName, lastName);
        this.favouriteArtists = favouriteArtists;
        this.favouriteSongs = favouriteSongs;
        this.favouriteGenre = favouriteGenre;
    }

    public FullName getFullName(){
        return this.fullName;
    }
    public String[] getFavouriteArtists() {
        return this.favouriteArtists;
    }

    public String[] getFavouriteSongs() {
        return this.favouriteSongs;
    }

    public String getFavouriteGenre() {
        return this.favouriteGenre;
    }
 }

class FullName {
    private String firstName, lastName;

    public FullName(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() { 
        return firstName + " " + lastName;
    } 
}
