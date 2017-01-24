//import java.io.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Duration;
import java.time.Instant;
//import java.util.Random;
//import java.util.*;

public class binary_heap1st {
	// building max heap
	static void build_maxheap(int[] arr,int i)
	{
		int temp;
		while(i>0 && arr[(i-1)/2]<arr[i])
		{
			temp=arr[(i-1)/2];
			arr[(i-1)/2]=arr[i];
			arr[i]=temp;
			i=(i-1)/2;
		}
	}
	// calling top down heapify for making correct max heap
	static void top_down_heapify(int[]arr)
	{
		int l,m,r,temp;
		int i=0;
		while((2*i+1)<arr.length)
		{
			l=2*i+1;
			r=2*i+2;
		
		if(r<arr.length && arr[l]<arr[r])
		
			m=r;
	     else
		    m=l;
		if(arr[i]<arr[m])
		{
			temp=arr[i];
			arr[i]=arr[m];
			arr[m]=temp;
			i=m;
		}
		else
			i=arr.length;
		
	  }
	}
	public static void main(String[] args) throws IOException
	{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter size of array");
		int n=Integer.parseInt(bf.readLine());
		System.out.println("Enter value of k");
		int k=Integer.parseInt(bf.readLine());
		int[] arr=new int[k];
		Instant first=Instant.now();
		for(int i=0;i<arr.length;i++)
		{
		int	temp=(int)(Math.random()*1000);
		arr[i]=temp+i;
		build_maxheap(arr,i);
		}
		/*for(int i=0;i<k;i++)
		{
			//arr[i]=new Random().nextInt(100);
			arr[i]=Integer.parseInt(bf.readLine());
			build_maxheap(arr,i);
		}
		*/
		for(int i=k;i<n;i++)
		{
			int x;
			int	temp=(int)(Math.random()*1000);
			x=temp+i;
			//x=new Random().nextInt(100);
		//	x=Integer.parseInt(bf.readLine());
			if(arr[0]>x)
			{
				arr[0]=x;
				top_down_heapify(arr);
				
			}
		}
		for(int m:arr)
			System.out.print(m+" ");
		System.out.println("");
		   Instant sec=Instant.now();
		   Duration d=Duration.between(first,sec);
		   System.out.println("Running time ");
		   System.out.println(d.getSeconds());

	}

}
