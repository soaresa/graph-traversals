/**
 * @author Adalberto
 *
 */

import edu.princeton.cs.algs4.Queue;

/**
 * This class implements BFS algorithm to find the path between two vertices.
 * It also stores the number of visited nodes during search.
 */
public class BreadthFirstSearch {
    private int visitedVertices;        // number of visited vertices during path find
    private int pathLength;             // path length found from origin to target. -1 if not found. 
    private final int[] pathLengths;    // distance from origin to each vertex, also tells if a vertex was visited
    
    public BreadthFirstSearch(Graph g, int origin, int target) {
        this.visitedVertices = 0;
        this.pathLengths = new int[g.getSize()];
        this.pathLengths[origin] = 1;
        findPath(g, origin, target);
    }
    
    private void findPath(Graph g, int origin, int target) {
        Queue<Integer> q = new Queue<>();
        q.enqueue(origin);
        
        while(!q.isEmpty() && this.pathLength == 0) {
            this.visitedVertices++;
            int next = q.dequeue();
            if (next == target) {
                /* found target */
                this.pathLength = this.pathLengths[next];
                continue;
            }
            for (int adjacencies : g.adj(next)) {
                /* enqueue only unvisited adjacent vertices */
                if (this.pathLengths[adjacencies] == 0) {
                    this.pathLengths[adjacencies] = this.pathLengths[next] + 1;
                    q.enqueue(adjacencies);
                }
            }            
        }
    }
    
    public int getVisitedVertices() {
        return this.visitedVertices;
    }

    public int getPathLength() {
        return this.pathLength - 1;  // -1 == not found (origin not connected to target)
    }
}
