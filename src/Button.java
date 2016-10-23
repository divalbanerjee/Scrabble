

// This is a custom button
//Not the same as JButton
//Used as a custom swing component

import javax.swing.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.geom.RoundRectangle2D;


public class Button extends JPanel{

    //button properties or variables
    Font myFont = new Font("Helvetica", Font.PLAIN, 20);
    String myButtonText = "New Button";
    int myButtonPadding =  3;
    int myButtonWidth = 150;
    int myVerticalShift = 0;
    int myButtonHeight = 60;
    Color myPaddingColor= Color.GRAY;
    int myPush = 0;
    int myButtonposx = 0;
    int mtButtonposy = 0;

    public Button(Color backColor){
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        myVerticalShift = getHeight()/2  -myButtonHeight/2;
        g.setFont(myFont);

        g.setColor(new Color(144,12,63));
        g.fillRoundRect(20+ this.myButtonPadding,myVerticalShift +this.myButtonPadding,this.myButtonWidth,this.myButtonHeight,25,25); //xpos, y pos, width, height

        g.setColor(new Color(209,10,67));
        g.fillRoundRect(20 + this.myPush,myVerticalShift + this.myPush,this.myButtonWidth,this.myButtonHeight,25,25); //xpos, y pos, width, height

        g.setColor(new Color(255,195,0));
        //g.drawString(myButtonText,(int)(getWidth()/2-myButtonText.length()*myFont.getSize()/2), (int)(getHeight()/2*myFont.getSize()/2));
        g.drawString(this.myButtonText,-30 + this.myButtonWidth/2 , myVerticalShift+5 + this.myButtonHeight/2);
    }

    public void setFont(Font font){this.myFont = font;} //change font

    public void setText(String buttonText){this.myButtonText = buttonText;} //Change text

    public void setPadding(Integer paddingAmount){this.myButtonPadding = paddingAmount;} //Change text

    public void setPaddingColor(Color paddingColor){this.myPaddingColor = paddingColor;} //change padding color of button

    public void push(Boolean Pushed){
        if(Pushed = true){
            this.myPush = this.myButtonPadding;
        }
        else if(Pushed = false){
            this.myPush = 0;
        }
    }
}
