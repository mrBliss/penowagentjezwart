

import lejos.nxt.Button;
import lejos.nxt.Motor;
import lejos.robotics.navigation.TachoPilot;

public class BaseDiameter {
    public static final float WHEEL_DIAMETER = 55.23f;
    public static final float TRACK_WIDTH = 125.93f;

    TachoPilot pilot;

    public void go() {
        while (true) {
            pilot.setMoveSpeed(180);
            int hoek = 20;

            pilot.reset();
            pilot.rotate(hoek * 360f);            
            
            System.out.println("rot = " + pilot.getLeft().getTachoCount());
            Button.waitForPress();
        }
    }

    public static void main(String[] args) {
        BaseDiameter traveler = new BaseDiameter();
        traveler.pilot = new TachoPilot(WHEEL_DIAMETER, TRACK_WIDTH, Motor.A,
                                        Motor.B);
        traveler.go();
    }
}