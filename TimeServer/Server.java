import java.net.*;
import java.io.*;
import java.util.*;

class Server{
	public static void main(String args[]){
		try{
			DatagramSocket ds1 = new DatagramSocket(7222);
			//Scanner sc1 = new Scanner(System.in);

			while(true)
			{
				byte receivemsg[] = new byte[1024];
				byte sendmsg[];

				DatagramPacket dp1 = new DatagramPacket(receivemsg,receivemsg.length);
				ds1.receive(dp1);

				String msgr = new String(dp1.getData());
				System.out.println("\nData Received : "+msgr);

				InetAddress ip = dp1.getAddress();
				int port = dp1.getPort();

				String s2 = new Date().toString();
				sendmsg = s2.getBytes();

				DatagramPacket dp2 = new DatagramPacket(sendmsg,sendmsg.length,ip,port);
				ds1.send(dp2);
				
				System.out.println("\nTime Send");
			}
		} catch(Exception e){
			System.out.println("Error Encountered!....");
		}
	}
}
