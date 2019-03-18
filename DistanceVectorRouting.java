import java.util.*;

class DAlgio{
	public static void main(String args[]){
		Scanner s1 = new Scanner(System.in);
		System.out.println("Enter the No of Routers : ");
		int mr=s1.nextInt();
		int arr[] = new int[mr*mr];
		int org[] = new int[mr*mr];
		int newarr[] = new int[mr*mr];
		int path[] = new int[mr*mr];
		int i=0,j=0,k=0,g=0,h=0;
		System.out.println("Enter the initial hops(200 for Infinite) : ");
		for(i=0;i<mr;++i)
		{
			for(k=0;k<mr;++k)
			{
				arr[i*mr+k]=s1.nextInt();
				org[i*mr+k]=arr[i*mr+k];
				newarr[i*mr+k]=arr[i*mr+k];
				path[i*mr+k]=k;
			}
		}
		do{
		for(i=0;i<mr;++i)
		{
			for(k=0;k<mr;++k)
			{
				arr[i*mr+k]=org[i*mr+k];
				newarr[i*mr+k]=arr[i*mr+k];
				path[i*mr+k]=k;
			}
		}
		for(i=0;i<(mr-1);++i)
		{
			for(g=0;g<mr;++g)
			{
				for(h=0;h<mr;++h)
				{
					arr[g*mr+h]=newarr[g*mr+h];
				}
			}
			for(k=0;k<mr;++k)
			{
				for(j=0;j<mr;++j)
				{
					for(g=0;g<mr;++g)
					{
						if(newarr[k*mr+j]>(arr[k*mr+g]+arr[g*mr+j]))
						{
							newarr[k*mr+j]=arr[k*mr+g]+arr[g*mr+j];
							path[k*mr+j]=g;
						}
					}
				}
			}
		}
		//--------------------------------------------------------------------------------------------------
		System.out.print("\n\nFinal Routing Table\n");
		System.out.printf("|  |");
		for(i=0;i<mr;++i){ System.out.printf("%6d|",i+1);}
		System.out.print("\n");
		System.out.print("----------------------------------------------------------------------\n");
		for(g=0;g<mr;++g)
		{
			System.out.printf("|%2d|",g+1);
			for(h=0;h<mr;++h)
			{
				System.out.printf("%2d(%2d)|",newarr[g*mr+h],(path[g*mr+h]+1));
			}
			System.out.print("\n");
		}
		//-------------------------------------------------------------------------------------------------
		System.out.print("\nMain Menu\n1.Change Distance\n2.Exit\nYour Choice : ");
		int op=s1.nextInt();
		if(op==1)
		{
			System.out.printf("Enter Source Node : ");
			g=s1.nextInt();
			System.out.printf("Enter Destination Node : ");
			h=s1.nextInt();
			g=g-1;
			h=h-1;
			System.out.printf("Enter Distance : ");
			k=s1.nextInt();
			org[g*mr+h]=k;
			org[h*mr+g]=k;
		}
		else if(op==2)
			return;
		else
			System.out.print("\nInvalid Choice!.....");
		}while(true);
	}
}
