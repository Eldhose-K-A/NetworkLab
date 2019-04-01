import java.net.*;
import java.io.*;
import java.util.*;

class Client{
	public static void main(String args[]){
		try{
			Scanner sca1 = new Scanner(System.in);
			DatagramSocket ds1 = new DatagramSocket();
			while(true)
			{
				byte receivemsg[] = new byte[1024];
				byte sendmsg[];

				InetAddress ip = InetAddress.getByName("localhost");
				int port = 7222;

				System.out.print("Data To Send : ");
				String s2 = sca1.nextLine();
				sendmsg = s2.getBytes();

				DatagramPacket dp2 = new DatagramPacket(sendmsg,sendmsg.length,ip,port);
				ds1.send(dp2);

				DatagramPacket dp1 = new DatagramPacket(receivemsg,receivemsg.length);
				ds1.receive(dp1);

				String msgr = new String(dp1.getData());
				System.out.println("\nData Received : "+msgr);
			}
		} catch(Exception e){
			System.out.println("Error Encountered!....");
		}
	}
}
