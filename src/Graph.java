/**
 * @author Adalberto
 *
 */

import edu.princeton.cs.algs4.Bag;

public class Graph {
    private final Bag<Integer>[] adj;  // adjacencies of each vertex
    private final int size;            // number of vertices in the graph
    
    public Graph(int n) {
        /* Initialize a new graph with size n */
        this.size = n;
        this.adj = (Bag<Integer>[]) new Bag[n];
        for (int i = 0; i < n; i++) {
            this.adj[i] = new Bag<Integer>();
        }
    }
    
    public void addEdge(int s, int t) {
        // symmetric edges
        this.adj[s].add(t);
        this.adj[t].add(s);
    }
    
    public Iterable<Integer> adj(int s) {
        return this.adj[s];
    }
    
    public int getSize() {
        return this.size;
    }

    public int getAdjSize(int i) {
        return this.adj[i].size();
    }
}
