package engine;

import javax.sound.sampled.Control;
import javax.sound.sampled.Line;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.LineUnavailableException;

/**
 * Created by sluggish.goat on 5/2/2015.
 */
public class Mixer implements Line {

    @Override
    public Info getLineInfo() {
        return null;
    }

    @Override
    public void open() throws LineUnavailableException {

    }

    @Override
    public void close() {

    }

    @Override
    public boolean isOpen() {
        return false;
    }

    @Override
    public Control[] getControls() {
        return new Control[0];
    }

    @Override
    public boolean isControlSupported(Control.Type control) {
        return false;
    }

    @Override
    public Control getControl(Control.Type control) {
        return null;
    }

    @Override
    public void addLineListener(LineListener listener) {

    }

    @Override
    public void removeLineListener(LineListener listener) {

    }
}
