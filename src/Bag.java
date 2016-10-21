import java.util.Arrays;
import java.io.*;
import java.util.Random;
import java.util.Scanner;
import java.math.*;
//this branch is for development
public class Bag {
    Tile[] myBagOfTiles = new Tile[101];

    Scanner check =  new Scanner(System.in);

    public Bag(Tile[] bagOfTiles) {
        super();
        this.myBagOfTiles = new Tile[101];
    }

    public Tile[] getBagOfTiles() {
        return myBagOfTiles;
    }

    public void setBagOfTiles(Tile[] bagOfTiles) {
        this.myBagOfTiles = bagOfTiles;
    }

    public void generateTiles() throws IOException{

        Scanner reader = new Scanner(new File("scrabblevalues.txt"));

        String Letter = "";
        int bagPos = 0;
        int i = 0;
        int count = 0;
        while(reader.hasNext()){

            Letter = reader.next();
            int Points = reader.nextInt();
            int Frequency = reader.nextInt();
            count++;
            for (i = 0; i < Frequency; i++){
                bagPos++;
                //	System.out.println(bagPos);
                myBagOfTiles[bagPos] = new Tile(Letter, Points);
            }
        }
        reader.close();
        System.out.println("succcess");
    }

    public void shuffle(){
        int rnum = 0;
        int swapNum = 0;
        Tile tempTile;
        int i  = 0;
        int a;
        Random rand = new Random();

        System.out.print("Shuffled tiles:");
        for(a = 0; a < 1000; a++) {
            for (i = 0; i < 100; i++) {
                //FIXME: isn't randomizing for some reason
                rnum = rand.nextInt(50) + 1;
                tempTile = myBagOfTiles[i];
                myBagOfTiles[i] = myBagOfTiles[rnum];
                myBagOfTiles[rnum] = tempTile;
            }
        }
    }

    public void OutputToConsole(){
        int i = 0;
        System.out.println(this.myBagOfTiles.length);
        for(i = 1; i < this.myBagOfTiles.length; i++)
            System.out.println(this.myBagOfTiles[i].toString());
    }

    @Override
    public String toString() {
        return "Bag [bagOfTiles=" + Arrays.toString(myBagOfTiles) + "]";
    }


}
