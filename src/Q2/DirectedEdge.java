package Q2;//-----------------------------------------------------
// Title: Directed Edge Implementation
// Authors: Burak Koç - Furkan Safa Altunyuva
// Section: 4
// Assignment: 3
// Description: This class directly references the codes from the lecture slides inspired from Sedgewick's Algorithms book
//-----------------------------------------------------

public class DirectedEdge {
    private final int v, w; // edge source (v)  // edge target (w)
    private final double weight; //edge weight

    public DirectedEdge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public int from() {
        return v;
    }

    public int to() {
        return w;
    }

    public double weight() {
        return weight;
    }

    public String toString() {
        return String.format("%d->%d %.2f", v, w, weight);
    }



}