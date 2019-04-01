import java.io.*;
import java.net.*;
import java.util.*;

class Server{
	public static ArrayList<Socket> clientlist = new ArrayList<Socket>();

	public static void main(String args[]){
		try{
			Scanner sc1 = new Scanner(System.in);
			ServerSocket ser1 = new ServerSocket(1234);
			System.out.println("\033[31mServer Online and Listening to Clients!........\033[0m");
			ServerMessage sm = new ServerMessage();
			while(true)
			{
				try{
					Socket snew = ser1.accept();
					clientlist.add(snew);
					new ClientThread(snew);
				}catch(Exception e){
					;
				}
			}
		}
		catch(Exception e){
			System.out.println("<--------------------------Error------------------------>"); 
		}
	}
}
//---------------------------------------------------------------------------------------------------------------------------
class ServerMessage implements Runnable{
	public Thread Tid;
	int k;
	OutputStream o1;
	Socket stmp2;
	ServerMessage(){
		Tid = new Thread(this,"SH");
		System.out.println("\033[31mEnter the Message and Type ENTER to chat to Clients\033[0m");
		Tid.start();
	}
	public void run(){
		Scanner sc2 = new Scanner(System.in);
		while(true){
			try{
				String msg5 = sc2.nextLine();
				msg5="Server : "+msg5;
				byte msg5b[] = msg5.getBytes();
				for(k=0;k<Server.clientlist.size();++k)
				{
					try{
						stmp2=Server.clientlist.get(k);
						o1=stmp2.getOutputStream();
						o1.write(msg5b);
						o1.flush();
					}catch(Exception e){
						;
					}
				}
			}catch(Exception e){
					;
			}
		}
	}
}
//---------------------------------------------------------------------------------------------------------------------------
class ClientThread implements Runnable{
	public Socket stmp,stmp2;
	public InputStream i1;
	OutputStream o1;
	int cnum,k;
	public Thread Tid;
	
	ClientThread(Socket t1){
		stmp=t1;
		try{
			i1=t1.getInputStream();
                	cnum=Server.clientlist.size()-1;
			Tid = new Thread(this,"CHandler");
			System.out.println("\033[31mClient "+(cnum+1)+" Connected!.......\033[0m");
			Tid.start();
		}catch(Exception e){
			;
		}
	}
	
	public void run(){
		try{
			while(true)
			{
				for(k=0;k<1000;++k);
				if(i1.available()>0)
				{
					byte msg1b[] = new byte[i1.available()];
					i1.read(msg1b);
					String msg1 = new String(msg1b);
					//----------------------------------------------------
					msg1 = "Client "+(cnum+1)+" : "+msg1;
					msg1b = msg1.getBytes();
					//----------------------------------------------------
					System.out.println("\033[33m"+msg1+"\033[0m");
					for(k=0;k<Server.clientlist.size();++k)
					{
						if(k!=cnum){
							try{
								stmp2=Server.clientlist.get(k);
								o1=stmp2.getOutputStream();
								o1.write(msg1b);
								o1.flush();
							}catch(Exception e){
								;
							}
						}
					}
				}
			}
		}catch(Exception e){
			System.out.println("Client "+(cnum+1)+" Disconnected!.......");
		}
	}
}
