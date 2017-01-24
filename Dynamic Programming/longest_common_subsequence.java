
import java.util.*;

public class longest_common_subsequence {
    static void lcs(int[] arr1,int[] arr2,int m,int n)
        {
        int[][] ml=new int[m+1][n+1];
        // start in bottom up manner
        for(int i=0;i<=m;i++)
            {
            for(int j=0;j<=n;j++)
                {
                if(i==0 || j==0)
                     ml[i][j]=0;
                else if(arr1[i-1]==arr2[j-1])
                    ml[i][j]=1+ml[i-1][j-1];
                    else 
                     ml[i][j]=Math.max(ml[i][j-1],ml[i-1][j]);
                    
                }
            }
        //printing max subsequence
        int maxval=ml[m][n];
       System.out.println("Length of longest common Subsequence :"+maxval);
        int[] sub=new int[maxval+1];
         sub[maxval]='\0';
        int i=m;
        int j=n;
        while(i>0 && j>0)
            {
            if(arr1[i-1]==arr2[j-1])
            {
                sub[maxval-1]=arr1[i-1];
                i--;j--;maxval--;
            }
            else if(ml[i-1][j]>ml[i][j-1])
                i--;
                else
                j--;
            }
        System.out.print("The longest common subsequence is :");
        for( int k=0;k<sub.length-1;k++){
        System.out.print(sub[k]+" ");
        }
       
        }

    public static void main(String[] args) {
     Scanner sc=new Scanner(System.in);
        int m=sc.nextInt();
        int n=sc.nextInt();
        int[] arr1=new int[m];
        int[] arr2=new int[n];
        for(int i=0;i<m;i++)
            {
            arr1[i]=sc.nextInt();
            }
         for(int i=0;i<n;i++)
            {
            arr2[i]=sc.nextInt();
            }
         sc.close();
        lcs(arr1,arr2,m,n);
    }
}
/*
5 6
1 2 3 4 1
3 4 1 2 1 3
Length of longest common Subsequence :3
The longest common subsequence is :3 4 1 
*/