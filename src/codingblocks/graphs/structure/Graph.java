package codingblocks.graphs.structure;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Nikhil Bisht
 * @date 20-08-2020
 */
public class Graph {
    HashMap<String, Vertex> vertices;

    public Graph() {
        this.vertices = new HashMap<>();
    }


    public int numberOfVertices() {
        return vertices.size();
    }

    public boolean containsVertex(String vertex) {
        return vertices.containsKey(vertex);
    }

    public void addVertex(String vertex) {
        vertices.put(vertex, new Vertex());
    }

    public void removeVertex(String vertex) {
        // If vertex already doesnt exist
        if (!vertices.containsKey(vertex)) return;

        Vertex vertexToDel = vertices.get(vertex);

        // Remove the vertex from its neighbours' map of neighbors.
        HashMap<String, Integer> neighbors = vertexToDel.neighbors;
        for (String neighbor : neighbors.keySet()) {
            vertices.get(neighbor).neighbors.remove(vertex);
        }

        // Finally, remove the vertex from all vertices map.
        vertices.remove(vertex);
    }

    public int numberOfEdges() {
        AtomicInteger noEdges = new AtomicInteger();
        vertices.forEach((a, b) -> {
            noEdges.addAndGet(b.neighbors.size());
        });
        return noEdges.get() / 2; // Dividing by 2 as each edge is present in neighbor map of every vertex
    }

    public boolean containsEdge(String vertexA, String vertexB) {
        return (vertices.get(vertexA) != null
                && vertices.get(vertexB) != null)
                && vertices.get(vertexA).neighbors.containsKey(vertexB);
    }

    public void addEdge(String vertexA, String vertexB, int cost) {
        Vertex vertex1 = vertices.get(vertexA);
        Vertex vertex2 = vertices.get(vertexB);
        if (vertex1 == null || vertex2 == null || vertex1.neighbors.containsKey(vertexB))
            return; // If vertices don't exist or edge already exists

        // Otherwise, add the edge
        vertex1.neighbors.put(vertexB, cost);
        vertex2.neighbors.put(vertexA, cost);
    }

    public void removeEdge(String vertexA, String vertexB) {
        Vertex vertex1 = vertices.get(vertexA);
        Vertex vertex2 = vertices.get(vertexB);
        if (vertex1 == null || vertex2 == null || !vertex1.neighbors.containsKey(vertexB))
            return; // If vertices dont exist or if edge doesnt exist

        // Otherwise, add the edge
        vertex1.neighbors.remove(vertexB);
        vertex2.neighbors.remove(vertexA);
    }

    public void display() {
        System.out.println("-----------------------");
        vertices.forEach((vertex, nbrs) -> {
            System.out.println(vertex + " -> " + nbrs.neighbors);
        });
    }

    private class Vertex {
        HashMap<String, Integer> neighbors = new HashMap<>();
    }

}

