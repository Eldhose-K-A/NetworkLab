import java.util.*;

class p3{
	public static void main(String args[])
	{
		int i,j,tmp;
		Scanner s1 = new Scanner(System.in);
		System.out.println("Enter the size : ");
		int n = s1.nextInt();
		int ar[] = new int[n];
		System.out.print("Enter the elements : ");
		for(i=0;i<n;++i)
			ar[i]=s1.nextInt();
		for(i=0;i<(n-1);++i)
			for(j=0;j<(n-1-i);++j)
				if(ar[j]>ar[j+1])
				{
					tmp=ar[j];
					ar[j]=ar[j+1];
					ar[j+1]=tmp;
				}
		System.out.print("Enter order : (1).Ascending (2).Descending Choice : ");
		int ch = s1.nextInt();
		if(ch==1)
		{
			for(i=0;i<n;++i)
				System.out.print(ar[i]+" ");
		}
		else if(ch==2)
		{
			for(i=n-1;i>=0;--i)
				System.out.print(ar[i]+" ");
		}
		System.out.println();
	}
}
