import java.io.*;
import java.util.Arrays;
/*
 * Detection of cycles of (non)negative length
 Floyd-Warshall algorithm can be easily modified to detect cycles. 
 If we fill negative infinity value at the diagonal of the matrix and 
 run the algorithm, than the matrix of predecessors will contain 
 also all cycles in the graph (the diagonal will not contain only zeros, 
 if there is a cycle in the graph).
  
 */
public class floyd_warshalls
{
	static void print_path(int[][] path,int i,int j)
	{
		 if(i==j)
			 System.out.print(i+" ");
		 else 
		 {
			 print_path(path,i,path[i][j]);
			 System.out.print(j+" ");
		 } 
		 
	}
    static void floydwarshallsfun(int[][] table,int vertices,int[][] path)
    {
    	int[][] pairs=table.clone();
    	
    	System.out.println(Arrays.deepToString(table));
    	//System.out.println(Arrays.deepToString(pairs));
     for(int k=1;k<=vertices;k++)
     {
    	for(int i=1;i<=vertices;i++)
    	{
    		for(int j=1;j<=vertices;j++)
    		{
    		//	if(i==j) 
    			//	pairs[i][j]=0;
    			 if(pairs[i][k]!=Integer.MAX_VALUE && pairs[k][j]!=Integer.MAX_VALUE && pairs[i][j]>(pairs[i][k]+pairs[k][j]))
    			{
    				pairs[i][j]=pairs[i][k]+pairs[k][j];
    				// System.out.println(Arrays.deepToString(pairs));
    				path[i][j]=path[k][j];
    			}	
    		}
    	}
     }
     System.out.println("shortest distance matrix :"+Arrays.deepToString(pairs));
     System.out.println("Path matrix :"+Arrays.deepToString(path));
     for(int i=1;i<=vertices;i++)
     {
    	 for(int j=1;j<=vertices;j++)
    	 {
    		System.out.println("path from " +i+" to "+j+ " is ");
    		print_path(path,i,j);
    		System.out.print("min shortest distance :"+pairs[i][j]);
    		System.out.println("");
    	 }
     }
    
    }
	public static void main(String[] args) throws IOException
	{
		// TODO Auto-generated method stub
      BufferedReader bf=new BufferedReader(new FileReader("../Dynamic Programming/src/floyd_warshalls1.txt"));
	 // System.out.println("Enter number of vertices");
      int vertices=Integer.parseInt(bf.readLine());
      //System.out.println("Enter number of edges");
      int edges=Integer.parseInt(bf.readLine());
      int[][] table=new int[vertices+1][vertices+1];
      for(int i=1;i<=vertices;i++)
      {
    	  for(int j=1;j<=vertices;j++)
    	  {
    		  if(i!=j)
    			  table[i][j]=Integer.MAX_VALUE;
    	  }
      }
      //predecessor matrix
      int[][] path=new int[vertices+1][vertices+1];
      for(int i=0;i<edges;i++)
        {
    	  String[] str=bf.readLine().trim().split("\\s+");
    	  int a=Integer.parseInt(str[0]);
    	  int b=Integer.parseInt(str[1]);
    	  int weight=Integer.parseInt(str[2]);
    	  table[a][b]=weight;
    	  path[a][b]=a;
        }
      floydwarshallsfun(table,vertices,path);
	}

}
