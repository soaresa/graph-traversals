/**
 * @author Adalberto
 *
 */

import java.util.Stack;

/**
 * This class implements DFS algorithm to find the first path between two vertices.
 * It also stores the number of visited nodes during the search.
 */
public class DepthFirstSearch {
    private int visitedVertices;        // number of visited vertices during search
    private int pathLength;             // path length found from origin to target
    private final int[] pathLengths;    // distance + 1 from origin to each vertex, also tells if a vertex was visited
    
    public DepthFirstSearch(Graph g, int origin, int target) {
        this.visitedVertices = 0;
        this.pathLengths = new int[g.getSize()];
        this.pathLengths[origin] = 1;   // avoid visiting origin multiple times
        findPath(g, origin, target);
    }
       
    private void findPath(Graph g, int origin, int target) {       
        Stack<Integer> s = new Stack<>();
        s.push(origin);
               
        this.pathLength = 0;
        while (!s.isEmpty() && this.pathLength == 0) {
            this.visitedVertices++;
            int next = s.pop();
            if (next == target) {
                /* found target */
                this.pathLength = this.pathLengths[next];
                continue;
            }
            for (int adjacency : g.adj(next)) {
                /* push to stack only unvisited adjacent vertices*/
                if (this.pathLengths[adjacency] == 0) {
                    this.pathLengths[adjacency] = this.pathLengths[next] + 1;
                    s.push(adjacency);
                }
            }
        }
    }

    public int getPathLength() {
        return this.pathLength - 1; // -1 == not found
    }

    public int getVisitedVertices() {
        return this.visitedVertices;
    }
    
    /*private int findPathRecursive(Graph g, int origin, int target) {
        this.visitedVertices++;
        if (origin == target) {
            this.pathLength = this.pathLengths[origin];
            return this.pathLength;
        }
        for (int connection : g.adj(origin)) {
            if (this.pathLengths[connection] == 0) {
                this.pathLengths[connection] = this.pathLengths[origin] + 1;
                int result = findPathRecursive(g, connection, target);
                if (result > 0) {
                    this.pathLength = result;
                    break;
                }
            }
        }
        return this.pathLength;
    }*/
}