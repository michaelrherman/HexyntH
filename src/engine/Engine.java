package engine;
/**
 * runs the logic for the sequencer
 */
public class Engine {
    Stepper stepper = new Stepper();

    public Engine() {
        //doesn't need anything (yet)
    }

    //just to test sending instruments, etc to the stepper
    public void testStepper() {
        stepper.play(102, 30);
    }
}
