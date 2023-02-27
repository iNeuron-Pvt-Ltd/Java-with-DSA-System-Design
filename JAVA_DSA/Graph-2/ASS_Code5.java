import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
 
// A class to store a graph edge
class Edge
{
    int source, dest;
 
    public Edge(int source, int dest)
    {
        this.source = source;
        this.dest = dest;
    }
}
 
// A class to represent a graph object
class Graph
{
    // A list of lists to represent an adjacency list
    List<List<Integer>> adjList;
 
    // stores indegree of a vertex
    List<Integer> in;
 
    // Constructor
    Graph(int n)
    {
        adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
 
        // initialize indegree of each vertex by 0
        in = new ArrayList<>(Collections.nCopies(n, 0));
    }
 
    // Utility function to add an edge (u, v) to the graph
    void addEdge(int u, int v)
    {
        // add an edge from source to destination
        adjList.get(u).add(v);
 
        // increment in-degree of destination vertex by 1
        in.set(v, in.get(v) + 1);
    }
}
 
class Main
{
    // Function to perform DFS traversal on the graph
    public static void DFS(Graph graph, int v, boolean[] discovered)
    {
        // mark the current node as discovered
        discovered[v] = true;
 
        // do for every edge (v, u)
        for (int u: graph.adjList.get(v))
        {
            // `u` is not discovered
            if (!discovered[u]) {
                DFS(graph, u, discovered);
            }
        }
    }
 
    // Function to replace all the directed edges of the graph with undirected edges
    // and produce an undirected graph
    public static Graph getUndirectedGraph(Graph graph, int n)
    {
        Graph g = new Graph(n);
        for (int u = 0; u < n; u++)
        {
            for (int v: graph.adjList.get(u)) {        // for every edge (u, v)
                g.addEdge(v, u);
                g.addEdge(u, v);
            }
        }
        return g;
    }
 
    // Function to check if all vertices with a non-zero degree in a graph
    // belong to a single connected component
    public static boolean isConnected(Graph graph, int n)
    {
        // keep track of all previously visited vertices in DFS
        boolean[] visited = new boolean[n];
 
        // start DFS from the first vertex with a non-zero degree
        for (int i = 0; i < n; i++)
        {
            if (graph.adjList.get(i).size() > 0)
            {
                DFS(graph, i, visited);
                break;
            }
        }
 
        // if a single DFS call couldn't visit all vertices with a non-zero degree,
        // the graph contains more than one connected component
        for (int i = 0; i < n; i++)
        {
            if (!visited[i] && graph.adjList.get(i).size() > 0) {
                return false;
            }
        }
 
        return true;
    }
 
    // Function to check if a directed graph has an Eulerian path
    public static boolean hasEulerPath(Graph graph, int n)
    {
        /*
            The following loop checks the following conditions to determine if an
            Eulerian path can exist or not:
                a. At most one vertex in the graph has `out-degree = 1 + in-degree`.
                b. At most one vertex in the graph has `in-degree = 1 + out-degree`.
                c. Rest all vertices have `in-degree == out-degree`.
 
            If either of the above condition fails, the Euler path can't exist.
        */
 
        boolean x = false, y = false;
        for (int i = 0; i < n; i++)
        {
            int out_degree = graph.adjList.get(i).size();
            int in_degree = graph.in.get(i);
 
            if (out_degree != in_degree)
            {
                if (!x && out_degree - in_degree == 1) {
                    x = true;
                }
                else if (!y && in_degree - out_degree == 1) {
                    y = true;
                }
                else {
                    return false;
                }
            }
        }
 
        // consider given edges as undirected and check if all non-isolated vertices
        // belong to a single connected component
        return isConnected(getUndirectedGraph(graph, n), n);
    }
 
    public static void main(String[] args)
    {
        // List of graph edges as per the above diagram
        List<Edge> edges = Arrays.asList(new Edge(0, 1), new Edge(1, 2),
                new Edge(2, 3), new Edge(3, 1), new Edge(1, 4), new Edge(4, 3),
                new Edge(3, 0), new Edge(0, 5), new Edge(5, 4)
        );
 
        // total number of nodes in the graph (labelled from 0 to 5)
        int n = 6;
 
        // build a directed graph from the above edges
        Graph graph = new Graph(n);
 
        // add edges to the directed graph
        for (Edge edge: edges) {
            graph.addEdge(edge.source, edge.dest);
        }
 
        if (hasEulerPath(graph, n)) {
            System.out.println("The graph has an Eulerian path");
        }
        else {
            System.out.println("The Graph doesn't have an Eulerian path");
        }
    }
}
