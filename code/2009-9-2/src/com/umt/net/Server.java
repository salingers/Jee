package com.umt.net;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(8888);
		System.out.println("����������...");
		
		Socket s = server.accept();
		
		System.out.println("�ұ�ִ���ˡ�");
	}

}