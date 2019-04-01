import java.net.*;
import java.io.*;
import java.util.*;

class Servercode{
	public static void main(String args[]){
		try{
			ServerSocket sr1 = new ServerSocket(8080);
			Scanner sc1 = new Scanner(System.in);
			Socket s1;
			//while(true){
				s1 = sr1.accept();
				InputStream i1 = s1.getInputStream();
				OutputStream o1 = s1.getOutputStream();

				while(true){
					if(i1.available()>0){
						byte request[] = new byte[i1.available()];
						i1.read(request);
						String msgreceived = new String(request);
						System.out.println("Request : "+msgreceived);

						System.out.print("Enter Response : ");
						String msg=sc1.nextLine();
						byte msgtoserver[] = msg.getBytes();
						o1.write(msgtoserver);
						o1.flush();
						System.out.println("Response send");
					}
				}
				//bf1.close();
				//o1.close();

				//s1.close();
			//}
		}catch(Exception e){
			System.out.println("\nError Encountered!....");
		}
	}
}
