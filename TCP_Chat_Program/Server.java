import java.io.*; 
import java.util.*; 
import java.net.*;     
   
class Server  
{ 
  
	public static ArrayList<Socket> clientlist = new ArrayList<Socket>();
  
    public static void main(String[] args) throws IOException  
    { 
        ServerSocket ss = new ServerSocket(1234);           
        Socket s; 
		
		InputHandler ih1 = new InputHandler();
		
        while (true)  
        { 
			try{
            s = ss.accept(); 
            System.out.println("New client request received : " + s);      
            System.out.println("Updating the Client List");
			clientlist.add(s);
			System.out.println("Client Count Now : "+clientlist.size());
		
			}catch(Exception e){
				System.out.println("<--------------------------Error-------------------------->");
			}
        } 
    } 
} 

class InputHandler implements Runnable{
	public Thread t1;
	Socket stmp,stmp2;
	OutputStream o1;
	InputStream i1;
	int i;
	int k=-1;
	int j;
	InputHandler(){
		t1 = new Thread(this,"inputHandler01");
		System.out.println("Started Listening to Clients!.......");
		t1.start();
	}
	public void run()
	{
		while(true){
			for(k=0;k<1000;++k);
			for(i=0;i<Server.clientlist.size();++i){
				try{
					stmp=Server.clientlist.get(i);
					i1=stmp.getInputStream();
					if(i1.available()>0)
					{
						byte msgin[] = new byte[i1.available()];
						i1.read(msgin);
						String msgins = new String(msgin);
						System.out.println("Client "+i+" : "+msgins);
				        for(j=0;j<Server.clientlist.size();++j){
							if(i!=j){
								try{
									stmp2=Server.clientlist.get(j);
									o1=stmp2.getOutputStream();
									o1.write(msgin);
									o1.flush();
								}catch(Exception e){
									;//System.out.println("Connection Lost!....");
								}
							}
						}
					}
				}
				catch(Exception e){
					System.out.println("Connection Error!....................................");
				}
			}
		}
	}
}