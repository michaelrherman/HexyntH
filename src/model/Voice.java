package model;

/**
 * voice (synth voice) to be used by sockets
 */
public class Voice {

    private int id;
    private String name;
    private int sound;

    public Voice(int groupID, int id, String name, int sound) {

        this.id = id;
        this.name = name;
        this.sound = sound;
    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int getSound() {
        return sound;
    }
    public String toString() {
        return id + ": " + name;
    }
}
