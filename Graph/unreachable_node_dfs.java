package graph;

import java.util.*;


class unreachable_node_dfs 
{
	static int vertices;
	static List<Integer> adj[];
	unreachable_node_dfs()
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
		//System.out.print(v+" ");
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
    	unreachable_node_dfs b=new unreachable_node_dfs();
    	for(int i=0;i<edges;i++)
    	{
    		int nodeA=sc.nextInt();
    		int nodeB=sc.nextInt();
    		b.addEdge(nodeA,nodeB);
    	}
    	int src=sc.nextInt();
    	sc.close();
    	boolean[] visited=new boolean[vertices+1];
    	//System.out.print("DFS traversal is :");
    	DfsFun(visited,src);
    	int count=0;
    	for(int i=1;i<vertices+1;i++)
    	{
    		if(!visited[i])
    			count++;
    	}
    	System.out.println("number of unreachable nodes : "+count);
    }
}
/*
10 10
8 1
8 3
7 4
7 5
2 6
10 7
2 8
10 9
2 10
5 10
2
number of unreachable nodes : 0
*/