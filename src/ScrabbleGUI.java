import javafx.scene.shape.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.*;


public class ScrabbleGUI extends JFrame {

    Button btnCheckWord = new Button(Color.white);
    Font font = new Font("Helvetica", Font.PLAIN, 40);
    //UIManager.put("OptionPane.messageFont", font);
   // UIManager.put("OptionPane.messageFont",font);

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

    boolean btnOptionTile1enabled = true;
    boolean btnOptionTile2enabled = true;
    boolean btnOptionTile3enabled = true;
    boolean btnOptionTile4enabled = true;
    boolean btnOptionTile5enabled = true;
    boolean btnOptionTile6enabled = true;
    boolean btnOptionTile7enabled = true;


    JLabel lblCorrect = new JLabel("");
    JLabel lblScore = new JLabel("Score:");
    JLabel lblTitle = new JLabel("Scrabble");
    JList lstTopTen = new JList();

    scabbleGame game = new scabbleGame();


    public ScrabbleGUI(){
        Container container = getContentPane();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        container.setBackground(new Color(255,97,61));
        JPanel tileDisplayPanel = new JPanel(new GridLayout(1,8,20,20));
        JPanel title = new JPanel(new GridLayout(1,1,20,20));
        title.setBackground(new Color(255,97,61));
        container.add(title);

       // game.bestPlayers.myTopTenList.toString();

        lblTitle.setForeground(Color.white);
        lblCorrect.setForeground(Color.white);
        lblScore.setForeground(Color.white);

        lblTitle.setFont(font);
        title.add(lblTitle);



        tileDisplayPanel.setBackground(new Color(255,97,61));

        container.add(tileDisplayPanel);


        lblScore.setFont(font);

        btnTile1.setBackground(new Color(255,97,61));
        btnTile2.setBackground(new Color(255,97,61));
        btnTile3.setBackground(new Color(255,97,61));
        btnTile4.setBackground(new Color(255,97,61));
        btnTile5.setBackground(new Color(255,97,61));
        btnTile6.setBackground(new Color(255,97,61));
        btnTile7.setBackground(new Color(255,97,61));

        btnOptionTile1.setBackground(new Color(255,97,61));
        btnOptionTile2.setBackground(new Color(255,97,61));
        btnOptionTile3.setBackground(new Color(255,97,61));
        btnOptionTile4.setBackground(new Color(255,97,61));
        btnOptionTile5.setBackground(new Color(255,97,61));
        btnOptionTile6.setBackground(new Color(255,97,61));
        btnOptionTile7.setBackground(new Color(255,97,61));

        btnOptionTile1.setTile(game.optionHand.getTile(1));
        btnOptionTile2.setTile(game.optionHand.getTile(2));
        btnOptionTile3.setTile(game.optionHand.getTile(3));
        btnOptionTile4.setTile(game.optionHand.getTile(4));
        btnOptionTile5.setTile(game.optionHand.getTile(5));
        btnOptionTile6.setTile(game.optionHand.getTile(6));
        btnOptionTile7.setTile(game.optionHand.getTile(7));



        //TileDisplayPanel

        tileDisplayPanel.add(btnTile1);
        tileDisplayPanel.add(btnTile2);
        tileDisplayPanel.add(btnTile3);
        tileDisplayPanel.add(btnTile4);
        tileDisplayPanel.add(btnTile5);
        tileDisplayPanel.add(btnTile6);
        tileDisplayPanel.add(btnTile7);

        //Tile Option panel
        JPanel tileOptionPanel =  new JPanel(new GridLayout(1,8,20,20));

        tileOptionPanel.setBackground(new Color(255,97,61));
       // container.add(tileOptionPanel);
        container.add(tileOptionPanel);


        tileOptionPanel.add(btnOptionTile1);
        tileOptionPanel.add(btnOptionTile2);
        tileOptionPanel.add(btnOptionTile3);
        tileOptionPanel.add(btnOptionTile4);
        tileOptionPanel.add(btnOptionTile5);
        tileOptionPanel.add(btnOptionTile6);
        tileOptionPanel.add(btnOptionTile7);


        //JPanel otherPanel = new JPanel(new GridLayout(1,1,20,20));
       // container.add(otherPanel);


        JPanel bottomPanel = new JPanel(new GridLayout(1,2,20,20));
        bottomPanel.setBackground(new Color(255,97,61));
        container.add(bottomPanel);
        btnCheckWord.setText("Check Word");

        btnCheckWord.setBackground(new Color(255,97,61));

        bottomPanel.add(btnCheckWord);
        bottomPanel.add(lblScore);
        bottomPanel.add(lblCorrect);
       /// bottomPanel.add(lstTopTen);


        btnOptionTile1.addMouseListener(new MouseLIstenerTile1());
        btnOptionTile2.addMouseListener(new MouseLIstenerTile2());
        btnOptionTile3.addMouseListener(new MouseLIstenerTile3());
        btnOptionTile4.addMouseListener(new MouseLIstenerTile4());
        btnOptionTile5.addMouseListener(new MouseLIstenerTile5());
        btnOptionTile6.addMouseListener(new MouseLIstenerTile6());
        btnOptionTile7.addMouseListener(new MouseLIstenerTile7());
       // btnOptionTile1.addMouseListener();

        btnCheckWord.addMouseListener(new MouseListenerCheckButton());
        try {
            game.getWords();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.out.println("dictionary failed");
            e.printStackTrace();
        }

        pack();
        setVisible(true);
    }

    //event listeners
    public class MouseLIstenerTile1 extends MouseAdapter{
        public void mousePressed(MouseEvent e){
            if(btnOptionTile1enabled==true) {
                if(game.optionHand.getTile(1).getMyLetter().equals("-")){
                    Tile temp = new Tile("a",0);
                    temp.setMyLetter(JOptionPane.showInputDialog("Enter a letter for your tile"));
                    temp.setMyPoints(game.getTilePoints(temp));
                    game.optionHand.setTile(temp,1);
                }
                game.enteredHand.addTile(game.optionHand.getTile(1));
                btnOptionTile1enabled = false;
                btnOptionTile1.setVisibility(false);
                game.optionHand.getTile(1).setVisibility(false);
                if(game.enteredHand.length==1) {
                    btnTile1.setTile(game.enteredHand.getTile(1));
                }

                else if(game.enteredHand.length==2){
                    btnTile2.setTile(game.enteredHand.getTile(2));
                }
                else if(game.enteredHand.length==3){
                    btnTile3.setTile(game.enteredHand.getTile(3));
                }
                else if(game.enteredHand.length==4){
                    btnTile4.setTile(game.enteredHand.getTile(4));
                }
                else if(game.enteredHand.length==5){
                    btnTile5.setTile(game.enteredHand.getTile(5));
                }
                else if(game.enteredHand.length==6){
                    btnTile6.setTile(game.enteredHand.getTile(6));
                }
                else if(game.enteredHand.length==7){
                    btnTile7.setTile(game.enteredHand.getTile(7));
                }
            }
        }
    }

    public class MouseLIstenerTile2 extends MouseAdapter{
        public void mousePressed(MouseEvent e){
            if(btnOptionTile2enabled==true) {
                if(game.optionHand.getTile(2).getMyLetter().equals("-")){
                    Tile temp = new Tile("a",0);
                    temp.setMyLetter(JOptionPane.showInputDialog("Enter a letter for your tile"));
                    temp.setMyPoints(game.getTilePoints(temp));
                    game.optionHand.setTile(temp,2);
                }
                game.optionHand.getTile(2).setVisibility(false);
                game.enteredHand.addTile(game.optionHand.getTile(2));
                btnOptionTile2enabled = false;
                btnOptionTile2.setVisibility(false);
                if(game.enteredHand.length==1) {
                    btnTile1.setTile(game.enteredHand.getTile(1));
                }

                else if(game.enteredHand.length==2){
                    btnTile2.setTile(game.enteredHand.getTile(2));
                }
                else if(game.enteredHand.length==3){
                    btnTile3.setTile(game.enteredHand.getTile(3));
                }
                else if(game.enteredHand.length==4){
                    btnTile4.setTile(game.enteredHand.getTile(4));
                }
                else if(game.enteredHand.length==5){
                    btnTile5.setTile(game.enteredHand.getTile(5));
                }
                else if(game.enteredHand.length==6){
                    btnTile6.setTile(game.enteredHand.getTile(6));
                }
                else if(game.enteredHand.length==7){
                    btnTile7.setTile(game.enteredHand.getTile(7));
                }
            }
        }
    }

    public class MouseLIstenerTile3 extends MouseAdapter{
        public void mousePressed(MouseEvent e){
            if(btnOptionTile3enabled==true) {
                if(game.optionHand.getTile(3).getMyLetter().equals("-")){
                    Tile temp = new Tile("a",0);
                    temp.setMyLetter(JOptionPane.showInputDialog("Enter a letter for your tile"));
                    temp.setMyPoints(game.getTilePoints(temp));
                    game.optionHand.setTile(temp,3);
                }
                game.enteredHand.addTile(game.optionHand.getTile(3));
                btnOptionTile3enabled = false;
                game.optionHand.getTile(3).setVisibility(false);
                btnOptionTile3.setVisibility(false);
                if(game.enteredHand.length==1) {
                    btnTile1.setTile(game.enteredHand.getTile(1));
                }

                else if(game.enteredHand.length==2){
                    btnTile2.setTile(game.enteredHand.getTile(2));
                }
                else if(game.enteredHand.length==3){
                    btnTile3.setTile(game.enteredHand.getTile(3));
                }
                else if(game.enteredHand.length==4){
                    btnTile4.setTile(game.enteredHand.getTile(4));
                }
                else if(game.enteredHand.length==5){
                    btnTile5.setTile(game.enteredHand.getTile(5));
                }
                else if(game.enteredHand.length==6){
                    btnTile6.setTile(game.enteredHand.getTile(6));
                }
                else if(game.enteredHand.length==7){
                    btnTile7.setTile(game.enteredHand.getTile(7));
                }
            }
        }
    }

    public class MouseLIstenerTile4 extends MouseAdapter{
        public void mousePressed(MouseEvent e){
            if(btnOptionTile4enabled==true) {
                if(game.optionHand.getTile(4).getMyLetter().equals("-")){
                    Tile temp = new Tile("a",0);
                    temp.setMyLetter(JOptionPane.showInputDialog("Enter a letter for your tile"));
                    temp.setMyPoints(game.getTilePoints(temp));
                    game.optionHand.setTile(temp,4);
                }
                game.enteredHand.addTile(game.optionHand.getTile(4));
                btnOptionTile4enabled = false;
                game.optionHand.getTile(4).setVisibility(false);
                btnOptionTile4.setVisibility(false);
                if(game.enteredHand.length==1) {
                    btnTile1.setTile(game.enteredHand.getTile(1));
                }

                else if(game.enteredHand.length==2){
                    btnTile2.setTile(game.enteredHand.getTile(2));
                }
                else if(game.enteredHand.length==3){
                    btnTile3.setTile(game.enteredHand.getTile(3));
                }
                else if(game.enteredHand.length==4){
                    btnTile4.setTile(game.enteredHand.getTile(4));
                }
                else if(game.enteredHand.length==5){
                    btnTile5.setTile(game.enteredHand.getTile(5));
                }
                else if(game.enteredHand.length==6){
                    btnTile6.setTile(game.enteredHand.getTile(6));
                }
                else if(game.enteredHand.length==7){
                    btnTile7.setTile(game.enteredHand.getTile(7));
                }
            }
        }
    }

    public class MouseLIstenerTile5 extends MouseAdapter{
        public void mousePressed(MouseEvent e){
            if(btnOptionTile5enabled==true) {
                if(game.optionHand.getTile(5).getMyLetter().equals("-")){
                    Tile temp = new Tile("a",0);
                    temp.setMyLetter(JOptionPane.showInputDialog("Enter a letter for your tile"));
                    temp.setMyPoints(game.getTilePoints(temp));
                    game.optionHand.setTile(temp,5);
                }
                game.enteredHand.addTile(game.optionHand.getTile(5));
                btnOptionTile5enabled = false;
                game.optionHand.getTile(5).setVisibility(false);
                btnOptionTile5.setVisibility(false);
                if(game.enteredHand.length==1) {
                    btnTile1.setTile(game.enteredHand.getTile(1));
                }

                else if(game.enteredHand.length==2){
                    btnTile2.setTile(game.enteredHand.getTile(2));
                }
                else if(game.enteredHand.length==3){
                    btnTile3.setTile(game.enteredHand.getTile(3));
                }
                else if(game.enteredHand.length==4){
                    btnTile4.setTile(game.enteredHand.getTile(4));
                }
                else if(game.enteredHand.length==5){
                    btnTile5.setTile(game.enteredHand.getTile(5));
                }
                else if(game.enteredHand.length==6){
                    btnTile6.setTile(game.enteredHand.getTile(6));
                }
                else if(game.enteredHand.length==7){
                    btnTile7.setTile(game.enteredHand.getTile(7));
                }
            }
        }
    }

    public class MouseLIstenerTile6 extends MouseAdapter{
        public void mousePressed(MouseEvent e){
            if(btnOptionTile6enabled==true) {
                if(game.optionHand.getTile(6).getMyLetter().equals("-")){
                    Tile temp = new Tile("a",0);
                    temp.setMyLetter(JOptionPane.showInputDialog("Enter a letter for your tile"));
                    temp.setMyPoints(game.getTilePoints(temp));
                    game.optionHand.setTile(temp,6);
                }
                game.enteredHand.addTile(game.optionHand.getTile(6));
                btnOptionTile6enabled = false;
                game.optionHand.getTile(6).setVisibility(false);
                btnOptionTile6.setVisibility(false);
                if(game.enteredHand.length==1) {
                    btnTile1.setTile(game.enteredHand.getTile(1));
                }

                else if(game.enteredHand.length==2){
                    btnTile2.setTile(game.enteredHand.getTile(2));
                }
                else if(game.enteredHand.length==3){
                    btnTile3.setTile(game.enteredHand.getTile(3));
                }
                else if(game.enteredHand.length==4){
                    btnTile4.setTile(game.enteredHand.getTile(4));
                }
                else if(game.enteredHand.length==5){
                    btnTile5.setTile(game.enteredHand.getTile(5));
                }
                else if(game.enteredHand.length==6){
                    btnTile6.setTile(game.enteredHand.getTile(6));
                }
                else if(game.enteredHand.length==7){
                    btnTile7.setTile(game.enteredHand.getTile(7));
                }
            }
        }
    }

    public class MouseLIstenerTile7 extends MouseAdapter{
        public void mousePressed(MouseEvent e){
            if(btnOptionTile7enabled==true) {
                if(game.optionHand.getTile(7).getMyLetter().equals("-")){
                    Tile temp = new Tile("a",0);
                    temp.setMyLetter(JOptionPane.showInputDialog("Enter a letter for your tile"));
                    temp.setMyPoints(game.getTilePoints(temp));
                    game.optionHand.setTile(temp,7);
                }
                game.enteredHand.addTile(game.optionHand.getTile(7));
                btnOptionTile7enabled = false;
                game.optionHand.getTile(7).setVisibility(false);
                btnOptionTile7.setVisibility(false);
                if(game.enteredHand.length==1) {
                    btnTile1.setTile(game.enteredHand.getTile(1));
                }

                else if(game.enteredHand.length==2){
                    btnTile2.setTile(game.enteredHand.getTile(2));
                }
                else if(game.enteredHand.length==3){
                    btnTile3.setTile(game.enteredHand.getTile(3));
                }
                else if(game.enteredHand.length==4){
                    btnTile4.setTile(game.enteredHand.getTile(4));
                }
                else if(game.enteredHand.length==5){
                    btnTile5.setTile(game.enteredHand.getTile(5));
                }
                else if(game.enteredHand.length==6){
                    btnTile6.setTile(game.enteredHand.getTile(6));
                }
                else if(game.enteredHand.length==7){
                    btnTile7.setTile(game.enteredHand.getTile(7));
                }
            }
        }

    }

    public class MouseListenerCheckButton extends MouseAdapter{
        int score;
        public void mousePressed(MouseEvent e){
            try {
                score = game.scoreWord();
            }catch(IOException o){

            }
            if(score > 0) {
                game.player.myScore = score + game.player.myScore;
                lblScore.setText("Score:" + game.player.getMyScore());
                lblScore.setText("Score:" + game.player.getMyScore());
                game.replaceTiles();
                game.enteredHand.clearHand();

                btnTile1.setTile(new Tile("-",0));
                btnTile2.setTile(new Tile("-",0));
                btnTile3.setTile(new Tile("-",0));
                btnTile4.setTile(new Tile("-",0));
                btnTile5.setTile(new Tile("-",0));
                btnTile6.setTile(new Tile("-",0));
                btnTile7.setTile(new Tile("-",0));


                btnOptionTile1.setTile(game.optionHand.getTile(1));
                btnOptionTile2.setTile(game.optionHand.getTile(2));
                btnOptionTile3.setTile(game.optionHand.getTile(3));
                btnOptionTile4.setTile(game.optionHand.getTile(4));
                btnOptionTile5.setTile(game.optionHand.getTile(5));
                btnOptionTile6.setTile(game.optionHand.getTile(6));
                btnOptionTile7.setTile(game.optionHand.getTile(7));


                btnOptionTile1enabled = true;
                btnOptionTile2enabled = true;
                btnOptionTile3enabled = true;
                btnOptionTile4enabled = true;
                btnOptionTile5enabled = true;
                btnOptionTile6enabled = true;
                btnOptionTile7enabled = true;



                btnOptionTile1.setVisibility(true);
                btnOptionTile2.setVisibility(true);
                btnOptionTile3.setVisibility(true);
                btnOptionTile4.setVisibility(true);
                btnOptionTile5.setVisibility(true);
                btnOptionTile6.setVisibility(true);
                btnOptionTile7.setVisibility(true);

                game.enteredHand.length = 0;
                System.out.println(game.tilesUsed);
            }

            if(score ==0){ //lost the game
                lblScore.setText("You lost");
              //  JOptionPane.showConfirmDialog(,game.player.getMyScore());
            }





        }
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