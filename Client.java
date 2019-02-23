import java.io.*;
import java.net.*;
import java.util.*;

class Client{
        public static Socket scl;
	public static void main(String args[]){
		try{
		 	Scanner sc1 = new Scanner(System.in);
			//System.out.print("\nEnter Client Name : ");
			//String cname = sc1.nextLine();
			scl = new Socket("127.0.0.1",1234);
			InputStream i1 = scl.getInputStream();
			OutputStream o1 = scl.getOutputStream();

			new ListeningThread(i1);
			
			System.out.println("Enter the Message and Type ENTER to chat");
			while(true){
				String msg2 = sc1.nextLine();
				//msg2=cname+" : "+msg2;
				byte msg2b[] = msg2.getBytes();
				o1.write(msg2b);
				o1.flush();
			}
		}catch(Exception e){
			System.out.println("Error");
		}
	}
}

class ListeningThread implements Runnable{
	public Thread Tid;
	InputStream il1;
	int k;
	ListeningThread(InputStream it){
		il1=it;
		Tid = new Thread(this,"L1");
		System.out.println("Client is Listening!.............");
		Tid.start();
	}
	public void run(){
		while(true){
			for(k=0;k<1000;++k);
			try{
				if(il1.available()>0){
					byte msg3b[] = new byte[il1.available()];
					il1.read(msg3b);
					String msg3 = new String(msg3b);
					System.out.println(msg3);
				}
			}catch(Exception e){
				;
			}
		}
	}
}
