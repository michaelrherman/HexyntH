package resource;

import javax.swing.*;
import java.awt.*;

/**
 * can be used for loading extra resources
 */

public class Loader {

    public static void loadFont() {
        new UIFont("src\\resource\\font\\nk57-monospace-no-bk.otf");
    }

    public static Image debugCat() {
        return new ImageIcon("src\\resource\\images\\debugcat.png").getImage();
    }
}


