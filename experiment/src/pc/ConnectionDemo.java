package pc;

import lejos.pc.comm.NXTComm;
import lejos.pc.comm.NXTCommException;
import lejos.pc.comm.NXTCommFactory;
import lejos.pc.comm.NXTInfo;

public class ConnectionDemo {
	public static void main(String[] args) throws NXTCommException {
		NXTComm nxtComm = NXTCommFactory.createNXTComm(NXTCommFactory.BLUETOOTH);
		NXTInfo[] nxtInfo = nxtComm.search("NXT",NXTCommFactory.BLUETOOTH);
		for(NXTInfo info: nxtInfo)
			System.out.println(info.name);
	}
}
