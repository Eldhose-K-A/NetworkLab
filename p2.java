import java.util.*;

class p2{
	public static void main(String args[])
	{
		Scanner s1 = new Scanner(System.in);
		System.out.println("Enter the String : ");
		String str = s1.nextLine();
		String sr[] = str.split(" ");
		for(int i=0;i<sr.length;++i)
		{
			StringBuffer sb = new StringBuffer(sr[i]);
			System.out.print(sb.reverse()+" ");
		}
		System.out.println();
	}
}
