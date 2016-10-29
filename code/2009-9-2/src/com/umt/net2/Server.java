package com.umt.net2;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(8888);
		System.out.println("服务器启动...");
		
		Socket s = server.accept();
		
		String str = "HelloWorld";
		
		if(s != null){
			//创建输出流,向客户端发送信息
			OutputStream out = s.getOutputStream();
			
			out.write(str.getBytes());
			out.flush();
			
			out.close();
		}
	}

}
