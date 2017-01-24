import java.io.*;
import java.util.Arrays;

public class subset_sum_problem 
{
	static void element_subset(boolean[][] table,int[] arr,int n,int sum)
	{
		System.out.println("The elements from which we got our sum :");
	  int i=sum,j=n;
	  while(i>0 && j>0)
	  {
		  if(table[i][j]!=table[i][j-1])
		  {
			  System.out.print(arr[j-1]+" ");
			 // if(i>0 && i-arr[j-1]>0)
			  i=i-arr[j-1];
		  }
		  else
		  {
			  j--;
		  }
	  }
	  System.out.println("");
	}
    static boolean ssp(int[] arr, int n, int sum)
    {
    	boolean[][] table=new boolean[sum+1][n+1];
    	for(int i=0;i<=sum;i++)
    		table[i][0]=false;
    	for(int i=0;i<=n;i++)
    		table[0][i]=true;
    	for(int i=1;i<=sum;i++)
    	{
    		for(int j=1;j<=n;j++)
    		{
    			table[i][j]=table[i][j-1];// if sum <element
    			if(i>=arr[j-1])//if sum > element
    				table[i][j]=(table[i][j] || table[i-arr[j-1]][j-1]);
    				
    		}
    	}
    	System.out.println(Arrays.deepToString(table));
    	element_subset(table,arr,n,sum);
    	return table[sum][n];
    }
	public static void main(String[] args) throws IOException
	{
		// TODO Auto-generated method stub
       BufferedReader bf=new BufferedReader(new FileReader("../Dynamic Programming/src/subset_sum_problem1.txt"));
      // System.out.println("Enter number of element in array");
       int n=Integer.parseInt(bf.readLine());
       //System.out.println("Enter elements of the array");
       int[] arr=new int[n];
       String[] str=bf.readLine().trim().split("\\s+");
       for(int i=0;i<n;i++)
           arr[i]=Integer.parseInt(str[i]);
       //System.out.println("Enter sum which we want to find");
       int sum=Integer.parseInt(bf.readLine());
       
       if(ssp(arr,n,sum))
          System.out.println("Subset with given sum found");
       else
    	   System.out.println("Subset with given sum not found");
	}

}
