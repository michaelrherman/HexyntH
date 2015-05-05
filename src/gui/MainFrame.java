package gui;

import controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * mainframe for the GUI
 */

public class MainFrame extends JFrame {

    Controller controller;
    Toolbar toolbar;
    JTabbedPane tabbedPane;
    JSplitPane splitPane;
    JLayeredPane dropZone;
    JPanel stepper;
    Dimension defaultDimension;
    JFileChooser fileChooser;

    public MainFrame() {

        ///// primary frame settings & components /////////

        defaultDimension = new Dimension(800, 800);

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        setMinimumSize(defaultDimension);
        setMaximumSize(defaultDimension);
        setPreferredSize(defaultDimension);
        setSize(defaultDimension);

        setLayout(new BorderLayout());

        setLocationRelativeTo(null);

        setJMenuBar(createMenu());
        toolbar = new Toolbar();

        setVisible(true);

        controller = new Controller();
        tabbedPane = new JTabbedPane();
        dropZone = new JLayeredPane();
        stepper = new JPanel();

        splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, dropZone, tabbedPane);
        splitPane.setOneTouchExpandable(true);

        tabbedPane.addTab("DropZone", dropZone);
        tabbedPane.addTab("Stepper", stepper);

        fileChooser = new JFileChooser();
        fileChooser.addChoosableFileFilter(new SessionFileFilter());

        add(toolbar, BorderLayout.PAGE_START);
        add(splitPane, BorderLayout.CENTER);

        ///////// listeners ///////////////////

        //listens for close event,
        //disposes & garbage collects
        addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent we) {
                //controller.disconnect();
                dispose();
                System.gc();
            }
        });
    }

    //////////////MENU//////////////////////////

    private JMenuBar createMenu() {

        //building it up
        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        JMenu viewMenu = new JMenu("View");
        JMenu prefsMenu = new JMenu("Preferences");

        JMenuItem loadItem = new JMenuItem("Load Session...");
        JMenuItem saveItem = new JMenuItem("Save Session...");
        JMenuItem exitItem = new JMenuItem("Exit");

        //checkbox items for view/hide selections
        JCheckBoxMenuItem viewAudioItem = new JCheckBoxMenuItem("Show Audio Controls");
        JCheckBoxMenuItem viewVisualItem = new JCheckBoxMenuItem("Show Video Controls");
        JCheckBoxMenuItem viewTreeItem = new JCheckBoxMenuItem("Show File Tree");
        JMenuItem prefsItem = new JMenuItem("Preferences...");

        fileMenu.add(loadItem);
        fileMenu.add(saveItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);

        viewMenu.add(viewAudioItem);
        viewMenu.add(viewVisualItem);
        viewMenu.add(viewTreeItem);

        prefsMenu.add(prefsItem);

        menuBar.add(fileMenu);
        menuBar.add(viewMenu);
        menuBar.add(prefsMenu);

        /////// mnemonics and accelerators //////////////////

        fileMenu.setMnemonic(KeyEvent.VK_F);
        exitItem.setMnemonic(KeyEvent.VK_X);

        exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_MASK));
        prefsItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.CTRL_MASK));

        viewAudioItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
        viewVisualItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_MASK));
        viewTreeItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, InputEvent.CTRL_MASK));

        /////// action listeners ///////////////////////////

        // show/hide a/v panels
        viewAudioItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO: show/hide A/V panels & file tree
            }
        });

        // show preferences panel
        prefsItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO: show preferences panel
            }
        });

        // listens for exit, confirms
        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //exit confirmation popup
                int action = JOptionPane.showConfirmDialog(MainFrame.this,
                        "Do you really want to exit?", "Confirm exit",
                        JOptionPane.OK_CANCEL_OPTION);

                if (action == JOptionPane.OK_OPTION) {

                    WindowListener[] listeners = getWindowListeners();

                    for (WindowListener listener : listeners) {
                        listener.windowClosing(new WindowEvent(MainFrame.this, 0));
                    }
                }
            }
        });
        return menuBar;
    }
}