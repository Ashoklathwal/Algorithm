package graph;
/*
 * 
 * void dfs(int x, int parent) {
    vis[x] = true;
    inStack[x] = true;
    for(int u = 0; u < n; u++) {
        if (graph[x][u] == 1 && u != parent && vis[u] && inStack[u]) {
            // there is a cycle: u -> ... -> parent -> x
        }
        if(!vis[u] && graph[x][u] == 1) {
            dfs(u, x);
        }
    }
    inStack[x] = false;
    order.push_back(x);
}
 */
import java.io.*;

public class toposort 
{

	public static void main(String[] args) throws IOException
	{
		BufferedReader bf=new BufferedReader(new FileReader(../Dynamic Programming/src/floyd_warshalls1.txt"));
		String[] str=bf.readLine().trim().split(" ");
		int vertices=Integer.parseInt(str[0]);
		int edges=Integer.parseInt(str[1]);
        for(int i=0;i<edges;i++)
        {
        	String[] str=bf.readLine().trim().split(" ");
    		int vertices=Integer.parseInt(str[0]);
    		int edges=Integer.parseInt(str[1]);
    		int weight=Integer.parseInt(str[2]);
    		
        }
	}

}
