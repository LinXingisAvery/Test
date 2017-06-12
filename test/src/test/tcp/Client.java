package test.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	Socket client;
	public Client(){
		try {
			client=new Socket("localhost",8088);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private class ServerHandler implements Runnable{
		@Override
		public void run() {
			InputStream is;
			try {
				is = client.getInputStream();
				InputStreamReader isr=new InputStreamReader(is,"utf-8");
				BufferedReader br=new BufferedReader(isr);
				while(true){
					String message=br.readLine();
					System.out.println(message);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	public void start(){
		Scanner scan=new Scanner(System.in);
		try {
			Thread t=new Thread(new ServerHandler());
			t.setDaemon(true);
			t.start();
			OutputStream os=client.getOutputStream();
			OutputStreamWriter osw=new OutputStreamWriter(os,"utf-8");
			PrintWriter pw=new PrintWriter(osw,true);
			while(true)
			pw.println(scan.next());
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			scan.close();
		}
	}
	public static void main(String[] args) {
		Client client=new Client();
		client.start();
	}
}
