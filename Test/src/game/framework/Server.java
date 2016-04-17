package game.framework;

import java.net.Socket;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;
import java.io.PrintWriter;

public class Server {

	/*
	 * Socket Steps:
	 * 1. Open socket
	 * 2. Open input and output streams
	 * 3. Read / Write to streams
	 * 4. Close streams
	 * 5. Close socket
	 */
	
	//Properties:
	Boolean running;
	ServerSocket serverSocket;
	int port;
	ArrayList<ClientThread> clients;
	
	public Server() {
		this(14470);
	}
	
	public Server(int port){
		this.port = port;
		
		this.clients = new ArrayList<ClientThread>();
		try {
			this.serverSocket = new ServerSocket(this.port);
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.running = true;
	}
	
	public void run(){
		while(running){
			try{
				ClientThread client = new ClientThread(this.serverSocket.accept());
				client.start();
				clients.add(client);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	

	public static void main(String[] args) {
		Server s = new Server();
		s.run();
	}

	
	class ClientThread extends Thread{
		//Properties:
		Socket socket;
		Scanner in;
		PrintWriter out;
		String ID;
		
		//Methods:
		public void run(){
			while(running){
				
			}
		}
		
	}
}
