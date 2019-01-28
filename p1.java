import java.util.*;

class p1{
	public static void main(String args[])
	{
		Scanner s1 = new Scanner(System.in);
		int flag=1;
		System.out.print("Enter the String : ");
		String str = s1.nextLine();
		for(int i=0;i<str.length();++i)
		{
			if(str.charAt(i)!=' ')
				if((str.indexOf(str.charAt(i),i+1)!=-1)&&(str.indexOf(str.charAt(i))==i))
				{
					System.out.println("Character '"+str.charAt(i)+"' is duplicating");
					flag=0;
				}
		}
		if(flag==1)
			System.out.println("No duplicate Characters Found!.....");
	}
}
