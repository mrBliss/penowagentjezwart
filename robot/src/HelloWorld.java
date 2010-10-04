import lejos.nxt.*;
import lejos.robotics.navigation.Pilot;
import lejos.robotics.navigation.TachoPilot;

public class HelloWorld {
	  Pilot pilot;
	  TouchSensor bump = new TouchSensor(SensorPort.S1);

	  public void go() {
	    pilot.travel(20, true);
	    while (pilot.isMoving()) {
	      if (bump.isPressed()) pilot.stop();
	    }
	    System.out.println(" "+pilot.getTravelDistance());
	    Button.waitForPress();
	  }

	  public static void main(String[] args) {
		HelloWorld traveler = new HelloWorld();
	    traveler.pilot = new TachoPilot(2.25f, 5.5f, Motor.A, Motor.C);
	    traveler.go();
	  }
	}
