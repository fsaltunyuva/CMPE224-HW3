package Q2;//-----------------------------------------------------
// Title: Edge Weighted Digraph Implementation
// Authors: Burak Koç - Furkan Safa Altunyuva
// Section: 4
// Assignment: 3
// Description: This class directly references the codes from the lecture slides inspired from Sedgewick's Algorithms book
//-----------------------------------------------------
import java.util.ArrayList;

public class EdgeWeightedDigraph {

    private final int V;
    private int E;
    private final ArrayList<DirectedEdge>[] adj;

    public EdgeWeightedDigraph(int V) {
        this.V = V;
        this.E = 0;
        adj = new ArrayList[V];
        for (int v = 0; v < V; v++)
            adj[v] = new ArrayList<DirectedEdge>();
    }

    public void addEdge(DirectedEdge e) {
        int v = e.from();
        adj[v].add(e);
        E++;
    }

    public Iterable<DirectedEdge> adj(int v) {
        return adj[v];
    }

    public int V() { return V; }
    public int E() { return E; }

    public Iterable<DirectedEdge> edges()
    {
        ArrayList<DirectedEdge> bag = new ArrayList<DirectedEdge>();
        for (int v = 0; v < V; v++)
            for (DirectedEdge e : adj[v])
                bag.add(e);
        return bag;
    }

}
