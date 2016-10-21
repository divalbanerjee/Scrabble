import javafx.scene.shape.*;

import javax.swing.*;
import java.awt.*;

/**
 * Created by div on 10/20/2016.
 */
public class ScrabbleGUI extends JFrame {

    Button btnCheckWord = new Button(Color.white);

    //Tiles

    tileButton btnTile1 = new tileButton(new Tile("-",0));
    tileButton btnTile2 = new tileButton(new Tile("-",0));
    tileButton btnTile3 = new tileButton(new Tile("-",0));
    tileButton btnTile4 = new tileButton(new Tile("-",0));
    tileButton btnTile5 = new tileButton(new Tile("-",0));
    tileButton btnTile6 = new tileButton(new Tile("-",0));
    tileButton btnTile7 = new tileButton(new Tile("-",0));

    tileButton btnOptionTile1 = new tileButton(new Tile("A",0));
    tileButton btnOptionTile2 = new tileButton(new Tile("A",0));
    tileButton btnOptionTile3 = new tileButton(new Tile("A",0));
    tileButton btnOptionTile4 = new tileButton(new Tile("A",0));
    tileButton btnOptionTile5 = new tileButton(new Tile("A",0));
    tileButton btnOptionTile6 = new tileButton(new Tile("A",0));
    tileButton btnOptionTile7 = new tileButton(new Tile("A",0));

    JLabel lblCorrect = new JLabel("");
    JLabel lblScore = new JLabel("Score:");


    public ScrabbleGUI(){
        Container container = getContentPane();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        JPanel tileDisplayPanel = new JPanel(new GridLayout(1,7,20,20));

        container.add(tileDisplayPanel);


        //TileDisplayPanel
        tileDisplayPanel.add(btnTile1);
        tileDisplayPanel.add(btnTile2);
        tileDisplayPanel.add(btnTile3);
        tileDisplayPanel.add(btnTile4);
        tileDisplayPanel.add(btnTile5);
        tileDisplayPanel.add(btnTile6);
        tileDisplayPanel.add(btnTile7);

        //Tile Option panel
        JPanel tileOptionPanel =  new JPanel(new GridLayout(1,7,20,20));
       // container.add(tileOptionPanel);
        container.add(tileOptionPanel);

        tileOptionPanel.add(btnOptionTile1);
        tileOptionPanel.add(btnOptionTile2);
        tileOptionPanel.add(btnOptionTile3);
        tileOptionPanel.add(btnOptionTile4);
        tileOptionPanel.add(btnOptionTile5);
        tileOptionPanel.add(btnOptionTile6);
        tileOptionPanel.add(btnOptionTile7);

        JPanel bottomPanel = new JPanel(new GridLayout(1,2,20,20));
        bottomPanel.add(lblCorrect);
        bottomPanel.add(lblScore);

        pack();
        setVisible(true);
    }
}

/*
This is a sample:
   Button btnTest = new Button(Color.white);
    JLabel lblTitle = new JLabel("Scrabble");
    tileButton btnTile = new tileButton(new Tile("A",1));

    public ScrabbleGUI(){
        JPanel btnPanel = new JPanel(new GridLayout(3,2,1,1));
        Container container = getContentPane();
        container.add(btnPanel);
        btnPanel.add(lblTitle);
        btnPanel.add(btnTest);
        btnPanel.add(btnTile);
        btnTest.repaint();;
        pack();
        setVisible(true);
 */