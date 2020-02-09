import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;


public class GraphDijkstra {

    public static void main(String[] args) {

        Graph2 g = new Graph2(5);

        // note this is different from textbook
        // we are using numbers as node id
        // the graph is on textbook pg. 659
        g.addEdge(0, 1, 10);
        g.addEdge(0, 3, 5);
        g.addEdge(1, 2, 1);
        g.addEdge(1, 3, 2);
        g.addEdge(2, 4, 4);
        g.addEdge(3, 1, 3);
        g.addEdge(3, 2, 9);
        g.addEdge(3, 4, 2);
        g.addEdge(4, 2, 6);
        g.addEdge(4, 0, 7);

        // calculate shortest path from 0
        g.calculateShortestPath(0);
        g.print();
    }

}

class Graph2 {

    int V;
    LinkedList<Node>[] adjListArray;

    // a list holds all the nodes whose final shortest-path weights are determined
    // a list can also keep the order in which items are added
    List<Node> settled = new LinkedList<>();

    public Graph2(int V) {
        this.V = V;
        adjListArray = new LinkedList[V];
        for(int i = 0; i < V ; i++){
            adjListArray[i] = new LinkedList<>();
        }
    }

    public void addEdge(int src, int dest, int weight) {

        // edge: (src, dest), weight
        Node node = new Node(dest, weight);

        // Add an edge from src to dest.
        adjListArray[src].add(node);

    }

    public void calculateShortestPath(int src) {

        // get the source node, set its distance to 0
        // all others nodes still have the distance set to MAX_VALUE;
        Node source = new Node(src, 0);
        source.distance = 0;

        // create the queue, and do NOT put everything to queue
        // Q = G.V in Dijkstra(G, w, s) in textbook: puts everything in queue
        // but in Java, queue does not update itself
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(source);

        while ( settled.size() != V ) {

            Node node = pq.poll();
            settled.add(node);

            // relax all its neighbors
            List<Node> neighbors = adjListArray[node.id];
            for ( Node nei : neighbors ) {
                if ( settled.contains(nei) ) continue;
                if ( node.distance + nei.weight < nei.distance ) {
                    nei.distance = node.distance + nei.weight;
                    // add this to the queue
                    pq.offer(nei);
                }
            }

        }

    }

    public void print() {
        for (Node node : settled ) {
            System.out.println("node-" + node.id + " distance from source: " + node.distance);
        }
    }
}


class Node implements Comparable<Node> {

    int id;
    int parent;
    int distance;
    int weight;

    public Node(int id, int weight) {
        this.id = id;
        this.weight = weight;
        parent = 0;
        distance = Integer.MAX_VALUE;
    }
    public int compareTo(Node node) {
        return this.distance - node.distance;
    }

}