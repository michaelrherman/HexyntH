package gui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * cookie cutter for buttons
 */

public class Pad extends JButton {

    Color padHover = new Color(120, 0, 0);
    Color padOn = new Color(200, 0, 0);
    Color padOff = new Color(200, 150, 150, 75);
    Color padBorderColor = new Color(80, 0, 0);

    Dimension pad = new Dimension(50, 50);

    Border padBorder = BorderFactory.createLineBorder(padBorderColor, 2);

    public Pad() {

        setMaximumSize(pad);
        setMinimumSize(pad);
        setSize(pad);
        setPreferredSize(pad);
        setBorder(padBorder);
        setBackground(padHover);
        isFocusable();
        setContentAreaFilled(false);
    }
    @Override
    protected void paintComponent(Graphics g) {
        if (getModel().isPressed()) {
            g.setColor(padOn);
        }else if (getModel().isRollover()) {
            g.setColor(padHover);
        }else {
            g.setColor(padOff);
        }
        g.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(g);
    }

    public void selected() {
        this.setBackground(padOn);
    }
}


