package controller;

import model.*;
import java.util.List;

/**
 * links GUI to model
 */

public class Controller {

    Database db = new Database();

    /****************** DB COMMANDS ***********************/
    /******************************************************/

    public List<Voice> getVoices() {
        return db.getVoices();
    }

    public void connect() {
        db.connect();
    }

    public void disconnect() {
        db.disconnect();
    }

    public void createTable() {
        db.createTable();
    }

    public void loadDefault() {
        db.loadDefault();
    }

    public void loadSet(int id) {
        db.loadSet(id);
    }

    public void loadSound(Voice voice) {
        db.loadSound(voice);
    }

    public void removeSound(int index) {
        db.removeSound(index);
    }

    public void clearAll() {
        db.clearAll();
    }

    /**********************************************************/
    /*************** END DB COMMANDS **************************/
}
