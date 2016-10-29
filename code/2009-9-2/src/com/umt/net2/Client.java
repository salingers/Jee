package com.umt.net2;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	/**
	 * @param args
	 * @throws IOException
	 * @throws UnknownHostException
	 */
	public static void main(String[] args) throws UnknownHostException,
			IOException {
		Socket client = new Socket("192.168.1.250", 8888);

		if (client != null) {
			// 创建输入流
			
			InputStream in = client.getInputStream();
			
			int i = 0;
			while((i = in.read()) != -1){
				System.out.print((char)i);
			}
			
			in.close();
		}
	}

}
