

import lejos.nxt.Button;
import lejos.nxt.Motor;
import lejos.robotics.navigation.TachoPilot;

public class WheelDiameter {
    public static final float WHEEL_DIAMETER = 55.23f;
    public static final float TRACK_WIDTH = 112.0f;

    TachoPilot pilot;

    public void go() {
        while (true) {
//            ButtonCounter bc = new ButtonCounter();
//            bc.count("Rotations");
            pilot.setMoveSpeed(180);
            int hoek = 30;
            
            pilot.reset();
            pilot.travel(hoek * WHEEL_DIAMETER);
            
            System.out.println("dist = " + pilot.getTravelDistance());
            Button.waitForPress();
        }
    }

    public static void main(String[] args) {
        WheelDiameter traveler = new WheelDiameter();
        traveler.pilot = new TachoPilot(WHEEL_DIAMETER, TRACK_WIDTH, Motor.A,
                                        Motor.B);
        traveler.go();
    }
}
