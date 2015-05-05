package gui;

import javax.swing.*;
import java.net.URL;

/**
 * Some extra gui utilities
 */
public class Utils {

    //gets the file extension from file name
    public static String getFileExtension(String name) {

        int pointIndex = name.lastIndexOf(".");

        if (pointIndex == -1) {
            return null;
        }
        if (pointIndex == name.length() - 1) {
            return null;
        }
        return name.substring(pointIndex + 1, name.length());
    }

    //load icon images, warn if not present
    public static ImageIcon createIcon(String path) {

        ImageIcon icon = new ImageIcon();
        URL url = System.class.getResource(path);
        if (url == null) {
            System.err.println("Unable to load image " + path);
        }
        else {
            icon = new ImageIcon(url);
        }
        return icon;
    }

}
