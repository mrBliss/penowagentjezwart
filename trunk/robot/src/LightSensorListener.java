

import lejos.nxt.SensorPort;
import lejos.nxt.SensorPortListener;

public class LightSensorListener implements SensorPortListener {
	
	private static final int WHITE_LOWER = 90;
	private static final int BLACK_UPPER = 10;
	
	private boolean whiteLast;
	
	public LightSensorListener() {
		super();
		whiteLast = true;
	}

	@Override
	public void stateChanged(SensorPort port, int oldValue, int newValue) {
		if(newValue <= BLACK_UPPER) {
			
		}
	}
	
	

}
