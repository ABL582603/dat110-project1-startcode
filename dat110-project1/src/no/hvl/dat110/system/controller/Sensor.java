package no.hvl.dat110.system.controller;

import no.hvl.dat110.TODO;
import no.hvl.dat110.rpc.*;
import no.hvl.dat110.system.sensor.SensorImpl;

public class Sensor extends RPCStub {

	private byte RPCID = 1;
	
	public int read() {
		

		
		// TODO
		// implement marshalling, call and unmarshalling for read RPC method
		
		byte[] request = RPCUtils.marshallVoid(RPCID);
		
		byte[] response = rpcclient.call(request);
		
		int temp = RPCUtils.unmarshallInteger(response);
		
		return temp;
	}
	
}
