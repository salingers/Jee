package com.umt.net;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {
	
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(8888);
			
			Socket s = server.accept();
			
			if(s != null){
				InputStream in = s.getInputStream();
				byte[] msg = new byte[1024];
				in.read(msg);
				
				System.out.println(new String(msg).trim());
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
