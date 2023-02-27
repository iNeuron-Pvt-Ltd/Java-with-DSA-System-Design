import java.util.*;
 
// A class to store a graph edge
class Edge
{
    public final int src, dest, weight;
 
    private Edge(int src, int dest, int weight)
    {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }
 
    // Factory method for creating an immutable instance of `Edge`
    public static Edge of(int a, int b, int c) {
        return new Edge(a, b, c);        // calls private constructor
    }
}
 
// A BFS Node
class Node
{
    int vertex, depth, weight;
 
    Node(int vertex, int depth, int weight)
    {
        this.vertex = vertex;
        this.depth = depth;
        this.weight = weight;
    }
}
 
// A class to represent a graph object
class Graph
{
    // A list of lists to represent an adjacency list
    List<List<Edge>> adjList = new ArrayList<>();
 
    // Graph Constructor
    public Graph(List<Edge> edges, int n)
    {
        // resize the list to `n` elements of type `List<Edge>`
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
 
        // add edges to the directed graph
        for (Edge e: edges) {
            adjList.get(e.src).add(e);
        }
    }
}
 
class Main
{
    // Perform BFS on graph `g` starting from vertex `v`
    public static int findLeastCost(Graph g, int src, int dest, int m)
    {
        // create a queue for doing BFS
        Queue<Node> q = new ArrayDeque<>();
 
        // enqueue source vertex
        q.add(new Node(src, 0, 0));
 
        // stores least-cost from source to destination
        int minCost = Integer.MAX_VALUE;
 
        // loop till queue is empty
        while (!q.isEmpty())
        {
            // dequeue front node
            Node node = q.poll();
 
            int v = node.vertex;
            int depth = node.depth;
            int cost = node.weight;
 
            // if the destination is reached and BFS depth is equal to `m`,
            // update the minimum cost calculated so far
            if (v == dest && depth == m) {
                minCost = Math.min(minCost, cost);
            }
 
            // don't consider nodes having a BFS depth more than `m`.
            // This check will result in optimized code and handle cycles
            // in the graph (otherwise, the loop will never break)
            if (depth > m) {
                break;
            }
 
            // do for every adjacent edge of `v`
            for (Edge edge: g.adjList.get(v))
            {
                // push every vertex (discovered or undiscovered) into
                // the queue with depth as +1 of parent and cost equal
                // to the cost of parent plus the current edge weight
                q.add(new Node(edge.dest, depth + 1, cost + edge.weight));
            }
        }
 
        // return least-cost
        return minCost;
    }
 
    public static void main(String[] args)
    {
        // List of graph edges as per the above diagram
        List<Edge> edges = Arrays.asList(
                        Edge.of(0, 6, -1), Edge.of(0, 1, 5), Edge.of(1, 6, 3),
                        Edge.of(1, 5, 5), Edge.of(1, 2, 7), Edge.of(2, 3, 8),
                        Edge.of(3, 4, 10), Edge.of(5, 2, -1), Edge.of(5, 3, 9),
                        Edge.of(5, 4, 1), Edge.of(6, 5, 2), Edge.of(7, 6, 9),
                        Edge.of(7, 1, 6));
 
        // total number of nodes in the graph (labelled from 0 to 7)
        int n = 8;
 
        // build a graph from the given edges
        Graph g = new Graph(edges, n);
 
        int src = 0, dest = 3, m = 4;
 
        // Perform modified BFS traversal from source vertex `src`
        System.out.print(findLeastCost(g, src, dest, m));
    }
}
