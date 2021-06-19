package leetcode.categorized.graphs.sssp.dijkstra;

import java.util.*;

class P787CheapestFlightsWithinKStops {

    // EXPLANATION: https://leetcode.com/problems/cheapest-flights-within-k-stops/discuss/1211593/Dijkstra's-Java-solution-with-Explanation
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        PriorityQueue<City> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a.distanceFromSrc));
        minHeap.offer(new City(src, 0, 0));

        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[src] = 0;

        int[] stops = new int[n];
        Arrays.fill(stops, Integer.MAX_VALUE);
        stops[src] = 0;

        LinkedList<Edge>[] adjList = getAdjacencyList(flights, n);

        while (!minHeap.isEmpty()) {

            City city = minHeap.poll();

            if (city.index == dst) return city.distanceFromSrc;

            if (city.stopsFromSrc > k) continue;

            LinkedList<Edge> edgesFromCity = adjList[city.index];

            if (Objects.nonNull(edgesFromCity)) {
                Iterator<Edge> itr = edgesFromCity.iterator();
                while (itr.hasNext()) {
                    Edge edgeFromCity = itr.next();
                    int nextCity = edgeFromCity.to;
                    int newNextCityDist = edgeFromCity.cost + city.distanceFromSrc;
                    int currCityStops = city.stopsFromSrc;

                    if (newNextCityDist < distance[nextCity]) {
                        distance[nextCity] = newNextCityDist;
                        minHeap.offer(new City(nextCity, newNextCityDist, currCityStops + 1));
                    } else if (currCityStops < stops[nextCity]) {
                        minHeap.offer(new City(nextCity, newNextCityDist, currCityStops + 1));
                    }
                    stops[nextCity] = currCityStops;
                }
            }
        }

        return distance[dst] == Integer.MAX_VALUE ? -1 : distance[dst];
    }

    LinkedList<Edge>[] getAdjacencyList(int[][] graph, int n) {
        LinkedList<Edge>[] adj = new LinkedList[n];
        for (int i = 0; i < graph.length; i++) {
            int from = graph[i][0];
            int to = graph[i][1];
            int cost = graph[i][2];
            if (adj[from] == null) adj[from] = new LinkedList<>();
            adj[from].add(new Edge(to, cost));
        }
        return adj;
    }

    class Edge {
        int to;
        int cost;

        Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    // For priority queue entries
    class City {
        int index;
        int distanceFromSrc;
        int stopsFromSrc;

        City(int index, int cost, int stopsFromSrc) {
            this.index = index;
            this.distanceFromSrc = cost;
            this.stopsFromSrc = stopsFromSrc;
        }
    }
}