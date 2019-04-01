import java.net.*;
import java.io.*;
import java.util.*;

class Clientcode{
	public static void main(String args[]){
		try{
		Scanner sc = new Scanner(System.in);
		Socket s1 = new Socket("127.0.0.1",8080);
		OutputStream o1 = s1.getOutputStream();
		InputStream i1 = s1.getInputStream();
		while(true){
			System.out.print("\nEnter Request : ");
			String msg = sc.nextLine();
			byte msgtoserver[] = msg.getBytes();
			o1.write(msgtoserver);
			o1.flush();
			while(i1.available()<=0);
			byte response[] = new byte[i1.available()];
			i1.read(response);
			String msgreceived = new String(response);
			System.out.println("\nResponse : "+msgreceived);
		}
		//o1.close();
		//i1.close();		
		//s1.close();
		}catch(Exception e){
			System.out.println("\nError Encountered!....");
		}
	}
}
