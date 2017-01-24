import java.time.Duration;
import java.time.Instant;
import java.util.Random;
import java.util.Scanner;

public class algo_6_simpleRank {
	// partition function
		static int partition(int[] arr,int a,int b,int p)
		{
			int q=arr[p];
			//out.println("pivot is "+q+" p is "+p+" b is "+b);
			swap(arr,p,b);
			//for(int ele:arr)
				//out.print(ele+" ");
			q=arr[b];
			int j=a;
			int i=j-1;
			for(j=a;j<b;j++){
			if(arr[j]<=q)
			{
				i++;
				//out.println("i is "+i+" j is "+j);
				swap(arr,i,j);
				//j++;
			}}
			//if(i<arr.length)i--;
			swap(arr,i+1,b);
			//out.println("swapped array is ");
			//for(int ele:arr)
				//out.print(ele+" ");
			
			return i+1;
		}
		
		// find random pivot
		static int randomPivot(int[] arr, int i,int j)
		{
			int n=(j-i+1);
			int q=new Random().nextInt(n);
			return q;
		}
		
		// finding element whose rank is r
		static int rank(int[] arr,int l,int m,int r)
		{
			//int p=randomPivot(arr,l,m);
			int p=l;
			//System.out.println(" pivot is"+p);
			
			int k=partition(arr,l,m,p);
			//out.println("k is "+k+" p is "+p);
			if(r==m-k+1) return k;
			else if(r<m-k+1) return rank(arr,k+1,m,r);
			else return rank(arr,l,k,r-m+k);
		}
		// printing the array
			static void printArray(int[] arr)
			{
				for(int i=0;i<arr.length;i++){
					System.out.print(arr[i]+" ");
				}
				System.out.println();
			}
			public static void main(String args[])
			{
		      //int arr[]={23,12,67,45,32,1,55,78,0,-1};
		      //int r=7;
				Scanner sc=new Scanner(System.in);
				System.out.println("Enter size of array");
				int n=sc.nextInt();
				System.out.println("Enter Rank");
				int r=sc.nextInt();
				int[] arr=new int[n];
				for(int i=0;i<arr.length;i++)
				{
				int	temp=(int)(Math.random()*10000000);
				arr[i]=temp+i;
				}
				
		if(r<1||r>arr.length)
		{
			System.out.print("rank is not possible");
			System.exit(0);
		}
		//System.out.println("The given array is :");
		//printArray(arr);
		sc.close();
		Instant first=Instant.now();
		int element=rank(arr,0,arr.length-1,r);
		System.out.println("The element whose rank "+r+" "+"is"+" " + arr[element]);
		Instant sec=Instant.now();
		  Duration d=Duration.between(first,sec);
		  System.out.println("Running time ");
		  System.out.println(d.getSeconds());
			}
			static void swap(int[] arr,int i,int j)
			{
				int temp=arr[i];
				arr[i]=arr[j];
				arr[j]=temp;			
			}

}
