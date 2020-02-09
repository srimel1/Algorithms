
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.*;

public class MST {

}

class Graph1 {
    Set<Character> nodes;
    Edge[] edges;
    int count, E, V;

    public Graph1(int v, int e) {
        this.V = v;
        this.E = e;
        count = 0;

        edges = new Edge[E];
        nodes = new HashSet<>();


    }

    public void addEdge(char src, char dest, int weight) {

        if(!nodes.contains(src)) nodes.add(src);
        if(!nodes.contains(dest)) nodes.add(dest);
        edges[count++] = new Edge(src, dest, weight);

    }
    public void calculateKruskalMST() {

        Edge[] A = new Edge[V - 1];
        UF uf = new UF(nodes);
        Arrays.sort(edges);
        int e = 0;
        for (Edge edge : edges) {
            if(uf.find(edge.src) == uf.find(edge.dest)) continue;
            A[e++] = new Edge(edge.src, edge.dest, edge.weight);
            uf.union(edge.src, edge.dest);

        }

    }
    public static int count(){
        return 0;
    }
}
