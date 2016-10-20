

// This is a custom button
//Not the same as JButton
//Used as a custom swing component

import javax.swing.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Font;

public class Button extends JPanel{

    //button properties or variables
    Font myFont = new Font("Helvetica", Font.BOLD, 30);
    String myButtonText = "New Button";


    public Button(Color backColor){
        setBackground(backColor);

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
    }

    public void setFont(Font font){this.myFont = font;} //change font

    public void setText(String buttonText){this.myButtonText = buttonText;} //Change text


}
