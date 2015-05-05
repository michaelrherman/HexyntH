package gui;

import javax.swing.*;
import java.awt.*;

/**
 * cookie cutter for JSliders.
 */
public class SliderMaker extends JSlider {

    public static JSlider verticalSlider() {
        JSlider slider = new JSlider(JSlider.VERTICAL);
        slider.setFocusable(true);
        slider.setBackground(Color.black);
        slider.setForeground(Color.DARK_GRAY);
        slider.setMaximum(100);
        slider.setMinimum(0);
        slider.setBorder(BorderFactory.createLineBorder(Color.lightGray, 1));
        slider.setPaintLabels(false);
        slider.setPaintTrack(true);
        slider.setPaintTicks(true);
        slider.setSize(20, 100);
        slider.setMinorTickSpacing(10);
        slider.setVisible(true);
        return slider;
    }
}
