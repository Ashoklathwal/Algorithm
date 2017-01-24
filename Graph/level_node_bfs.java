package graph;

import java.util.*;
//find the number of nodes at i th level in n-ary tree

class level_node_bfs 
{
	static int vertices;
	static List<Integer> adj[];
	level_node_bfs()
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
	static void bfsFun(int x)
	{
		int src=1;
		int count=0;
		boolean[] visited=new boolean[vertices+1];
		Queue<Integer> queue=new LinkedList<>();
		Queue<Integer> queue1=new LinkedList<>();
		visited[src]=true;
		queue.add(-1);
		queue.add(src);
		//queue.add(-1);
		while(!queue.isEmpty())
		{
			int a=queue.poll();
			if(a==-1 && !queue.isEmpty())
			     queue.add(-1);
			queue1.add(a);
			//System.out.print(a+" ");
			if(a==-1)
			{
			//   count=0;
			 // count++;
				if(!queue.isEmpty())
				{
			      a=queue.poll();
			      queue1.add(a);
			      //System.out.print(a+" ");
				}
				else 
					break;
			}
		
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
		int num=0;
		while(!queue1.isEmpty())
		{
			int a=queue1.poll();
			if(a==-1)
			{
				//count=0;
				count++;
			}
			if(count==x)
			{
				while(queue1.peek()!=-1)
				{
			       queue1.poll();
		        	num++;
				}
				break;
			}
		}
		System.out.println("Number of nodes at level "+x+" is :"+num );
		
	}
    public static void main(String args[] ) 
    {
    	Scanner sc=new Scanner(System.in);
    	int nodes=sc.nextInt();
    	vertices=nodes;
    //	int edges=sc.nextInt();
    	level_node_bfs b=new level_node_bfs();
    	for(int i=0;i<nodes-1;i++)
    	{
    		int nodeA=sc.nextInt();
    		int nodeB=sc.nextInt();
    		b.addEdge(nodeA,nodeB);
    	}
    	int x=sc.nextInt();
    	sc.close();
    	//System.out.print("BFS traversal is :");
    	bfsFun(x);
    }
}
/*
20
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
2
BFS traversal is :1 11 2 8 6 17 7 14 5 15 13 4 9 12 16 18 3 10 19 20 
*/
