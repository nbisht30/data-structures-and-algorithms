package implementations.graphs.structure;

/**
 * @author Nikhil Bisht
 * @date 26-08-2020
 */
public class GraphClient {
    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");
        graph.addVertex("G");

        graph.addEdge("A", "B", 2);
        graph.addEdge("A", "D", 3);
        graph.addEdge("B", "C", 1);
        graph.addEdge("C", "D", 8);
        graph.addEdge("D", "E", 10);
        graph.addEdge("E", "F", 45);
        graph.addEdge("E", "G", 7);
        graph.addEdge("F", "G", 8);

        graph.display();

        System.out.println("# Edges: " + graph.numberOfEdges());
        System.out.println("# Vertices: " + graph.numberOfVertices());
        System.out.println("Contains A - C?: " + graph.containsEdge("A", "C"));
        System.out.println("Contains E - F?: " + graph.containsEdge("E", "F"));
        graph.removeEdge("E", "F");
        System.out.println("Contains E - F?: " + graph.containsEdge("E", "F"));
        graph.removeVertex("A");
        graph.display();
        graph.addVertex("A");
        graph.display();
        graph.addEdge("A", "F", 20);
        graph.display();

        // Path
        System.out.println("Contains path b/w B - E? " + graph.hasPath("B", "E"));
        System.out.println("Contains path b/w A - F? " + graph.hasPath("A", "F"));
        System.out.println("Contains path b/w A - B? " + graph.hasPath("A", "B"));
        graph.removeEdge("E", "G");
        System.out.println("Removed edge E - G");
        System.out.println("Contains path b/w A - B? " + graph.hasPath("A", "B"));
    }
}
