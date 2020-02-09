import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class GraphMST {

    public static void main(String[] args) {

        // graph has 9 nodes, 14 edges
        Graph g = new Graph(9, 14);

        g.addEdge('a', 'b', 4);
        g.addEdge('a', 'h', 8);
        g.addEdge('b', 'h', 11);
        g.addEdge('b', 'c', 8);
        g.addEdge('c', 'd', 7);
        g.addEdge('c', 'i', 2);
        g.addEdge('c', 'f', 4);
        g.addEdge('d', 'e', 9);
        g.addEdge('d', 'f', 14);
        g.addEdge('e', 'f', 10);
        g.addEdge('f', 'g', 2);
        g.addEdge('g', 'i', 6);
        g.addEdge('g', 'h', 1);
        g.addEdge('h', 'i', 7);

        g.calculateKruskalMST();

    }

}

class Graph {

    Set<Character> nodes;
    Edge[] edges;
    int count, E, V;

    public Graph(int v, int e) {

        this.V = v;
        this.E = e;
        count = 0;

        edges = new Edge[E];
        nodes = new HashSet<>();

    }

    public void addEdge(char src, char dest, int weight) {

        if (!nodes.contains(src)) nodes.add(src);
        if (!nodes.contains(dest)) nodes.add(dest);
        edges[count++] = new Edge(src, dest, weight);
    }

    public void calculateKruskalMST() {

        Edge[] A = new Edge[V - 1];

        // this is the same as MAKE-SET()
        UF uf = new UF(nodes);

        // step 1: sort the edges
        Arrays.sort(edges);


        int e = 0;
        for (Edge edge : edges) {

            // if this edge causes a cycle, we pick the next one
            if (uf.find(edge.src) == uf.find(edge.dest)) continue;

            // find the edge that does not form a cycle
            A[e++] = new Edge(edge.src, edge.dest, edge.weight);
            uf.union(edge.src, edge.dest);
        }

        // print out the result
        System.out.println("MST has the following edges:");
        for (Edge edge : A) {
            System.out.print("(" + edge.src + ", " + edge.dest + ")  ");
        }
    }

}

class UF {
    class subset {
        int parent;
        int rank;
    }

    ;
    int[] parents, rank;

    public UF(Set<Character> nodes) {
        parents = new int[26];
        for (char c : nodes) {
            parents[c - 'a'] = c - 'a';
        }
    }

    public void union(char u, char v) {


        int rootu = find(u);
        int rootv = find(v);

        if (parents[rootu] < parents[rootv])
            parents[rootu] = rootv;
        else if (parents[rootu] > parents[rootv])
            parents[rootv] = rootu;
        else {
            parents[rootv] = rootu;
            parents[rootu]++;
        }

    }

    public int find(char u) {
        if (parents[u - 'a'] == u - 'a') return u - 'a';
        else return find((char) ('a' + parents[u - 'a']));
    }

}

class Edge implements Comparable<Edge> {

    char src, dest;
    int weight;

    public Edge(char src, char dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }

    public int compareTo(Edge e) {
        return this.weight - e.weight;
    }


}
