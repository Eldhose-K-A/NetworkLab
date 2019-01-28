import java.util.*;

class p4{
	public static void main(String args[])
	{
		
		String str = "Hello world this is a program";
		String sr[] = str.split(" ");
		for(int i=0;i<sr.length;++i)
		{
			StringBuffer sb = new StringBuffer(sr[i]);
			System.out.print(sb.reverse()+" ");
		}
		System.out.println();
	}
}
