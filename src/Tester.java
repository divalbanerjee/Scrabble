import java.io.IOException;
import java.util.Scanner;
import javax.swing.*;


public class Tester {

    public static void main(String[]args) {
        //Tile lab tester
        Bag tileBag = new Bag(null);
        Scanner reader = new Scanner(System.in);

        try {
            tileBag.generateTiles();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.out.println("bag generation failed");
            e.printStackTrace();
        }
        tileBag.OutputToConsole();



        //Scrabble project GUI
        JFrame gameWindow = new ScrabbleGUI();
        gameWindow.setTitle("Scrabble");
        gameWindow.setSize(1300,700);
        gameWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        gameWindow.setVisible(true);
    }
}
