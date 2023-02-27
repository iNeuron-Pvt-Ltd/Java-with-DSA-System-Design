import java.util.ArrayList;
import java.util.Arrays;
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
 
    // Constructor
    Graph(List<Edge> edges, int n)
    {
        adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
 
        // add edges to the directed graph
        for (Edge edge: edges) {
            adjList.get(edge.source).add(edge.dest);
        }
    }
}
 
class Main
{
    // Utility function to perform DFS traversal on the graph
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
 
    // Function to find the root vertex of a graph
    public static int findRootVertex(Graph graph, int n)
    {
        // to keep track of all previously visited vertices in DFS
        boolean[] visited = new boolean[n];
 
        // find the last starting vertex `v` in DFS
        int v = 0;
        for (int i = 0; i < n; i++)
        {
            if (!visited[i])
            {
                DFS(graph, i, visited);
                v = i;
            }
        }
 
        // reset the visited vertices
        Arrays.fill(visited, false);
 
        // perform DFS on the graph from the last starting vertex `v`
        DFS(graph, v, visited);
 
        // return -1 if all vertices are not reachable from vertex `v`
        for (int i = 0; i < n; i++)
        {
            if (!visited[i]) {
                return -1;
            }
        }
 
        // we reach here only if `v` is a root vertex
        return v;
    }
 
    public static void main(String[] args)
    {
        // List of graph edges as per the above diagram
        List<Edge> edges = Arrays.asList(new Edge(0, 1), new Edge(1, 2),
                    new Edge(2, 3), new Edge(3, 0), new Edge(4, 3),
                    new Edge(4, 5), new Edge(5, 0));
 
        // total number of nodes in the graph (0 to 5)
        int n = 6;
 
        // build a directed graph from the given edges
        Graph graph = new Graph(edges, n);
 
        // find the root vertex in the graph
        int root = findRootVertex(graph, n);
 
        if (root != -1) {
            System.out.println("The root vertex is " + root);
        }
        else {
            System.out.println("The root vertex does not exist");
        }
    }
}
