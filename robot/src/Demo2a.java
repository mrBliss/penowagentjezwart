/**
 * De robot moet over een afstand van minstens 2 meter een lijn die op de grond
 * met tape is aangebracht kunnen volgen. De lijn mag een willekeurige curve
 * beschrijven, maar moet minstens enkele rechthoekige bochten van 90 graden
 * bevatten. Voornaamste doelstelling is om te laten zien dat je de
 * grijswaardesensor kan gebruiken en integreren in de navigatie van de robot.
 * 
 * @author s0202013
 * 
 */
import lejos.nxt.*;
import lejos.robotics.subsumption.*;
import lejos.robotics.navigation.*;

public class Demo2a {
	
	public static final float WHEEL_DIAMETER = 56.0f;
    public static final float TRACK_WIDTH = 112.0f;
    
    public static final int LIGHT_TRESHOLD = 50;


	public static void main(String[] aArg) throws Exception {
		// Change last parameter of Pilot to specify on which
		// direction you want to be "forward" for your vehicle.
		// The wheel and axle dimension parameters should be
		// set for your robot, but are not critical.
		final Pilot pilot = new TachoPilot(WHEEL_DIAMETER, TRACK_WIDTH, Motor.A,
                Motor.B);
		final LightSensor light = new LightSensor(SensorPort.S1);
		pilot.setTurnSpeed(90);
		pilot.setMoveSpeed(180);
		/**
		 * this behavior wants to take control when the light sensor sees the
		 * line
		 */
		Behavior DriveForward = new Behavior() {
			public boolean takeControl() {
				return light.readValue() <= LIGHT_TRESHOLD;
			}

			public void suppress() {
				pilot.stop();
			}

			public void action() {
				pilot.forward();
				while (light.readValue() <= LIGHT_TRESHOLD)
					Thread.yield(); // action complete when not on line
			}
		};
		
		Behavior OffLine = new Behavior() {
			private boolean suppress = false;

			public boolean takeControl() {
				return light.readValue() > LIGHT_TRESHOLD;
			}

			public void suppress() {
				suppress = true;
			}
			
			private boolean links = true;
			
			public void action() {
				
				// Methode 1
				int sweep = 10;
				while (!suppress) {
					pilot.rotate((links ? sweep : -sweep), true);
					links = !links;
					while (!suppress && pilot.isMoving()) Thread.yield();
					sweep += 10;
				}
				
				pilot.stop();
				suppress = false;
			}
		};

		Behavior[] bArray = { OffLine, DriveForward };
		LCD.drawString("Line ", 0, 1);
		Button.waitForPress();
		(new Arbitrator(bArray)).start();
	}

}
