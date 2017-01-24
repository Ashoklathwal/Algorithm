import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class matrix_chain_multiplication
{
	static void extract_sequence(int[] p,int[][] split,int n,int m)
	{
       
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				if(i==j)
					System.out.print("p"+i);
				else
				{
					int k=split[i][j];
					System.out.print("(");
					extract_sequence(p,split,i,k);
					extract_sequence(p,split,k+1,j);
					System.out.print(")");
				}
					
			}
		}
	}
	static void mcm(int[] p)
	{
		int n=p.length-1;
		int[][] m=new int[n+1][n+1];
		int[][] split=new int[n+1][n+1];
		for(int i=1;i<=n;i++)
		{
			m[i][i]=0;
			split[i][i]=0;
		}
		// l=chain length
		for(int l=2;l<=n;l++)
		{
			for(int i=1;i<=n-l+1;i++)
			{
			  int j=i+l-1;
			  m[i][j]=Integer.MAX_VALUE;
			  for(int k=i;k<=j-1;k++)
			  {
				  int q=m[i][k]+m[k+1][j]+p[i-1]*p[k]*p[j];
				  if(m[i][j]>q)
				  {
					  m[i][j]=q;
					  // keep track of split marker
					  split[i][j]=k;
				  }
			  }
			}
		}
		System.out.println(Arrays.deepToString(m));
		System.out.println(Arrays.deepToString(split));
		System.out.println("The min number of multiplication required :"+m[1][n]);
		System.out.println("The min number of split required :"+split[2][n]);
		System.out.println("The extracted sequence is :");
		extract_sequence(p,split,n,n);
		
	}
  public static void main(String[] args) throws IOException
  {
	  BufferedReader bf=new BufferedReader(new FileReader("../Dynamic Programming/src/matrix_chain_multiplication1.txt"));
	 // System.out.println("Enter number of matrices");
	  int n=Integer.parseInt(bf.readLine());
	  //System.out.println("Enter element of matrices");;
	  int[] p=new int[n];
	  String[] str=bf.readLine().trim().split("\\s+");
	  for(int i=0;i<n;i++)
          p[i]=Integer.parseInt(str[i]);
	  mcm(p);
  }
}
