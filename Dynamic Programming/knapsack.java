import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class knapsack
 {
   static void knapsackFunWithoutDuplicate(int n, int capacity, int[] weight, int[] profit)
   {
	   
	   int[][] knpsk=new int[n+1][capacity+1];
	   for(int i=0;i<=n;i++)
	   {
		   for(int j=0;j<=capacity;j++)
		   {
			   if(i==0 || j==0)
				   knpsk[i][j]=0;
			   else if(weight[i-1]>j)
				   knpsk[i][j]=knpsk[i-1][j];
			   else
				   knpsk[i][j]=Math.max(knpsk[i-1][j-weight[i-1]]+profit[i-1],knpsk[i-1][j] );
		   }
	   }
	  System.out.println(Arrays.deepToString(knpsk));
	   System.out.println("......without duplicates.........");
	   System.out.println("The maximum profit we get is :"+knpsk[n][capacity]);
	   System.out.println("The objects we picked for maximum profit :");
	   
	   int i=n,j=capacity;
	   while(i>0 && j>0)
	   {		   
		   if(knpsk[i][j]!=knpsk[i-1][j])
		   {
			   System.out.print(i+" ");
			   i--;			  
			   if(i>0 && (j-weight[i])>=0)		       		       
				   j=j-weight[i]; 			   
		   }
		   else
			  i--;
	   }
	   System.out.println("");
   }
   
   static void knapsackFunWithDuplicate(int n,int capacity,int[] weight,int[] profit)
   {
	   System.out.println("......with duplicates.........");
	   int[][] knpsk=new int[capacity+1][n+1];	   
	   for(int i=0;i<=capacity;i++)
	   {
		   for(int j=0;j<=n;j++)
		   {
			   if(i==0 || j==0)
				   knpsk[i][j]=0;
			   else if(weight[j-1]>i)
				   knpsk[i][j]=knpsk[i][j-1];
			   else
				   knpsk[i][j]=Math.max(knpsk[i-weight[j-1]][j]+profit[j-1],knpsk[i][j-1] );
		   }
	   }
	  System.out.println(Arrays.deepToString(knpsk));
	   //System.out.println("......without duplicates.........");
	   System.out.println("The maximum profit we get is :"+knpsk[capacity][n]);
	   System.out.println("The objects we picked for maximum profit :");
	   
	   int j=n,i=capacity;
	   while(i>0 && j>0)
	   {		   
		   if(knpsk[i][j]!=knpsk[i][j-1])
		   {
			   System.out.print(j+" ");
			   j--;			  
			   if(j>0 && (i-weight[j])>=0)		       		       
				   i=i-weight[j]; 			   
		   }
		   else
			  j--;
	   }
	   System.out.println("");
   }
   
   public static void main(String[] args) throws IOException
   { 
	   BufferedReader bf=new BufferedReader(new FileReader("../Dynamic Programming/src/input.txt"));
	   //System.out.println("Enter the number of objects");
		   int n=Integer.parseInt(bf.readLine());
	   //System.out.println("Enter the capacity of knapsack");
	   int capacity=Integer.parseInt(bf.readLine());
	   int[] weight=new int[n];
	   int[] profit=new int[n];
	   //System.out.println("Enter the weights of the objects");
	   String[] strs=bf.readLine().trim().split("\\s+");
	   for(int i=0;i<n;i++)
		   weight[i]=Integer.parseInt(strs[i]);
			   //System.out.println("Enter the profits of the objects");
	   strs=bf.readLine().trim().split("\\s+");
	   for(int i=0;i<n;i++)
		   profit[i]=Integer.parseInt(strs[i]);
		 knapsackFunWithoutDuplicate(n,capacity,weight,profit);
		 knapsackFunWithDuplicate(n,capacity,weight,profit);
   }
 } 
/*
Enter the number of objects
5
Enter the capacity of knapsack
20
Enter the weights of the objects
13 5 3 2 3
Enter the profits of the objects
75 50 80 90 20
The maximum profit we get is :245

*/