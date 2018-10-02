package com.yelpcamp.webserver.core;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * The main class of the WebServer
 * @author Bohao Li
 *
 */
public class WebServer {
	private ServerSocket server;
	/**
	 * Initialization of WebServer
	 */
	public WebServer() {
		try {
			System.out.println("Server is starting...");
			server = new ServerSocket(8088);
			System.out.println("Server has started!");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * The method for starting the server
	 */
	public void start() {
		try {
			System.out.println("Waiting for the connection from client...");
			Socket socket = server.accept();
			System.out.println("One client has connected");
			//Start a thread to handle with the request
			ClientHandler handler = new ClientHandler(socket);
			Thread t = new Thread(handler);
			t.start();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		WebServer server = new WebServer();
		server.start();
	}

}