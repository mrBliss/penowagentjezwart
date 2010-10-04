package pc;

import lejos.pc.comm.NXTComm;
import lejos.pc.comm.NXTCommException;
import lejos.pc.comm.NXTCommFactory;
import lejos.pc.comm.NXTInfo;

public class ConnectionDemo {
	public static void main(String[] args) {
		NXTComm nxtComm = null;
		try {
			nxtComm = NXTCommFactory.createNXTComm(NXTCommFactory.BLUETOOTH);
		} catch (NXTCommException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		NXTInfo[] nxtInfo = null;
		try {
			nxtInfo = nxtComm.search(null,NXTCommFactory.BLUETOOTH);
		} catch (NXTCommException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(NXTInfo info: nxtInfo)
			System.out.println(info.name);
	}
}
