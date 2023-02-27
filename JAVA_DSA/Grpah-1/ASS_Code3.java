import java.util.*;
 
// A class to store a graph edge
class Edge
{
    public final int source, dest;
 
    private Edge(int source, int dest)
    {
        this.source = source;
        this.dest = dest;
    }
 
    // Factory method for creating an immutable instance of `Edge`
    public static Edge of(int a, int b) {
        return new Edge(a, b);        // calls private constructor
    }
}
 
// A class to represent a graph object
class Graph
{
    // A list of lists to represent an adjacency list
    List<List<Integer>> adjList = null;
 
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
    // Function to perform BFS traversal from a given source vertex in a graph to
    // determine if a destination vertex is reachable from the source or not
    public static boolean isReachable(Graph graph, int src, int dest)
    {
        // get the total number of nodes in the graph
        int n = graph.adjList.size();
 
        // to keep track of whether a vertex is discovered or not
        boolean[] discovered = new boolean[n];
 
        // create a queue for doing BFS
        Queue<Integer> q = new ArrayDeque<>();
 
        // mark the source vertex as discovered
        discovered[src] = true;
 
        // enqueue source vertex
        q.add(src);
 
        // loop till queue is empty
        while (!q.isEmpty())
        {
            // dequeue front node and print it
            int v = q.poll();
 
            // if destination vertex is found
            if (v == dest) {
                return true;
            }
 
            // do for every edge (v, u)
            for (int u: graph.adjList.get(v))
            {
                if (!discovered[u])
                {
                    // mark it as discovered and enqueue it
                    discovered[u] = true;
                    q.add(u);
                }
            }
        }
 
        return false;
    }
 
    public static void main(String[] args)
    {
        // List of graph edges as per the above diagram
        List<Edge> edges = Arrays.asList(Edge.of(0, 3), Edge.of(1, 0),
                                Edge.of(1, 2), Edge.of(1, 4), Edge.of(2, 7),
                                Edge.of(3, 4), Edge.of(3, 5), Edge.of(4, 3),
                                Edge.of(4, 6), Edge.of(5, 6), Edge.of(6, 7));
 
        // total number of nodes in the graph (labeled from 0 to 7)
        int n = 8;
 
        // build a graph from the given edges
        Graph graph = new Graph(edges, n);
 
        // source and destination vertex
        int src = 0, dest = 7;
 
        // perform BFS traversal from the source vertex to check the connectivity
        if (isReachable(graph, src, dest)) {
            System.out.println("Path exists from vertex " + src + " to vertex " + dest);
        }
        else {
            System.out.println("No path exists between vertices " + src +
                    " and " + dest);
        }
    }
}
