package model;

import java.sql.*;
import java.util.Collections;
import java.util.List;

/**
 * model of sounds
 */

public class Database {

    //list of voices retrieved from db
    private List<Voice> voices;

    //setting up drivers, etc.
    private String driver = "org.apache.derby.jdbc.EmbeddedDriver";
    private String protocol = "jdbc:derby";
    private String dbName = "Bank";

    //connections, statements, etc.
    private Connection conn;
    private Statement stat;
    private ResultSet rs;
    private PreparedStatement ps;

    public Database() {
    }

    //connect & initialize model
    public void connect() {

        //TODO: Error handling: popup in mainframe. (Preload default bank?)
        if (conn != null) {
            return;
        }

        try {
            //load db driver
            try {
                Class.forName(driver);
            }
            catch (ClassNotFoundException cnf) {
                String err = cnf.getMessage();
                System.out.println(err);
            }
            //create embedded db
            conn = DriverManager.getConnection(protocol + dbName + ";create=true");
            stat = conn.createStatement();
        }
        catch (SQLException sqe) {
            System.out.println(sqe.getMessage());
        }
    }

    public void disconnect() {

        if (conn != null) {
            try {
                conn.close();
            }
            catch (SQLException sqe) {
                System.out.println("Cannot close db connection");
            }
        }
    }

    //create table in db
    public void createTable() {

        String create = "CREATE TABLE Bank " +
                        "(groupID int, soundID int, name varchar(30), sound int)";

        //attempt to create the table
        try {
            stat.executeUpdate(create);
            System.out.println("table created");
        }
        catch (SQLException sqe) {
            System.out.println(sqe.getMessage());
        }
        closeIt(stat);
    }

    //load all sounds (default)
    public void loadDefault() {

        //clear anything out of the list
        if (!voices.isEmpty()) {
            voices.clear();
        }

        //load everything from the db
        String loadBank = "SELECT * FROM Bank WHERE id=1";

        try {
            rs = stat.executeQuery(loadBank);
        }
        catch (SQLException sqe) {
            System.out.println(sqe.getMessage());
        }

        try {
            while (rs.next()) {
                int groupID = rs.getInt("groupID");
                int soundID = rs.getInt("soundID");
                String name = rs.getString("name");
                int sound = rs.getInt("sound");

                Voice voice = new Voice(groupID, soundID, name, sound);
                voices.add(voice);
            }
        }
        catch (SQLException sqe) {
            System.out.println(sqe.getMessage());
        }
        closeIt(stat);
        closeIt(rs);
    }

    //select a specific sound set
    public void loadSet(int id) {

        String load = "SELECT * FROM Bank WHERE id=?";

        try {
            ps = conn.prepareStatement(load);
        }
        catch (SQLException sqe) {
            System.out.println(sqe.getMessage());
        }

        try {
            ps.setInt(1, id);
        }
        catch (SQLException sqe) {
            System.out.println(sqe.getMessage());
        }
        closeIt(ps);
    }

    public void loadSound(Voice voice) {

        //get sound id, remove from current list
        int voiceid = voice.getId();
        int index = voices.indexOf(voice);
        voices.remove(voice);

        //run query
        String getSound = "SELECT * FROM Bank WHERE soundID=?";

        try {
            ps = conn.prepareStatement(getSound);
        }
        catch (SQLException sqe) {
            System.out.println(sqe.getMessage());
        }

        try {
            ps.setInt(1, voiceid);
        }
        catch (SQLException sqe) {
            System.out.println(sqe.getMessage());
        }

        //retrieve all parts of voice,
        //construct new voice,
        //add it to the bank @ previous index
        try {
            while (rs.next()) {
                int groupID = rs.getInt("groupID");
                int soundID = rs.getInt("soundID");
                String sound = rs.getString("name");
                int voiceNum = rs.getInt("sound");

                Voice newVoice = new Voice(groupID, soundID, sound, voiceNum);
                voices.add(index, newVoice);
            }
        }
        catch (SQLException sqe) {
            System.out.println(sqe.getMessage());
        }
        closeIt(ps);
        closeIt(rs);
    }

    //removes sound from list
    public void removeSound(int index) {
        voices.remove(index);
    }

    //clear all sounds
    public void clearAll() {
        voices.clear();
    }

    //get the list of synth voices
    public List<Voice> getVoices() {
        //prevent outside modification through wrapping
        return Collections.unmodifiableList(voices);

    }
    private void closeIt(AutoCloseable closeable) {
        try {
            closeable.close();
        }
        catch (SQLException sqe) {
            System.out.println("Error closing");
        } catch (Exception e) {
            System.out.println("Error closing");
        }
    }
}