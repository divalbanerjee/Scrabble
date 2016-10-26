import javax.swing.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.geom.RoundRectangle2D;
/**
 * Created by div on 10/20/2016.
 */

public class tileButton extends JPanel{

    //Actual Data
    Tile myTile = new Tile("-",0);

    //Graphics
    Font myFont = new Font("Helvetica", Font.PLAIN, 40);
    int myButtonPadding =  3;
    int myTileSize = 100;
    Color myPaddingColor= new Color(144,12,63);
    Color myMainColor = new Color(209,10,67);
    int myPush = 0;
    boolean visibility = true;


    public tileButton(Tile defaultTile){
        this.myTile = defaultTile;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (visibility == true) {
            g.setFont(myFont);

            g.setColor(myPaddingColor);
            g.fillRoundRect(20 + this.myButtonPadding, 20 + this.myButtonPadding, this.myTileSize, this.myTileSize, 25, 25); //xpos, y pos, width, height

            g.setColor(myMainColor);
            g.fillRoundRect(20 + this.myPush, 20 + this.myPush, this.myTileSize, this.myTileSize, 25, 25); //xpos, y pos, width, height

            g.setColor(new Color(255, 195, 0));
            //g.drawString(myButtonText,(int)(getWidth()/2-myButtonText.length()*myFont.getSize()/2), (int)(getHeight()/2*myFont.getSize()/2));
                g.drawString(this.myTile.getMyLetter(), 8 + this.myTileSize / 2, 35 + this.myTileSize / 2);

            g.setFont(new Font("Helvetica", Font.PLAIN, 20));
            g.drawString(this.myTile.getMyPoints() + "", this.myTileSize - 5, 45);
        }
    }

    public void setFont(Font font){this.myFont = font;} //change font

    public void setPadding(Integer paddingAmount){this.myButtonPadding = paddingAmount;} //Change text

    public void setPaddingColor(Color paddingColor){
        this.myPaddingColor = paddingColor;
        repaint();
    } //change padding color of button

    public void setTile(Tile tile){
        this.myTile = tile;
        repaint();
    }  //change tile

    public Tile checkForBlank(){
        if(this.myTile.myLetter.equals("-")){
            JOptionPane.showInputDialog("Enter Letter");

        }
        return this.myTile;
    }

    public void push(Boolean Pushed){
        if(Pushed = true){
            this.myPush = this.myButtonPadding;
        }
        else if(Pushed = false){
            this.myPush = 0;
        }
    }
    public void setVisibility(Boolean visible){
        this.visibility= visible;
        repaint();
    }
}
