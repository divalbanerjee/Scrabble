import javax.swing.*;
import java.awt.*;

/**
 * Created by div on 10/20/2016.
 */
public class ScrabbleGUI extends JFrame {
    Button btnTest = new Button(Color.white);
    JLabel lblTitle = new JLabel("Scrabble");

    public ScrabbleGUI(){
        JPanel btnPanel = new JPanel(new GridLayout(2,2,1,1));
        Container container = getContentPane();
        container.add(btnPanel);
        btnPanel.add(lblTitle);
        btnPanel.add(btnTest);
        btnTest.repaint();
        pack();
        setVisible(true);
    }
}
