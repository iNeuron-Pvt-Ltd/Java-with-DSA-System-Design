import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
 
// A class to store a graph edge
class Edge
{
    int src, dest;
 
    Edge(int src, int dest)
    {
        this.src = src;
        this.dest = dest;
    }
}
 
// A class to represent a graph object
class Graph
{
    // A list of lists to represent an adjacency list
    List<List<Integer>> adjList = new ArrayList<>();
 
    // Constructor to construct a graph
    public Graph(List<Edge> edges)
    {
        // find the maximum numbered vertex
        int n = 0;
        for (Edge e: edges) {
            n = Integer.max(n, Integer.max(e.src, e.dest));
        }
 
        // allocate memory for the adjacency list
        for (int i = 0; i <= n; i++) {
            adjList.add(i, new ArrayList<>());
        }
 
        // add edges to the directed graph
        for (Edge current: edges)
        {
            // allocate new node in adjacency list from src to dest
            adjList.get(current.src).add(current.dest);
 
            // uncomment below line for undirected graph
 
            // allocate new node in adjacency list from dest to src
            // adjList.get(current.dest).add(current.src);
        }
    }
 
    // Function to print adjacency list representation of a graph
    public static void printGraph(Graph graph)
    {
        int src = 0;
        int n = graph.adjList.size();
 
        while (src < n)
        {
            // print current vertex and all its neighboring vertices
            for (int dest: graph.adjList.get(src)) {
                System.out.print("(" + src + " ——> " + dest + ")\t");
            }
            System.out.println();
            src++;
        }
    }
}
 
class Main
{
    public static void main (String[] args)
    {
        // Input: List of edges in a digraph (as per the above diagram)
        List<Edge> edges = Arrays.asList(new Edge(0, 1), new Edge(1, 2),
                new Edge(2, 0), new Edge(2, 1), new Edge(3, 2),
                new Edge(4, 5), new Edge(5, 4));
 
        // construct a graph from the given list of edges
        Graph graph = new Graph(edges);
 
        // print adjacency list representation of the graph
        Graph.printGraph(graph);
    }
}
