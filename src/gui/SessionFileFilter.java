package gui;

import javax.swing.filechooser.FileFilter;
import java.io.File;

/**
 * file filter for the file chooser
 */

public class SessionFileFilter extends FileFilter {

    @Override
    public boolean accept(File f) {

        if (f.isDirectory()) {
            return true;
        }

        String name = f.getName();
        String extension = Utils.getFileExtension(name);

        return extension != null && extension.equals("sesh");
    }

    @Override
    public String getDescription() {
        return "Session Files (*.sesh)";
    }

}
