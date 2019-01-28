import java.util.*;

class p5{
	public static void main(String args[])
	{
		Scanner s1 = new Scanner(System.in);
		int flag=1,k,l;
		System.out.print("Enter the String : ");
		String str = s1.nextLine();
		for(int i=0;i<str.length();++i)
		{
			if(str.charAt(i)!=' ')
				if((str.indexOf(str.charAt(i),i+1)!=-1)&&(str.indexOf(str.charAt(i))==i))
				{
					System.out.print("Character '"+str.charAt(i)+"' is duplicating");
					k=str.indexOf(str.charAt(i));
					l=1;
					while(str.indexOf(str.charAt(i),k+1)!=-1)
					{
						k=str.indexOf(str.charAt(i),k+1);
						l++;
					}
					System.out.println(", Count : "+l);
					flag=0;
				}
		}
		if(flag==1)
			System.out.println("No duplicate Characters Found!.....");
	}
}
