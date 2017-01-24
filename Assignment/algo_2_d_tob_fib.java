import java.time.Duration;
import java.time.Instant;
import java.util.Random;
import java.util.Scanner;

// convert decimal to binary then find fibinocci
public class algo_2_d_tob_fib {
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
	static int divide(int arr[],int j,int count)
	{
		int x,y=0,count1=0;
		if(count==1)
		{
			arr[0]=arr[0]/2;
			if(arr[0]>0)
				return 1; 
			return 0;
		}
		  x=arr[0];
		  j=1;
		  
		// count1 counting the num of digits
		while(j<=count)
		{
			if(x/2==0&&count1==0)
			  ;
			else if(x/2!=0||count1!=0)
				arr[count1++]=x/2;
			y=x%2;
			if(j<count)
			x=y*10+arr[j];
			j++;
			
		}
		
	return count1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int y[][]={{1,0},{0,1}};
		int x[][]={{1,1},{1,0}};
		//int arr[]={1,2,1};
		Scanner sc=new Scanner(System.in);
		System.out.println("enter size of arrray");
		int n=sc.nextInt();
		int[] arr=new int[n];
		for(int i=0;i<n;i++)
		{
			arr[i]=new Random().nextInt(10);
			
		}
		int b[]=new int[4*n];
        int count=arr.length;
        int j=0;
        sc.close();
        Instant first=Instant.now();
		while(count>0)
		{
			if(arr[count-1]%2==1)
			     b[j++]=1;
			else b[j++]=0;
			count=	divide(arr,0,count); 
		
		}
		for(int i=j-1;i>=0;i--)
			System.out.print(b[i]);
 
		for(count=0;count<j;count++)
		{
					if(b[count]==1)
			        	mm(y,x);
			mm(x,x);
		}
		  System.out.print("Fibinocci of is "+"  ");
	   System.out.println(y[1][0]);
	   Instant sec=Instant.now();
	   Duration d=Duration.between(first,sec);
	   System.out.println("Running time ");
	   System.out.println(d.getSeconds());
	   	
	}
}