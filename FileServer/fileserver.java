import java.io.*;
import java.net.*;

class fileserver{
	public static void main(String args[]){
		System.out.print("\nFile Server Started at port 1234!..........\n");
		try{
			Socket tsoc;
			ServerSocket ss = new ServerSocket(1234);
			while(true){
				tsoc = ss.accept();
				System.out.println("Connection Detected!.....");
				new rhandler(tsoc);
			}
		}
		catch(Exception e){
			System.out.println("\nError!....\n");
		}
	}
}

class rhandler implements Runnable{
	Socket s2;
	public Thread t1;
	InputStream i1;
	OutputStream o1;
 	rhandler(Socket s1) throws Exception{
		this.s2 = s1;
		t1 = new Thread(this,"clientHandler");
		i1 = s1.getInputStream();
		o1 = s1.getOutputStream();
		t1.start();
	}
	public void run(){
		try{
		int i,flag=0;
		File cfile;
		cfile=null;
		Long pid = Long.parseLong(java.lang.management.ManagementFactory.getRuntimeMXBean().getName().split("@")[0]);
		byte bfilename[] = new byte[i1.available()];
		i1.read(bfilename);
		String filename = new String(bfilename);
		File asset = new File("assets");
		String ls[] = asset.list();
		for(i=0;i<ls.length;++i){
			cfile = new File("assets/"+ls[i]);
			if(filename.compareTo(cfile.getName())==0){
				flag=1;
				break;
			}
		}
		if(flag==0){
			String msg="\nPID : "+pid+", File Not Found!.......";
			byte res[] = msg.getBytes();
			o1.write(res);
			String msg2="  ";
			byte res2[] = msg2.getBytes();
			o1.write(res2);
			o1.close();
		}
		else{
			String msg="\nPID : "+pid+", File Found!.......\nFile Contents:-\n";
			byte res[] = msg.getBytes();
			o1.write(res);
			//---------------------------------------------------------------------------------------------------------
			FileInputStream fin = new FileInputStream(cfile);
			byte res2[] = new byte[fin.available()];
			fin.read(res2);
			o1.write(res2);
			o1.close();
			fin.close();
			//---------------------------------------------------------------------------------------------------------
		}
	}catch(Exception e){
		System.out.println("Error Handling!.....");
	}
	}
}
