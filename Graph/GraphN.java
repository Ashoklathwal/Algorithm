import java.util.*;
import java.io.*;
import static java.lang.System.*;


public class GraphN{
    private int V;  //no of vertices
    private int E;  //no of Edges
    private HashMap<Integer,ArrayList<Node>> list; //Adjacency List
    private int time=0; //time for DFS traversal

    class Node{
        int to,w;
        Node(int to,int w){
            this.to=to;
            this.w=w;
        }
    }
    class WComparator implements Comparator{
        public int compare(Object x,Object y){
            return ((Node)x).w-((Node)y).w;
        }
    }
    
    {
       list=new HashMap<>();  //From Java 7, no need to write in diamond  
    }
    

    GraphN(int v,int e){
        this.V=v;
        this.E=e;
        
        for(int i=1;i<=V;++i){
            list.put(i,new ArrayList<Node>());
        }
    }

    public void addEdge(int v1, int v2,int w) {
        list.get(v1).add(new Node(v2,w));
        list.get(v2).add(new Node(v1,w));
    }
    public void deleteEdge(int v1,int v2){
        list.get(v1).remove(new Integer(v2));
        list.get(v2).remove(new Integer(v1)); //For undirected
    }

    public ArrayList<Node> getNeighbors(int v) {
        return list.get(v);
    }
    public static int intv(String s){
        return Integer.parseInt(s);
    }
   
   @Override
    public String toString(){
        StringBuilder sb=new StringBuilder();
        for(Integer v:list.keySet()){
            sb.append(v).append(" : ");   //Adding Vertex
            for(Node x:list.get(v)){   //Adding Edges->
                sb.append(x.to).append("->");
            }
            sb.setLength(sb.length() - 2);//Remove last ->
            sb.append("\n");              //Added line change
        }
        return sb.toString();
    }

    public static void main(String[] args) throws IOException{

        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int i=0,T=0;
        //T=intv(in.readLine());
        //while(i<T){
            int V,E,count=1;
            //out.print("Enter no. of Vertices:");
            V=intv(in.readLine());

            //out.print("Enter no. of Edges:");
            E=intv(in.readLine());//V-1;

            GraphN g=new GraphN(V,E);

            /* Reads the edges present in the graph */
            //System.out.println("Enter the edges in graph: <source index> <destination index>");
            while (count <= E)
            {
                String[] arr=in.readLine().split(" ");
                int source = intv(arr[0]);
                int destination = intv(arr[1]);
                int weight = intv(arr[2]);
                g.addEdge(source, destination,weight);
                count++;
            } 
            //sb.append(cost).append(" ").append(dist).append("\n");         
        //System.out.print(g.prims());
        System.out.print();
        //System.out.print(g.dijkstra(2));
    }

}