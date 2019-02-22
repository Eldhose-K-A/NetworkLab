import java.io.*; 
import java.net.*; 
import java.util.*; 
  
public class Client  
{ 
    final static int ServerPort = 1234; 
	
    public static Socket s;
  
    public static void main(String args[])	
    { 
		try{
			Scanner scn = new Scanner(System.in);  

			System.out.println("Enter Client Name : ");
			String cname = scn.nextLine();
			
			s = new Socket("127.0.0.1", ServerPort); 
			
			System.out.println("Connection Established. Type message and press ENTER to chat");
			System.out.println("------------------------------------------------------------");
			
			DataInputStream dis = new DataInputStream(s.getInputStream()); 
			DataOutputStream dos = new DataOutputStream(s.getOutputStream());

			ClientInputHandler cih = new ClientInputHandler(dis);
			
			while(true){
				String msg1 = scn.nextLine();
				msg1=cname+" : "+msg1;
				byte msg1b[] = msg1.getBytes();
				dos.write(msg1b);
				dos.flush();
			}


			
		}catch(Exception e){
			System.out.println("<-------------------------Error----------------------------------------->");
		}
    } 
} 

class ClientInputHandler implements Runnable{
	public Thread t1;
	InputStream i1;
	int k=-1;
	ClientInputHandler(InputStream ii1){
		t1 = new Thread(this,"clientinputHandler01");
		System.out.println("Client Listening.......");
		i1=ii1;
		t1.start();
	}
	public void run()
	{
		while(true){
			for(k=0;k<1000;++k);
			try{
			if(i1.available()>0)
			{
				byte msgin[] = new byte[i1.available()];
				i1.read(msgin);
				String msgins = new String(msgin);
				System.out.println(msgins);
			}
			}catch(Exception e){
				;
			}
		}
	}
}