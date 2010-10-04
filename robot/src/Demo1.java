import lejos.nxt.*;
import lejos.robotics.navigation.Pilot;
import lejos.robotics.navigation.TachoPilot;
import lejos.util.ButtonCounter;

public class Demo1 {

    public static final float WHEEL_DIAMETER = 56.0f;
    public static final float TRACK_WIDTH = 110.0f;

    Pilot pilot;

    public void go() {
        while (true) {
            ButtonCounter bc = new ButtonCounter();
            bc.count("Hoeken / |zijde|?");
            int hoeken = bc.getLeftCount();
            int lengteZijde = 100 * bc.getRightCount();

            for (int i = 0; i < hoeken; i++) {
                pilot.travel(lengteZijde, false);
                pilot.steer(100.0f, (360 / hoeken));
            }

            System.out.println("" + pilot.getTravelDistance());
            Button.waitForPress();
        }
    }

    public static void main(String[] args) {
        Demo1 traveler = new Demo1();
        traveler.pilot = new TachoPilot(WHEEL_DIAMETER, TRACK_WIDTH, Motor.A,
                                        Motor.B);
        traveler.go();
    }
}
