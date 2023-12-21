package ratings;

import java.util.ArrayList;
import java.util.HashMap;

public class Graph<N> {
    private HashMap<N, ArrayList<N>> adjacencyList;
    public Graph() {
        this.adjacencyList = new HashMap<>();
    }
    public void addEdge(N from, N to) {
        this.addNode(from);
        this.addNode(to);
        this.adjacencyList.get(from).add(to);
    }
    public void addBidirectionalEdge(N node1, N node2) {
        this.addNode(node1);
        this.addNode(node2);
        if (!this.adjacencyList.get(node1).contains(node2)) {
            this.adjacencyList.get(node1).add(node2);
        }
        if (!this.adjacencyList.get(node2).contains(node1)) {
            this.adjacencyList.get(node2).add(node1);
        }
        // Added if statements to make sure no duplicates are added
        // Given two actors, the above code will add them both to the graph if they don't already exist there, then will
        // check if the second actor is already in the first actor's adjacency list and will add them if they are not.
        // Then vice versa.
    }
    private void addNode(N a) {
        if (!this.adjacencyList.containsKey(a)) {
            this.adjacencyList.put(a, new ArrayList<>());
        }
    }
    public HashMap<N, ArrayList<N>> getAdjacencyList() {
        return adjacencyList;
    }
}