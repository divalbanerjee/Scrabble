import java.io.IOException;
import java.util.Scanner;


public class Tester {

    public static void main(String[]args) {

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
    }
}
