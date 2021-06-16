package leetcode.solved.categorized.graphs.sssp.dijkstra;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;

class P1514PathWithMaximumProbability {
    // MYSELF
    // TIME: 25 mins
    // DATE: 16-06-2021, first attempt
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        LinkedList<Edge>[] graph = getGraph(n, edges, succProb);
        
        PriorityQueue<Node> maxHeap = new PriorityQueue<Node>
            ((a, b) -> (b.probTillNow > a.probTillNow ? 1 : -1)); 
        // made a stupid mistake here, instead of returning -1, returned 0, rest of the logic was correct, wasted 7 mins on this
        maxHeap.add(new Node(start, 1));
        
        double[] prob = new double[n];
        prob[start] = 1.0;
        boolean[] vis = new boolean[n];
        while(!maxHeap.isEmpty()) {
            
            Node from = maxHeap.poll();
            if(from.index == end) return prob[end];
            if(from.probTillNow < prob[from.index]) continue;
            
            vis[from.index] = true;
            LinkedList<Edge> neighbors = graph[from.index];
            if(neighbors == null) continue;
            Iterator<Edge> itr = neighbors.iterator();
            while(itr.hasNext()) {
                Edge edge = itr.next();
                if(vis[edge.to]) continue;
                double nextProb = edge.prob * from.probTillNow;
                if(nextProb > prob[edge.to]) {
                    prob[edge.to] = nextProb;
                    maxHeap.offer(new Node(edge.to, nextProb));
                }
            }
        }
        
        return prob[end];
    }
    
    LinkedList<Edge>[] getGraph(int n, int[][] edges, double[] prob) {
        LinkedList<Edge>[] graph = new LinkedList[n];
        for(int i = 0; i < edges.length; i++) {
            int from = edges[i][0];
            int to = edges[i][1];
            if(graph[from] == null) graph[from] = new LinkedList<>();
            if(graph[to] == null) graph[to] = new LinkedList<>();
            graph[from].add(new Edge(to, prob[i]));
            graph[to].add(new Edge(from, prob[i]));
        }
        return graph;
    }
    
    class Edge {
        int to;
        double prob;
        
        Edge(int to, double prob) {
            this.to = to;
            this.prob = prob;
        }
    }
    
    
    class Node {
        int index;
        double probTillNow;
        
        Node(int index, double probTillNow) {
            this.index = index;
            this.probTillNow = probTillNow;
        }
    }
}