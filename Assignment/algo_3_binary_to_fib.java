import java.time.Duration;
import java.time.Instant;
import java.util.*;

public class algo_3_binary_to_fib {

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
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int y[][]={{1,0},{0,1}};
		int x[][]={{1,1},{1,0}};
	//	int arr[]={1,0,1};
		Scanner sc=new Scanner(System.in);
		System.out.println("enter size of arrray");
		int m=sc.nextInt();
		int[] arr=new int[m];
		//int[] arr=new int[n];
		for(int i=0;i<m;i++){
		 arr[i]=new Random().nextInt(2);
		}
		sc.close();
        int n=arr.length;
     /* for(int i=0;i<=n-1;i++)
      {
    	  System.out.print(arr[i]);
      }
      System.out.println("");
      */
      Instant first=Instant.now();
		for(int count=n-1;count>=0;count--)
		{
					if(arr[count]==1)
			        	mm(y,x);
			mm(x,x);
		}
		  System.out.print("Fibinocci is "+"  ");
	   System.out.println(y[1][0]);
	   Instant sec=Instant.now();
	   Duration d=Duration.between(first,sec);
	   System.out.println("Running time ");
	   System.out.println(d.getSeconds());
	   	
	}
}
