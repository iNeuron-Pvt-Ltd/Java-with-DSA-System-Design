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
 
// A class to represent a graph object
class Graph
{
    // A list of lists to represent an adjacency list
    List<List<Integer>> adjList = null;
 
    // Total number of nodes in the graph
    int n;
 
    // Constructor
    Graph(List<Edge> edges, int n)
    {
        this.adjList = new ArrayList<>();
        this.n = n;
 
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
 
        // add edges to the undirected graph
        for (Edge edge: edges)
        {
            int src = edge.source;
            int dest = edge.dest;
 
            // add an edge from source to destination
            adjList.get(src).add(dest);
 
            // add an edge from destination to source
            adjList.get(dest).add(src);
        }
    }
}
 
class Main
{
    // Perform BFS on the graph starting from vertex `v`
    public static boolean isBipartite(Graph graph)
    {
        // get total number of nodes in the graph
        int n = graph.n;
 
        // start from any node as the graph is connected and undirected
        int v = 0;
 
        // to keep track of whether a vertex is discovered or not
        boolean[] discovered = new boolean[n];
 
        // stores the level of each vertex in BFS
        int[] level = new int[n];
 
        // mark the source vertex as discovered and
        // set its level to 0
        discovered[v] = true;
        level[v] = 0;
 
        // create a queue to do BFS and enqueue
        // source vertex in it
        Queue<Integer> q = new ArrayDeque<>();
        q.add(v);
 
        // loop till queue is empty
        while (!q.isEmpty())
        {
            // dequeue front node and print it
            v = q.poll();
 
            // do for every edge (v, u)
            for (int u: graph.adjList.get(v))
            {
                // if vertex `u` is explored for the first time
                if (!discovered[u])
                {
                    // mark it as discovered
                    discovered[u] = true;
 
                    // set level one more than the level of the parent node
                    level[u] = level[v] + 1;
 
                    // enqueue vertex
                    q.add(u);
                }
                // if the vertex has already been discovered and the
                // level of vertex `u` and `v` are the same, then the
                // graph contains an odd-cycle and is not bipartite
                else if (level[v] == level[u]) {
                    return false;
                }
            }
        }
 
        return true;
    }
 
    public static void main(String[] args)
    {
        // List of graph edges
        List<Edge> edges = Arrays.asList(
                    new Edge(0, 1), new Edge(1, 2), new Edge(1, 7), new Edge(2, 3),
                    new Edge(3, 5), new Edge(4, 6), new Edge(4, 8), new Edge(7, 8)
                    // if we add edge (1, 3), the graph becomes non-bipartite
                );
 
        // total number of nodes in the graph (0 to 8)
        int n = 9;
 
        // build a graph from the given edges
        Graph graph = new Graph(edges, n);
 
        if (isBipartite(graph)) {
            System.out.println("Graph is bipartite");
        }
        else {
            System.out.println("Graph is not bipartite");
        }
    }
}
