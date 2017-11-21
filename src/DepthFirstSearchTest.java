/**
 * @author Adalberto
 *
 */

import static org.junit.Assert.*;

import org.junit.Test;

public class DepthFirstSearchTest {

    @Test
    public void graphSize1() {
        Graph g = new Graph(1);
        DepthFirstSearch path = new DepthFirstSearch(g, 0, 0);
        assertEquals(0, path.getPathLength());
        assertEquals(1, path.getVisitedVertices());
    }    
    
    @Test
    public void graphSize2NotConnected() {
        Graph g = new Graph(2);
        DepthFirstSearch path = new DepthFirstSearch(g, 0, 1);
        assertEquals(-1, path.getPathLength());
        assertEquals(1, path.getVisitedVertices());
    }
    
    @Test
    public void graphSize2Connected() {
        Graph g = new Graph(2);
        g.addEdge(0, 1);
        DepthFirstSearch path = new DepthFirstSearch(g, 0, 1);
        assertEquals(1, path.getPathLength());
        assertEquals(2, path.getVisitedVertices());
    }    
   
    @Test
    public void testBestPathLength() {
        Graph g = new Graph(5);
        g.addEdge(0, 1);
        g.addEdge(0, 4);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        DepthFirstSearch path = new DepthFirstSearch(g, 0, 3);
        assertEquals(3, path.getPathLength());
        assertEquals(4, path.getVisitedVertices());
    }
    
    @Test
    public void testBacktracking() {
        Graph g = new Graph(5);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(2, 4);
        g.addEdge(2, 3);
        DepthFirstSearch path = new DepthFirstSearch(g, 0, 3);
        assertEquals(2, path.getPathLength());
        assertEquals(5, path.getVisitedVertices());
    }
    
    @Test
    public void graphSymmetric() {
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
        DepthFirstSearch path = new DepthFirstSearch(g, 0, 10);
        assertEquals(2, path.getPathLength());
        assertEquals(11, path.getVisitedVertices());
    }    

    @Test
    public void longestPathShortestLengthPath() {
        Graph g = new Graph(7);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(4, 5);
        g.addEdge(5, 6);
        g.addEdge(0, 1);
        g.addEdge(0, 6);        
        DepthFirstSearch path = new DepthFirstSearch(g, 0, 6);
        assertEquals(1, path.getPathLength());
        assertEquals(7, path.getVisitedVertices());
    }  
    
    @Test
    public void longestPathShortestLongestPath() {
        Graph g = new Graph(8);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(4, 5);
        g.addEdge(5, 6);
        g.addEdge(0, 1);
        g.addEdge(1, 7);        
        g.addEdge(7, 6);        
        DepthFirstSearch path = new DepthFirstSearch(g, 0, 6);
        assertEquals(6, path.getPathLength());
        assertEquals(7, path.getVisitedVertices());
    }  
    
}
