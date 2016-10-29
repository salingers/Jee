package com.umt.net3;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;


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
			
			//创建输出流，向服务器发送信息
			System.out.println();
			System.out.println("客户端说：");
			Scanner reader = new Scanner(System.in);
			String str = reader.nextLine();
			
			OutputStream out = client.getOutputStream();
			out.write(str.getBytes());
			
			out.flush();
			out.close();
			
		}
	}

}
