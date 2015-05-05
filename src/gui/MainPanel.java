package gui;

import javax.swing.*;
import java.awt.*;

/**
 * main panel with pads, controls, etc.
 */

public class MainPanel extends JPanel {

    //collection of pads, their base xy & padOffset
    Pad[] pads = new Pad[16];
    int padAxisX = 90;
    int padAxisY = 120;
    int padOffset = 60;

    //key bindings for the pads
    String[] keyBindings = {"1", "2", "3", "4",
                            "q", "w", "e", "r",
                            "a", "s", "d", "f",
                            "z", "x", "c", "v"};

    //collection of toggle switches, base xy, offset, and labels
    Toggle[] switches = new Toggle[4];
    String[] switchLabels = {"shift", "play", "pause", "solo"};
    int toggleAxisX = 20;
    int toggleAxisY = 120;
    int toggleOffset = 30;

    JSlider volume = SliderMaker.verticalSlider();

    public MainPanel() {

        //add pads to the panel
        for (int x = 0; x < pads.length; x++) {
            //String num = Integer.toString(x + 1);
            pads[x] = new Pad();

            //make new row every 4
            if (x > 1 && x % 4 == 0) {
                padAxisX = 90;
                padAxisY += padOffset;
            }
            pads[x].setLocation(padAxisX, padAxisY);
            add(pads[x]);
            padAxisX += padOffset;
        }
        for (int x = 0; x < switches.length; x++) {
            switches[x] = new Toggle();
            switches[x].setText(switchLabels[x]);
            switches[x].setLocation(toggleAxisX, toggleAxisY);
            add(switches[x]);
            toggleAxisY += toggleOffset;
        }
        volume.setLocation(20, 200);
        add(volume);
        setBackground(Color.black);
        setBounds(200, 100, 400, 400);
        setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
        setOpaque(true);
        setFocusable(true);
        setLayout(null);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    /** for adding user defined key bindings later **/
    public void setKeyBinding(int index, String key) {
        keyBindings[index] = key;
    }
}