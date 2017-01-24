import java.util.Scanner;

//import java.util.Random;

public class algo_7_DeterministicRank {
	static int h=0;
	// partition function
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
		
		// selection sort
		static void selSort(int[] arr,int l,int h1)
		{   
             
			int n=h1+1;
			for(int i=l;i<n-1;i++)
			{
				int m=i;
				for(int j=i+1;j<n;j++)
				{
					if(arr[j]<=arr[m])
						m=j;
					// swapping of 2 element
					int temp=arr[i];
					arr[i]=arr[m];
					arr[m]=temp;
				}
			}
		}
		
		// find good pivot

		 public static int good_pivot(int[] arr,int low,int high){	
		    	int l_index=low;
		    	int h_index=low+4;
		    	
		    	if(high-low+1<5)
		    		return low+(high-low+1)/2;
		    	for(int i=0;i< Math.ceil((high-low+1)/5);i++)
		    	{	
		    		l_index=low+5*i;
		    		if(l_index>high)
		    			break;
		    		h_index=low+5*(i+1)-1;
		    		if(h_index>high)
		    			h_index=high;
		    		selSort(arr,l_index,h_index);
		    		
		    	}
		    	int mid;
		    	int temp;
		    	int count=low;
		    	
		    	int r=low+2;
		    	
		    	while(r<high){
		    		temp=arr[count];
		    		arr[count]=arr[r];
		    		arr[r]=temp;
		    		count++;
		    		
		    		r+=5;
		    	}
		    	mid=(high-low+1)/5;
		    	r=low+5*mid;
		    	
		    	if((high-low+1)%5==1){
		    		temp=arr[count];
		    		arr[count]=arr[r];
		    		arr[r]=temp;
		    		count++;
		    	}
		    	else if((high-low+1)%5!=0){
		    		temp=arr[count];
		    		arr[count]=arr[r];
		    		arr[r]=temp;
		    		count++;
		    	}
		    	
		    	return rank(arr,low,count-1,(count-low)/2);
		    }
		    
		// finding element whose rank is r
		static int rank(int[] arr,int l,int m,int r)
		{
	         if(l<m){
			int p=good_pivot(arr,l,m);
		//	int p=l;
			System.out.println(" pivot is"+p);
			
			int k=partition(arr,l,m,p);
			//out.println("k is "+k+" p is "+p);
			if(r==m-k+1) h=k;
			else if(r<m-k+1)  rank(arr,k+1,m,r);
			else  rank(arr,l,k,r-m+k);
		}
	         return h;
		}
		// printing the array
		/*	static void printArray(int[] arr)
			{
				for(int i=0;i<arr.length;i++){
					System.out.print(arr[i]+" ");
				}
				System.out.println();
			}*/
			public static void main(String args[]){
		//int arr[]={23,12,67,45,32,1,55,0,1,1,5,7,7};
		//int r=17;
				Scanner sc=new Scanner(System.in);
				System.out.println("Enter size of array");
				int n=sc.nextInt();
				System.out.println("Enter Rank");
				int r=sc.nextInt();
				int[] arr=new int[n];
				for(int i=0;i<arr.length;i++)
				{
				int	temp=(int)(Math.random()*1000);
				arr[i]=temp+i;
				}
				
				sc.close();
		if(r<1||r>arr.length)
		{
			System.out.print("element of the rank is not possible");
			System.exit(0);
		}
		//System.out.println("The given array is :");
		//printArray(arr);
		int element=rank(arr,0,arr.length-1,r);
		System.out.println("The element whose rank"+r+" "+"is"+" " + arr[element]);
			}
			static void swap(int[] arr,int i,int j)
			{
				int temp=arr[i];
				arr[i]=arr[j];
				arr[j]=temp;			
			}
			
}
