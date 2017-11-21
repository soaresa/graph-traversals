/**
 * @author Adalberto
 *
 */

import static org.junit.Assert.*;
import org.junit.Test;

public class BreadthFirstSearchTest {

    @Test
    public void testSize1Graph() {
        Graph g = new Graph(1);
        BreadthFirstSearch path = new BreadthFirstSearch(g, 0, 0);
        assertEquals(0, path.getPathLength());
        assertEquals(1, path.getVisitedVertices());
    }    
    
    @Test
    public void testSize2NotConnectedGraph() {
        Graph g = new Graph(2);
        BreadthFirstSearch path = new BreadthFirstSearch(g, 0, 1);
        assertEquals(-1, path.getPathLength());
        assertEquals(1, path.getVisitedVertices());
    }
    
    @Test
    public void testSize2ConnectedGraph() {
        Graph g = new Graph(2);
        g.addEdge(0, 1);
        BreadthFirstSearch path = new BreadthFirstSearch(g, 0, 1);
        assertEquals(1, path.getPathLength());
        assertEquals(2, path.getVisitedVertices());
    }    
    
    @Test
    public void testSymmetricGraph() {
        Graph g = new Graph(13);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(0, 3);
        g.addEdge(1, 4);
        g.addEdge(1, 5);
        g.addEdge(1, 6);
        g.addEdge(2, 7);
        g.addEdge(2, 8);
        g.addEdge(2, 9);
        g.addEdge(3, 10);
        g.addEdge(3, 11);
        g.addEdge(3, 12);
        BreadthFirstSearch path = new BreadthFirstSearch(g, 0, 10);
        assertEquals(2, path.getPathLength());
        assertEquals(7, path.getVisitedVertices());
    }   
    
    @Test
    public void testFindShortestPathOfMany() {
        Graph g = new Graph(13);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(0, 3);
        g.addEdge(1, 4);
        g.addEdge(1, 5);
        g.addEdge(1, 6);
        g.addEdge(2, 7);
        g.addEdge(2, 8);
        g.addEdge(2, 9);
        g.addEdge(7, 6);
        g.addEdge(8, 7);
        g.addEdge(9, 8);
        BreadthFirstSearch path = new BreadthFirstSearch(g, 0, 6);
        assertEquals(2, path.getPathLength());
        assertEquals(8, path.getVisitedVertices());
    }
}
