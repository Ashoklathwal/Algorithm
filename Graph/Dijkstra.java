import java.io.*;
import java.util.*;

public class Dijkstra {
     static int minDis(int[] dis,boolean[] visit,int vertices)
         { 
           int min=Integer.MAX_VALUE;
           int index=Integer.MIN_VALUE;
           for(int i=1;i<=vertices;i++)
               {
                 if(!visit[i] && dis[i]<=min)
                     {
                     min=dis[i];
                     index=i;
                     }
               }
         return index;
         }
    public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
        int q=sc.nextInt();
        for(int K=0;K<q;K++)
            {
            int vertices=sc.nextInt();
            int edges=sc.nextInt();
            int[][] graph=new int[vertices+1][vertices+1];
            int src=0;
            int i=0;
             for(int j=1; j<vertices+1; j++){
            for(int l=1; l<vertices+1; l++)
                graph[j][l]=-1;
        }
           //for(int[] row:graph)
             //  Arrays.fill(row,0);
            for(int t=0;t<edges;t++)
              {
                    int x=sc.nextInt();
                     int y=sc.nextInt();
                      int r=sc.nextInt();
                if(graph[x][y]==-1){
                graph[x][y]=r;
                graph[y][x]=r;
            }
            if(graph[x][y]!=-1 && graph[x][y]>r){
                graph[x][y]=r;
                graph[y][x]=r;
        }
                    
              }
            int[] dis=new int[vertices+1];
            boolean[] visit=new boolean[vertices+1];
             for( i=1;i<=vertices;i++)
               {
        	     dis[i]=Integer.MAX_VALUE;
        	     visit[i]=false;
               }
             src=sc.nextInt();
            dis[src]=0;
            for(int count=0;count<vertices;count++)
                {
                int a=minDis(dis,visit,vertices);
                visit[a]=true;
                for(int b=1;b<=vertices;b++)
                    {
                     if(!visit[b] && graph[a][b]!=-1 && dis[a]!=Integer.MAX_VALUE &&((dis[a]+graph[a][b])<dis[b]))
                         {
                         dis[b]=dis[a]+graph[a][b];
                         }
                    }
                }
         //   for( i=1;i<=vertices;i++)
           //     System.out.print(dis[i]+" ");
            for(i=1;i<=vertices;i++)
                {
                if(i!=src)
                    {
                 if(dis[i]==Integer.MAX_VALUE )
                     System.out.print("-1"+" ");
                else
                    System.out.print(dis[i]+" ");
                }
              }
            System.out.println("");
           /*  for(i=1;i<=vertices;i++)
            {
             for(int j=1;j<=vertices;j++)
                 {
                 System.out.print(graph[i][j]+" ");
                 }
            System.out.println("");
            }
            
            */
            }
       
    }
}