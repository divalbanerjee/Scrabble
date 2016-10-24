import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by div on 10/20/2016.
 */
public class scabbleGame {

    String[] myWords = new String[80000];
    int totalWords  = 0;
    Tile[] tileValues = new Tile[26];
    Hand playerHand = new Hand(null);
    Hand enteredHand =  new Hand(null);


    public void getWords() throws IOException{
        Scanner check =  new Scanner(System.in);

        Scanner reader = new Scanner(new File("words.txt"));

        String strLine = "";
        int wordPos = 0;
        int i = 0;
        int count = 0;
        while(reader.hasNext()){

            strLine = reader.next();
                wordPos++;
                //	System.out.println(bagPos);
                myWords[wordPos] = new String(strLine);

        }
        reader.close();
        System.out.println("succcess");
        totalWords = wordPos;
    }


    public void grabTiles(){

    }

    public void replaceTile(){

    }

    int scoreWord(){
        int score = 0;

        return score;
    }

    public int checkHand(){
        int check = 0;
        return check;
    }

    public boolean checkWord(String word) {
        Boolean exists = false;
        String enteredWord = enteredHand.getWord();

        for (int i = 0; i < totalWords; ){
        }
        return exists;
    }

}
