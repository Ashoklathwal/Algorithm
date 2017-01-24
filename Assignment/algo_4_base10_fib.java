import java.time.Duration;
import java.time.Instant;
import java.util.*;

public class algo_4_base10_fib 
{
	static void mm(int y[][],int x[][])
	{
	int a=y[0][0]*x[0][0]+y[0][1]*x[1][0];
				int b=y[0][0]*x[0][1]+y[0][1]*x[1][1];
				int c=y[1][0]*x[0][0]+y[1][1]*x[1][0];
				int d=y[1][0]*x[0][1]+y[1][1]*x[1][1];
				y[0][0]=a%100;
				y[0][1]=b%100;
				y[1][0]=c%100;
				y[1][1]=d%100;
	}
	public static void main(String args[])
	{
		int y[][]={{1,0},{0,1}};
		int b[][]={{1,0},{0,1}};
		int x[][]={{1,1},{1,0}};
		//int[] arr=new int[100000];
		//int n=12;
		Scanner sc=new Scanner(System.in);
		System.out.println("enter size of arrray");
		int n=sc.nextInt();
		int[] arr=new int[n];
		for(int i=0;i<n;i++)
		{
			arr[i]=new Random().nextInt(10);
		}
		sc.close();
		int j=arr.length-1; 
		 Instant first=Instant.now();
		while(j>=0){
		for(int i=0;i<arr[j];i++)
		{
			
		mm(y,x);
		
	    }
		mm(x,x);
		mm(b,x);
		mm(x,x);
		mm(x,x);
		mm(x,b);
		b[0][0]=1;
		b[0][1]=0;
		b[1][0]=0;
		b[1][1]=1;
		//n=n/10;
		j--;
  }
  System.out.println(y[1][0]);
  Instant sec=Instant.now();
  Duration d=Duration.between(first,sec);
  System.out.println("Running time ");
  System.out.println(d.getSeconds());
}

}
