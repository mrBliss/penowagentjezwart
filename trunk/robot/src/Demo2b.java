import lejos.nxt.*;
//import lejos.util.ButtonCounter;

public class Demo2b {
	
	public static void main(String[] args) {
		UltrasonicSensor sonar = new UltrasonicSensor(SensorPort.S3);
		
		ButtonListener listener = new ButtonListener() {
			
			@Override
			public void buttonReleased(Button b) {
			}
			
			@Override
			public void buttonPressed(Button b) {
	            Button.waitForPress();
			}
		};
		Button.LEFT.addButtonListener(listener);
		Button.RIGHT.addButtonListener(listener);
		Button.ENTER.addButtonListener(listener);
		Button.ESCAPE.addButtonListener(listener);
		
		while (!Button.ESCAPE.isPressed()) {
		      LCD.clear();
		      Sound.pause(30);
		      //drawInt(integer om te tekenen, x breedte, y hoogte)
		      System.out.println(sonar.getDistance());
		    }

	}
}


//ButtonCounter bc = new ButtonCounter();
//bc.count("Tientallen / Eenheden?");
//int distanceFromWall = (bc.getLeftCount()*10) + bc.getRightCount();
//final int hoekSensor = blabla;
//x = d/(cos(hoekSensor))

//if(sonar.getDistance() > x*1.1){
//   //De afstand tot de muur is groter dan 1.1*x dus rijdt terug de muur tegemoet (naar links als sensor naar links gericht is)
//} else if(sonar.getDistance() < x*0.9){
//	 //De afstand tot de muur is kleiner dan 0.9*x dus rijdt terug weg van de muur (naar rechts als sensor naar links gericht is)
//}
//