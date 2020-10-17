import java.io.*;
import java.util.ArrayList;
import java.util.Map;
import java.net.*;

public class Program {
    public static void main(String[] args) {
        /*
         * @params gospel country trap african new-wave new-age
         */

        ArrayList<Music> objects;

        try {
            System.out.println("\nGospel songs \n");
            objects = new Recommender().recommendOnGenreOrMood("gospel");

            for (Music music : objects) {
                System.out.println(music.getName() + " " + music.getSinger() + ".\n");
            }

            System.out.println();

            System.out.println("Country songs \n");

            objects = new Recommender().recommendOnGenreOrMood("country");

            for (Music music : objects) {
                System.out.println(music.getName() + " " + music.getSinger() + ".\n");
            }

            System.out.println();

            System.out.println("Trap songs \n");
            objects = new Recommender().recommendOnGenreOrMood("trap");

            for (Music music : objects) {
                System.out.println(music.getName() + " " + music.getSinger() + ".\n");
            }

            System.out.println();

            System.out.println("Native songs \n");
            objects = new Recommender().recommendOnGenreOrMood("african");

            for (Music music : objects) {
                System.out.println(music.getName() + " " + music.getSinger() + ".\n");
            }

            System.out.println();

            System.out.println("Latest songs \n");
            objects = new Recommender().recommendOnGenreOrMood("new-age");

            for (Music music : objects) {
                System.out.println(music.getName() + " " + music.getSinger() + ".\n");
            }

            System.out.println();
        } catch (Exception e) {
            System.out.println("Network error. Please retry");
        }
    }
}
