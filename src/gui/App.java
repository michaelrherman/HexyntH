package gui;

import engine.Engine;

import javax.swing.*;

/**
 * Runs the application
 */
public class App {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MainFrame();
                Engine engine = new Engine();
                engine.testStepper();
            }
        });
    }
}
