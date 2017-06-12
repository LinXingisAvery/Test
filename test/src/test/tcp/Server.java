package test.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
	ServerSocket server;
	private List<PrintWriter>allOut;
	public Server(){
		try {
			server=new ServerSocket(8088);
			allOut=new ArrayList<PrintWriter>();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private class ClientHandler implements Runnable{
		Socket socket;
		public ClientHandler(Socket socket){
			this.socket=socket;
		}
		@Override
		public void run() {
			try {
				InputStream is=socket.getInputStream();
				InputStreamReader isr=new InputStreamReader(is,"utf-8");
				BufferedReader br=new BufferedReader(isr);
				OutputStream os=socket.getOutputStream();
				OutputStreamWriter osw=new OutputStreamWriter(os,"utf-8");
				PrintWriter pw=new PrintWriter(osw,true);
				allOut.add(pw);
				int port=socket.getPort();
				while(true){
				String message=br.readLine();
				for(PrintWriter p:allOut)
				p.println("客户端"+port+":"+message);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
	}
	public void start(){
		while(true){
			try {
				System.out.println("等待连接");
				Socket s=server.accept();
				System.out.println("已连接");
				new Thread(new ClientHandler(s)).start();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
public static void main(String[] args) {
	Server server=new Server();
	server.start();
}
}
