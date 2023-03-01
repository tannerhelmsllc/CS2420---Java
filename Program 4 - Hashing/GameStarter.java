
import java.io.*;
import java.util.*;

public class GameStarter {
    public GameStarter() {
        H = new HashTable<WordInfo>();
    }
  
    public int computeScore(WordInfo wi) {
        return 0;
    }

    public void playGame(String filename) {
        fileName = filename;
        System.out.println("FILE " + filename);
        try {
            Scanner sc = new Scanner(new File(filename));
            while (sc.hasNext()) {
                H.insert(new WordInfo(sc.next()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(H.toString(H.size()));


    }

    private String fileName;
    private HashTable<WordInfo> H;


    public static void main(String[] args) {
         String[] games = {"game0.txt", "game1.txt", "game2.txt", "game3.txt", "game4.txt"};
         for (String filename : games) {
            GameStarter g = new GameStarter();
            g.playGame(filename);
            System.out.println(g);
        }


    }

}
