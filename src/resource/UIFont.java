package resource;

import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * class to set the font for the entire program
 */

public class UIFont {

    private static String fontPath;

    public UIFont(String filePath) {
        UIFont.fontPath = filePath;
        registerFont();
    }
    private void registerFont() {

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();

        try {
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File(fontPath)));
        } catch (IOException ioe) {
            String err = ioe.getMessage();
            System.out.println(err);
        } catch (FontFormatException ffe) {
            String err = ffe.getMessage();
            System.out.println(err);
        }
    }
}