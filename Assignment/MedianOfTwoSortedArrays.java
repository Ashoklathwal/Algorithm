import java.util.Arrays;
import java.util.Scanner;

public class MedianOfTwoSortedArrays 
 {
	static int getMedian(int arrayA[],int sa,int ea,int arrayB[],int sb,int eb)
	{
		int size=eb-sb+1;
        if(size<0)
            return -1;
        if(size==1)
            return (arrayA[0]+arrayB[0])/2;
        if(size==2)
            return Math.max(arrayA[0],arrayB[0])+Math.min(arrayA[1],arrayB[1])/2;
        int midA=median(arrayA,size);
        int midB=median(arrayB,size);
        if(midA==midB)
            return midA;
        if(midA<midB){
            //if(size%2==0)
                return getMedian(arrayA,sa,(int)Math.floor(size/2),arrayB,(int)Math.floor(size/2),eb);
            //return getMedian(arrayA,sa,sa+(size/2),arrayB,sb+(size/2),eb);
        }
        else
        {
            //if(size%2==0)
            	return getMedian(arrayA,(int)Math.floor(size/2),ea,arrayB,sb,(int)Math.floor(size/2));
           // return getMedian(arrayA,sa+(size/2),ea,arrayB,sb,sb+(size/2));
        }
        
    }
	 static int median(int array[],int size)
	     {
	        if(size%2==0)
	            return (array[size/2-1]+array[size/2])/2;
	        else
	            return array[size/2];
	     }
/*	
   static void printArray(int array[])
	  {
        for(int i=0;i<array.length;i++)
            System.out.print(array[i]+"  ");
             System.out.println();
      }
      */
    public static void main(String[] args) 
    {
        Scanner scan=new Scanner(System.in);
       // System.out.println("Enter the size of array");
        int n=scan.nextInt();
        int arrayA[]=new int[n];
        int arrayB[]=new int[n];
       // System.out.println("Enter array elements in sorted order");
        for(int i=0;i<n;i++)
          {
             arrayA[i]=scan.nextInt();
          }
       // System.out.println("Enter array elements in sorted order");
        for(int i=0;i<n;i++)
          {
            arrayB[i]=scan.nextInt();
          }
        System.out.println("Median of two sorted arrays :"+getMedian(arrayA,0,n-1,arrayB,0,n-1));
       // System.out.println("Arrays are");
       // printArray(arrayA);
        //printArray(arrayB);
    }
}
/*
5
1 12 15 26 38
2 13 17 30 45
16
*/