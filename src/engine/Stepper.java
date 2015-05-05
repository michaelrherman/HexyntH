package engine;

import javax.sound.midi.*;

/**
 * Step sequencer for pads
 * working out how to get it going for now
 * then will flesh it out more once I understand it better
 */

public class Stepper {
    public Stepper() {

    }

    public void play(int instrument, int note) {
        try {
            //create a sequencer and open it
            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();

            Sequence seq = new Sequence(Sequence.PPQ, 4);

            //track is in a sequence, and midi data in a track
            Track track = seq.createTrack();

            //////putting midi events into the track/////////

            //create message
            ShortMessage a = new ShortMessage();

            //1st arg = note on (144)
            //2nd arg = channel
            //3rd arg = note (0-127)
            //4th arg = velocity
            a.setMessage(144, 1, 20, 100);

            //trigger message a @ first beat
            MidiEvent noteOn = new MidiEvent(a, 1);
            track.add(noteOn);

            ShortMessage b = new ShortMessage();

            //128 = note off  (192 = change instrument)
            b.setMessage(128, 1, 20, 100);

            //trigger message b (end of note) @ beat 16
            MidiEvent noteOff = new MidiEvent(b, 16);

            //tracks can hold many MidiEvent objects
            track.add(noteOff);

            //give sequence to sequencer
            sequencer.setSequence(seq);

            sequencer.start();


        } catch (MidiUnavailableException e) {
            System.out.println(e.getMessage() + "\n" + e.getCause());
        } catch (InvalidMidiDataException e) {
            System.out.println(e.getMessage() + "\n" + e.getCause());
        }
    }
    
}
