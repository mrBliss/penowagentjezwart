import lejos.nxt.*;
import lejos.robotics.navigation.TachoPilot;
import lejos.util.ButtonCounter;

public class Demo1 {

    public static final float WHEEL_DIAMETER = 55.23f;
    public static final float TRACK_WIDTH = 125.93f;

    TachoPilot pilot;

    public void go() {
    	//pilot.setMoveSpeed(180.0f);
        while (true) {
            ButtonCounter bc = new ButtonCounter();
            bc.count("Hoeken / |zijde|?");
            int hoeken = bc.getLeftCount();
            int lengteZijde = 100 * bc.getRightCount();

            for (int i = 0; i < hoeken; i++) {
                pilot.travel(lengteZijde, false);
                pilot.rotate((360.0f / hoeken), false);
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
