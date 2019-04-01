import java.io.*;
import java.net.*;
import java.util.*;

class fileclient{
	public static void main(String args[]){
		try{
			Scanner sc = new Scanner(System.in);
			System.out.print("\nEnter the File Name : ");
			String fname = sc.nextLine();
			Socket s1 = new Socket("127.0.0.1",1234);
			InputStream i1 = s1.getInputStream();
			OutputStream o1 = s1.getOutputStream();
			int flag=0;
			byte req[] = fname.getBytes();
			o1.write(req);
			System.out.println("---------------------------------\nFile Requested!......\n---------------------------------");
			while(i1.available()<=0);
			byte msginput1[] = new byte[i1.available()];
			i1.read(msginput1);
			String m1 = new String(msginput1);
			System.out.print("\n"+m1);
			while(i1.available()<=0);
			byte msginput2[] = new byte[i1.available()];
			i1.read(msginput2);
			String m2 = new String(msginput2);
			System.out.print("\n"+m2);
			i1.close();
			o1.close();
			s1.close();
			
		}catch(Exception e){
			System.out.println("Error!.......");
		}
	}
}
