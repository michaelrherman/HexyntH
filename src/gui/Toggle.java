package gui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * For various toggle controls
 */

public class Toggle extends JToggleButton {

    Font nk = new Font("NK57 Monospace Bk", Font.PLAIN, 10);

    Dimension toggle = new Dimension(50, 20);
    Color toggleHover = new Color(120, 0, 0);
    Color toggleOn = new Color(200, 0, 0);
    Color toggleOff = new Color(200, 150, 150, 75);
    Color toggleBorderColor = new Color(80, 0, 0);
    Color padFG = new Color(255, 255, 255);

    Border toggleBorder = BorderFactory.createLineBorder(toggleBorderColor, 2);

    public Toggle() {

        setMaximumSize(toggle);
        setMinimumSize(toggle);
        setSize(toggle);
        setPreferredSize(toggle);
        setBorder(toggleBorder);
        setBackground(toggleHover);
        setForeground(padFG);
        setFont(nk);
        setHorizontalTextPosition(CENTER);
        setVerticalTextPosition(CENTER);
        isFocusable();
        setContentAreaFilled(false);
    }
    @Override
    protected void paintComponent(Graphics g) {
        if (getModel().isSelected()) {
            g.setColor(toggleOn);
        }else if (getModel().isRollover()) {
            g.setColor(toggleHover);
        }else {
            g.setColor(toggleOff);
        }
        g.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(g);
    }

}
