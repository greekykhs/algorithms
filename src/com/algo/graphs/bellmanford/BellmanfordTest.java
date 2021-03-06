package com.algo.graphs.bellmanford;

import java.util.Iterator;
public class BellmanfordTest {

	public static void main(String[] args) {
		Graph g = new Graph(5);
        g.addEdge(0, 1, 5.2f);
        g.addEdge(0, 3, 12.8f);
        g.addEdge(0, 2, 10.3f);
        g.addEdge(1, 3, 5.9f);
        g.addEdge(1, 4, 15.2f);
        g.addEdge(2, 1, 1.5f);
        g.addEdge(2, 3, 2.3f);
        g.addEdge(3, 4, 8.5f);
        g.addEdge(4, 2, 2.7f);
		System.out.println("Printing the graph..");
        g.printGraph();

	}
	public static void BellmanFord(Graph g, int startVertex) {
        // for storing distances
        float[] distances = new float[g.getvCount()];
        // for storing predecessors
        int[] predecessors = new int[g.getvCount()];
 
        // initialize arrays
        for (int i = 0; i < distances.length; i++) {
            distances[i] = Float.MAX_VALUE;
            predecessors[i] = -1;
        }
        distances[startVertex] = 0;
 
        // relax all edges v - 1 times repeatedly
        for (int i = 1; i < g.getvCount() - 1; i++) {
            for (int j = 0; j < g.getvCount() - 1; j++) {
                Iterator<Edge> it = g.neighbours(j).iterator();
                while (it.hasNext()) {
                    Edge e = it.next(); // edge (u, v)
                    // if dist(u) + w(u, v) < dist(v) then
                    // dist(v) = dist(u) + w(u, v)
                    // pred(v) = u
                    if (distances[e.getStartPoint()] + e.getWeight() < distances[e.getEndPoint()]) {
                        distances[e.getEndPoint()] = distances[e.getStartPoint()] + e.getWeight();
                        predecessors[e.getEndPoint()] = e.getStartPoint();
                    }
                }
            }
        }
 
        // check for negative-weight circles
        for (int i = 0; i < g.getvCount() - 1; i++) {
            Iterator<Edge> it = g.neighbours(i).iterator();
            while (it.hasNext()) {
                Edge e = it.next(); // edge (u, v)
                // if dist(u) + w(u, v) < dist(v) then
                // graph contains negative-weight circle
                if (distances[e.getStartPoint()] + e.getWeight() < distances[e.getEndPoint()]) {
                    System.out.println("Graph contains negative-weight circle!");
                    return;
                }
            }
        }
 
        // print final shortest paths
        System.out.println("Vertex\tDistance\tPredecessor");
        for (int i = 0; i < g.getvCount(); i++) {
            System.out.println(i + "\t" + distances[i] + "\t\t" + predecessors[i]);
        }
 
    }
}
