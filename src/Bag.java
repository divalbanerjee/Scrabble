import java.util.Arrays;
import java.io.*;
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
        Tile tempTile = new Tile("a", 0);
        int i  = 0;
        System.out.print("Shuffled tiles:");

        for(i = 0; i < 100; i++){
            rnum = (int) Math.random() * ((100-1)+1);
        }
    }

    public void OutputToConsole(){
        int i = 0;
        for(i = 1; i < myBagOfTiles.length; i++){
            System.out.println(myBagOfTiles[i].toString());
        }
    }

    @Override
    public String toString() {
        return "Bag [bagOfTiles=" + Arrays.toString(myBagOfTiles) + "]";
    }


}
