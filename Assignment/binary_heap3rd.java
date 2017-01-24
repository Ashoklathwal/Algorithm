import java.io.*;
import java.time.Duration;
import java.time.Instant;
import java.util.Random;

public class binary_heap3rd {
	// find element whose rank is k 
		static int partition(int[] arr,int a,int b,int p)
		{
			int q=arr[p];
			swap(arr,p,b);
					q=arr[b];
			int j=a;
			int i=j-1;
			for(j=a;j<b;j++){
			if(arr[j]<=q)
			{
				i++;
						swap(arr,i,j);
					}}
				swap(arr,i+1,b);
					return i+1;
		}
		static void swap(int[] arr,int i,int j)
		{
			int temp=arr[i];
			arr[i]=arr[j];
			arr[j]=temp;			
		}
		
		// find random pivot
		/*static int randomPivot(int[] arr, int i,int j)
		{
			int n=(j-i+1);
			int q=new Random().nextInt(n);
			return q;
		}*/
		
		// finding element whose rank is r
		static void rank(int[] arr,int l,int m,int r)
		{
			//int p=randomPivot(arr,l,m);
			int p=l;
					int k=partition(arr,l,m,p);
				if(r==m-k+1) return ;
			else if(r<m-k+1)  rank(arr,k+1,m,r);
			else rank(arr,l,k,r-m+k);
		}


	public static void main(String[] args) throws IOException
	{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter size of array");
		int n=Integer.parseInt(bf.readLine());
		System.out.println("Enter value of k");
		int kth=Integer.parseInt(bf.readLine());
		int[] arr=new int[2*kth];
		int i=0;
		Instant first=Instant.now();
		for(i=0;i<arr.length;i++)
		{
		int	temp=(int)(Math.random()*1000);
		arr[i]=temp+i;
		}
		// call rank function
		int x=0;
		
		while(i<n)
		{
			int pivot;
			while(x<kth)
			{
				pivot=new Random().nextInt(2*kth);
				 x=partition(arr,0,arr.length-1,pivot);
			}
		for(int j=x;j<2*kth&&i<n;j++)
		{
			int	temp=(int)(Math.random()*1000);
			arr[j]=temp+i;
			//arr[j]=Integer.parseInt(bf.readLine());	
			i++;
		}
		//partition(arr,0,arr.length-1,pivot);
		
		}
		rank(arr,0,arr.length-1,kth);
		for(int j=0;j<kth;j++)
			System.out.print(arr[j]+" ");
		Instant sec=Instant.now();
		   Duration d=Duration.between(first,sec);
		   System.out.println("Running time ");
		   System.out.println(d.getSeconds());
		}

	}

