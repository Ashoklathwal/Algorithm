import java.io.*;
import java.util.*;

public class Prims {
    static int minKey(int[] key,boolean[] visit,int vertices)
        {
        int min=Integer.MAX_VALUE;
        int index=-1;
        for(int i=0;i<vertices;i++)
            {
             if(!visit[i] && key[i]<min)
                 {
                   min=key[i];
                 index=i;
                 }   
            }
        return index;
        }
    public static void main(String[] args) {
     Scanner sc=new Scanner(System.in);
        int vertices=sc.nextInt();
        int edges=sc.nextInt();
        int[][] arr=new int[vertices][vertices];
       for(int j=0; j<vertices; j++){
            for(int l=0; l<vertices; l++)
               arr[j][l]=-1;
       }
          for(int t=0;t<edges;t++)
              {
                    int x=sc.nextInt()-1;
                     int y=sc.nextInt()-1;
                      int r=sc.nextInt();
                 arr[y][x]=r;
                arr[x][y]=r;
          }
        int src=sc.nextInt();
        boolean[] visit=new boolean[vertices];
        int[] parent=new int[vertices];
        int[] key=new int[vertices];
        for(int i=0;i<vertices;i++)
            {
            key[i]=Integer.MAX_VALUE;
            visit[i]=false;
            }
        key[0]=0;
        parent[0]=-1;
        for(int count=0;count<vertices-1;count++)
            {
            int a=minKey(key,visit,vertices);
            visit[a]=true;
            for(int b=0;b<vertices;b++)
                {
                if(!visit[b] && arr[a][b]!=-1 && arr[a][b]<key[b])
                    {
                    key[b]=arr[a][b];
                    parent[b]=a;
                }
                }
            }
        int count=0;
        for(int i=1;i<vertices;i++)
            count+=arr[i][parent[i]];
        System.out.println(count);
        
    }
}