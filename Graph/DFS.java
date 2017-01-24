package graph;

import java.util.*;


class DFS 
{
	static int vertices;
	static List<Integer> adj[];
	DFS()
	{
		adj=new ArrayList[vertices+1];
		for(int i=1;i<=vertices;i++)
		{
			adj[i]=new ArrayList<Integer>();
		}		
	}
	void addEdge(int a, int b)
	{
		
		adj[a].add(b);
		adj[b].add(a);
	}
	static void DfsFun(boolean[] visited,int v)
	{
		
		//boolean[] visited=new boolean[vertices+1];
		visited[v]=true;
		System.out.print(v+" ");
		Iterator<Integer> it=adj[v].listIterator();
		while(it.hasNext())
		{
			int b=it.next();
			if(!visited[b])
			{
				//visited[b]=true;
				DfsFun(visited,b);
			}
		}
		
	}
    public static void main(String args[] ) 
    {
    	Scanner sc=new Scanner(System.in);
    	int nodes=sc.nextInt();
    	vertices=nodes;
    	int edges=sc.nextInt();
    	DFS b=new DFS();
    	for(int i=0;i<edges;i++)
    	{
    		int nodeA=sc.nextInt();
    		int nodeB=sc.nextInt();
    		b.addEdge(nodeA,nodeB);
    	}
    	//int x=sc.nextInt();
    	sc.close();
    	int src=1;
    	boolean[] visited=new boolean[vertices+1];
    	System.out.print("DFS traversal is :");
    	DfsFun(visited,src);
    }
}
/*
20 21
11 1
1 2
13 3
15 4
17 5
11 6
2 7
1 8
15 9
4 10
15 12
5 13
2 14
17 15
15 16
11 17
15 18
9 19
16 20
8 19
3 6
DFS traversal is :1 11 6 3 13 5 17 15 4 10 9 19 8 12 16 20 18 2 7 14 
*/
