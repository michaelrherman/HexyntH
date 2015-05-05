package gui;

import resource.LabelMaker;

import javax.swing.*;
import java.awt.*;

/**
 * Panel for bug reporting
 */

//TODO: figure out how to send report to google doc, as email potentially insecure.

public class ErrorPanel extends JPanel {

    private boolean visible;
    private Image errorImage;

    public ErrorPanel(Image errorImage) {

        JLabel errorLabel = LabelMaker.errorLabel();

        this.errorImage = errorImage;
        Dimension size = new Dimension(errorImage.getWidth(null), errorImage.getHeight(null));
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setSize(size);
        setBounds(100, 100, errorImage.getWidth(null), errorImage.getHeight(null));
        setLayout(null);

        errorLabel.setAlignmentX(CENTER_ALIGNMENT);
        errorLabel.setAlignmentY(TOP_ALIGNMENT);
        errorLabel.setText("BUGS!");
        this.add(errorLabel);
        setFocusable(true);
        setVisible(false);

        visible = false;
    }
    public boolean getVisibility() {
        return visible;
    }
    public void setVisibility(boolean vis) {
        visible = vis;
    }
    public void toggleErrorPanel(boolean vis) {
        if (vis) {
            setVisible(false);
            setVisibility(false);
            setFocusable(false);
        }else {
            setVisible(true);
            setVisibility(true);
            setFocusable(true);
        }
    }
    public void paintComponent(Graphics g) {
        g.drawImage(errorImage, 0, 0, null);
    }
}