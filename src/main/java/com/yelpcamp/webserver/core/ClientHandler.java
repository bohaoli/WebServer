package com.yelpcamp.webserver.core;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * Handle with requests from client
 * @author Bohao Li
 *
 */
public class ClientHandler implements Runnable{
	private Socket socket;
	
	public ClientHandler(Socket socket) {
		this.socket = socket;
	}
	public void run() {
		try {
			InputStream in = socket.getInputStream();
			int d = -1;
			while((d = in.read())!=-1) {
				System.out.print((char)d);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			//Handle with disconnection
			try {
				socket.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}

}