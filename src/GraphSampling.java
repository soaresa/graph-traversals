/**
 * @author Adalberto
 *
 */

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

/**
 * Given integers n, k and t creates a Graph with 
 * n vertices and k random distinct adjacencies for each vertex,
 * and produces t searches in the graph with random vertices pairs (origin, target)
 * producing statistics of min, max and average for path length found and visited vertices.
 */
public class GraphSampling {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt(); // graph size to be created
        int k = scan.nextInt(); // number of vertex connections
        int t = scan.nextInt(); // number of random search samples
        scan.close();
        
        Graph graph = new Graph(n);
        Random r = new Random();
        
        /* Add k distinct random connections for each node */
        for (int j = 0; j < n; j++) {
            Set<Integer> before = new HashSet<>();
            Set<Integer> after = new HashSet<>();
            for (int added : graph.adj(j)) {
                before.add(added);
                after.add(added);
            }                        
            while (after.size() < k) {
                after.add(r.nextInt(n));
            }
            for (int x : after) {
                if (!before.contains(x)) {
                    graph.addEdge(j, x);
                }
            }
            if (j%100000 == 0) {
                System.out.println(">>> initialized " + j + " vertices ");
            }
        }
        System.out.println(">>> Graph initialized");
        
        /* Initialize statistics */
        int minPathDFS = java.lang.Integer.MAX_VALUE;
        int maxPathDFS = java.lang.Integer.MIN_VALUE;
        BigDecimal sumPathDFS = BigDecimal.valueOf(0);
        
        int minVerticesDFS = java.lang.Integer.MAX_VALUE;
        int maxVerticesDFS = java.lang.Integer.MIN_VALUE;
        BigDecimal sumVerticesDFS = BigDecimal.valueOf(0);
        
        int minPathBFS = java.lang.Integer.MAX_VALUE;
        int maxPathBFS = java.lang.Integer.MIN_VALUE;
        BigDecimal sumPathBFS = BigDecimal.valueOf(0);
        
        int minVerticesBFS = java.lang.Integer.MAX_VALUE;
        int maxVerticesBFS = java.lang.Integer.MIN_VALUE;
        BigDecimal sumVerticesBFS = BigDecimal.valueOf(0);
        
        /* Sample t random searches using BFS and DFS collecting statistics */
        for (int i = 0; i < t; i++) {
            int origin = r.nextInt(n);
            int target = r.nextInt(n);

            System.out.println("Iteration " + i + ", find path from " + origin + " to " + target);
            
            DepthFirstSearch dfs = new DepthFirstSearch(graph, origin, target);
            BreadthFirstSearch bfs = new BreadthFirstSearch(graph, origin, target);
            
            // Update path length statistics
            if (dfs.getPathLength() > maxPathDFS) maxPathDFS = dfs.getPathLength();
            if (dfs.getPathLength() < minPathDFS) minPathDFS = dfs.getPathLength();
            sumPathDFS = sumPathDFS.add(BigDecimal.valueOf(dfs.getPathLength()));
            
            if (bfs.getPathLength() > maxPathBFS) maxPathBFS = bfs.getPathLength();
            if (bfs.getPathLength() < minPathBFS) minPathBFS = bfs.getPathLength();
            sumPathBFS = sumPathBFS.add(BigDecimal.valueOf(bfs.getPathLength()));
            
            // Update visited vertices statistics
            if (dfs.getVisitedVertices() > maxVerticesDFS) maxVerticesDFS = dfs.getVisitedVertices();
            if (dfs.getVisitedVertices() < minVerticesDFS) minVerticesDFS = dfs.getVisitedVertices();
            sumVerticesDFS = sumVerticesDFS.add(BigDecimal.valueOf(dfs.getVisitedVertices()));
            
            if (bfs.getVisitedVertices() > maxVerticesBFS) maxVerticesBFS = bfs.getVisitedVertices();
            if (bfs.getVisitedVertices() < minVerticesBFS) minVerticesBFS = bfs.getVisitedVertices();
            sumVerticesBFS = sumVerticesBFS.add(BigDecimal.valueOf(bfs.getVisitedVertices()));
        }
        
        /* Path Length Statistics */
        System.out.println();
        System.out.println("         Path to Target");
        System.out.println("Method   Min    Max     Mean");
        System.out.println("DFS     " + String.format("%1$4s", minPathDFS) + "   " + String.format("%1$4s", maxPathDFS) + " " + String.format("%8.2f", (sumPathDFS.divide(BigDecimal.valueOf(t).setScale(2, RoundingMode.HALF_UP)))));
        System.out.println("BFS     " + String.format("%1$4s", minPathBFS) + "   " + String.format("%1$4s", maxPathBFS) + " " + String.format("%8.2f", (sumPathBFS.divide(BigDecimal.valueOf(t).setScale(2, RoundingMode.HALF_UP)))));
        
        /* Visited Vertices Statistics */
        System.out.println();
        System.out.println("         Visited Vertices");
        System.out.println("Method   Min     Max     Mean");
        System.out.println("DFS     " + String.format("%1$5s", minVerticesDFS) + "  " + String.format("%1$5s", maxVerticesDFS) + " " + String.format("%7.2f", (sumVerticesDFS.divide(BigDecimal.valueOf(t).setScale(2, RoundingMode.HALF_UP)))));
        System.out.println("BFS     " + String.format("%1$5s", minVerticesBFS) + "  " + String.format("%1$5s", maxVerticesBFS) + " " + String.format("%7.2f", (sumVerticesBFS.divide(BigDecimal.valueOf(t).setScale(2, RoundingMode.HALF_UP)))));
    }
}
