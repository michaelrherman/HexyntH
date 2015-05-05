package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Toolbar containing core control buttons
 */

public class Toolbar extends JToolBar implements ActionListener {

    private JButton saveButton;
    private JButton loadButton;
    private JButton clearButton;
    private JButton startButton;
    private JButton pauseButton;
    private JButton stopButton;
    private JButton recordButton;

    private ToolBarListener toolBarListener;

    public Toolbar() {

        saveButton = new JButton("Save");
        saveButton.setToolTipText("Save");

        loadButton = new JButton("Load");
        loadButton.setToolTipText("Load");

        clearButton = new JButton("Clear");
        clearButton.setToolTipText("Clear");

        startButton = new JButton("Start");
        startButton.setToolTipText("Start");

        pauseButton = new JButton("Pause");
        pauseButton.setToolTipText("Pause");

        stopButton = new JButton("Stop");
        stopButton.setToolTipText("Stop");

        recordButton = new JButton("Record");
        recordButton.setToolTipText("Record");

        saveButton.addActionListener(this);
        loadButton.addActionListener(this);
        clearButton.addActionListener(this);
        startButton.addActionListener(this);
        pauseButton.addActionListener(this);
        stopButton.addActionListener(this);
        recordButton.addActionListener(this);

        add(saveButton);
        add(loadButton);
        add(clearButton);
        add(startButton);
        add(pauseButton);
        add(stopButton);
        add(recordButton);
    }

    //set the default listener for the toolbar
    public void setToolBarListener(ToolBarListener listener) {
        this.toolBarListener = listener;
    }

    //fire off events on button clicks.
    //separate listeners for button & toggle
    @Override
    public void actionPerformed(ActionEvent e) {

        //get source of the ActionEvent
        JButton clicked = (JButton) e.getSource();

        /////// buttons send signal to listener ///////

        if (clicked == saveButton) {
            if (toolBarListener != null) {
                toolBarListener.saveClicked();
            }
        } else if (clicked == loadButton) {
            if (toolBarListener != null) {
                toolBarListener.loadClicked();
            }
        } else if (clicked == clearButton) {
            if (toolBarListener != null) {
                toolBarListener.clearClicked();
            }
        } else if (clicked == startButton) {
            if (toolBarListener != null) {
                toolBarListener.startClicked();
            }
        } else if (clicked == pauseButton) {
            if(toolBarListener != null) {
                toolBarListener.pauseClicked();
            }
        } else if (clicked == stopButton) {
            if (toolBarListener != null) {
                toolBarListener.stopClicked();
            }
        } else if (clicked == recordButton) {
            if (toolBarListener != null) {
                toolBarListener.recordClicked();
            }
        }
    }
}