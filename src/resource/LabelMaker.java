package resource;

import javax.swing.*;
import java.awt.*;

/**
 * cookie cutter for labels
 */
public class LabelMaker extends JLabel {

    //default font for all labels
    private static Font nk57 = new Font("NK57 Monospace Bk", Font.PLAIN, 32);

    //some common colors to use
    private static Color dark75 = new Color(80, 80, 80, 75);
    private static Color darker75 = new Color(50, 50, 50, 75);
    private static Color textColor = new Color(240, 240, 230);


    //builds the error label
    public static JLabel errorLabel() {

        JLabel label = new JLabel();
        label.setBounds(CENTER, TOP, 300, 40);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setFont(nk57);
        label.setOpaque(true);
        label.setBackground(dark75);
        label.setForeground(textColor);
        label.setBorder(BorderFactory.createLineBorder(darker75, 2));
        label.setHorizontalTextPosition(CENTER);
        label.setVerticalTextPosition(CENTER);
        label.setText("That's an ERROR.");
        return label;
    }
}
