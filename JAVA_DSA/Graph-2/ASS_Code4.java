import java.util.*;
 
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
 
// A BFS Node
class Node
{
    // stores current vertex number and the current depth of
    // BFS (how far away from source current node is)
    int vertex, depth;
 
    public Node(int vertex, int depth)
    {
        this.vertex = vertex;
        this.depth = depth;
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
    // Perform BFS on graph `graph` starting from vertex `v`
    public static int findTotalPaths(Graph graph, int src, int dest, int m)
    {
        // create a queue for doing BFS
        Queue<Node> q = new ArrayDeque<>();
 
        // enqueue source vertex
        q.add(new Node(src, 0));
 
        // stores number of paths from source to destination
        // having exactly `m` edges
        int count = 0;
 
        // loop till queue is empty
        while (!q.isEmpty())
        {
            // dequeue front node
            Node node = q.poll();
 
            int v = node.vertex;
            int depth = node.depth;
 
            // if the destination is reached and BFS depth is equal to `m`,
            // update count
            if (v == dest && depth == m) {
                count++;
            }
 
            // don't consider nodes having a BFS depth more than `m`.
            // This check will result in optimized code and handle cycles
            // in the graph (otherwise, the loop will never break)
            if (depth > m) {
                break;
            }
 
            // do for every adjacent vertex `u` of `v`
            for (int u: graph.adjList.get(v))
            {
                // push every vertex (discovered or undiscovered) into the queue
                q.add(new Node(u, depth + 1));
            }
        }
 
        // return number of paths from source to destination
        return count;
    }
 
    public static void main(String[] args)
    {
        // List of graph edges as per the above diagram
        List<Edge> edges = Arrays.asList(
                new Edge(0, 6), new Edge(0, 1), new Edge(1, 6), new Edge(1, 5),
                new Edge(1, 2), new Edge(2, 3), new Edge(3, 4), new Edge(5, 2),
                new Edge(5, 3), new Edge(5, 4), new Edge(6, 5), new Edge(7, 6),
                new Edge(7, 1));
 
        // total number of nodes in the graph
        int n = 8;
 
        // construct graph
        Graph graph = new Graph(edges, n);
 
        int src = 0, dest = 3, m = 4;
 
        // Do modified BFS traversal from the source vertex src
        System.out.println(findTotalPaths(graph, src, dest, m));
    }
}
