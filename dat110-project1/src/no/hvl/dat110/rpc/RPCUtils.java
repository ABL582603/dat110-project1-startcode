package no.hvl.dat110.rpc;

import java.nio.ByteBuffer;
import java.util.Arrays;

import no.hvl.dat110.TODO;

public class RPCUtils {

	// Utility methods for marshalling and unmarshalling of parameters and return values
	// in RPC request and RPC responses
	// data bytearrays and return byte arrays is according to the 
	// RPC message syntax [rpcid,parameter/return value]
	
	public static byte[] marshallString(byte rpcid, String str) {

		byte[] stringArray = str.getBytes();
		byte[] encoded = new byte[stringArray.length+1];
		encoded[0] = rpcid;
		for(int i = 0; i<stringArray.length; i++) {
			encoded[i+1] = stringArray[i];
		}

		// TODO: marshall RPC identifier and string into byte array

		return encoded;
	}

	public static String unmarshallString(byte[] data) {
		
		byte[] stringArray = new byte[data.length-1];
		for(int i = 0; i<stringArray.length; i++) {
			stringArray[i] = data[i+1];
		}
		
		String decoded = new String(stringArray);

		// TODO: unmarshall String contained in data into decoded

		return decoded;
	}

	public static byte[] marshallVoid(byte rpcid) {

		byte[] encoded = new byte[1];
		encoded[0] = rpcid;

		// TODO: marshall RPC identifier in case of void type

		return encoded;

	}

	public static void unmarshallVoid(byte[] data) {

		// TODO: unmarshall void type
	}

	public static byte[] marshallBoolean(byte rpcid, boolean b) {

		byte[] encoded = new byte[2];

		encoded[0] = rpcid;

		if (b) {
			encoded[1] = 1;
		} else {
			encoded[1] = 0;
		}

		return encoded;
	}

	public static boolean unmarshallBoolean(byte[] data) {

		return (data[1] > 0);

	}

	public static byte[] marshallInteger(byte rpcid, int x) {

		byte[] encoded = new byte[5];
		encoded[0] = rpcid;
		byte[] intArray = ByteBuffer.allocate(4).putInt(x).array();
		
		for(int i = 0; i < intArray.length; i++) {
			encoded[i+1] = intArray[i];
		}

		// TODO: marshall RPC identifier and string into byte array
		
		return encoded;
	}

	public static int unmarshallInteger(byte[] data) {

		byte[] intArray = new byte[data.length-1];
		for(int i = 0; i < intArray.length; i++) {
			intArray[i] = data[i+1];
		}
		
		int decoded = ByteBuffer.wrap(intArray).getInt();

		// TODO: unmarshall integer contained in data
	
		return decoded;

	}
}
