import java.time.Duration;
import java.time.Instant;
import java.util.*;

public class algo_5_fib_perodic_seq {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		// size of arr
		//int n=sc.nextInt();
		//int[] arr=new int[1000000];
		//Scanner sc=new Scanner(System.in);
		System.out.println("enter size of arrray");
		int n=sc.nextInt();
		int[] arr=new int[n];
		for(int i=0;i<n;i++)
		{
			arr[i]=new Random().nextInt(10);
			
		}
		System.out.println("Enter the value of m");
	int m=sc.nextInt();

		//int arr[]={2,5,6};
		//int n=256;
		//int m=3;
		int p=0;
		int[] arr1=new int[6*m]; 
		arr1[0]=0;
		arr1[1]=1;
		Instant first=Instant.now();
		for(int i=2;i<6*m;i++)
		{
			arr1[i]=(arr1[i-1]+arr1[i-2])%m;
			if(arr1[i-1]==0 && arr1[i]==1)
			{
				p=i-1;
				break;
			}
		}
		sc.close();
		int n1=arr[0];
	
		int j=1;
		while(j<arr.length)
		{
			n1=n1*10+arr[j++];
			n1=n1%p;
		} 
		//int n1=n%p;
		System.out.println(arr1[n1]);
		 Instant sec=Instant.now();
		  Duration d=Duration.between(first,sec);
		  System.out.println("Running time ");
		  System.out.println(d.getSeconds());
	}

}

