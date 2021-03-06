package graph;

import java.util.*;


class BFS 
{
	static int vertices;
	static List<Integer> adj[];
	BFS()
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
	static void bfsFun()
	{
		int src=1;
		boolean[] visited=new boolean[vertices+1];
		Queue<Integer> queue=new LinkedList<>();
		visited[src]=true;
		//queue.add(-1);
		queue.add(src);
		while(!queue.isEmpty())
		{
			int a=queue.poll();
			
			System.out.print(a+" ");
			Iterator<Integer> it=adj[a].listIterator();
			while(it.hasNext())
			{
				int b=it.next();
				if(!visited[b])
				{
					visited[b]=true;
					queue.add(b);
				}
			}
		}
		
		
	}
    public static void main(String args[] ) 
    {
    	Scanner sc=new Scanner(System.in);
    	int nodes=sc.nextInt();
    	vertices=nodes;
    	int edges=sc.nextInt();
    	BFS b=new BFS();
    	for(int i=0;i<edges;i++)
    	{
    		int nodeA=sc.nextInt();
    		int nodeB=sc.nextInt();
    		b.addEdge(nodeA,nodeB);
    	}
    	//int x=sc.nextInt();
    	sc.close();
    	System.out.print("BFS traversal is :");
    	bfsFun();
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
BFS traversal is :1 11 2 8 6 17 7 14 5 15 13 4 9 12 16 18 3 10 19 20 
*/
