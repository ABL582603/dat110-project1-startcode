package no.hvl.dat110.messaging;

import java.util.Arrays;

import no.hvl.dat110.TODO;

public class Message {

	private byte[] payload;

	public Message(byte[] payload) {
		this.payload = payload; // TODO: check for length within boundary
	}

	public Message() {
		super();
	}

	public byte[] getData() {
		return this.payload; 
	}

	public byte[] encapsulate() {
		
		byte[] encoded = new byte[128];
		
		Integer payloadLength = payload.length;
		encoded[0] = payloadLength.byteValue();
		
		for (int i = 0; i<payload.length; i++) {
			encoded[i+1] = payload[i];
		}
		return encoded;
	}

	public void decapsulate(byte[] received) {

		Byte b = received[0];
		int payloadLength = b.intValue();
		payload = new byte[payloadLength];
		
		for (int i = 0; i<payloadLength; i++) {
			payload[i] = received[i+1];
		}
	}
}
