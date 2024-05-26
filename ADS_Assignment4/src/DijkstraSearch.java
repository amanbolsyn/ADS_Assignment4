import java.util.*;

public class DijkstraSearch<Vertex> extends Search<Vertex> {
    private final Set<Vertex> unsettledNodes;
    private final Map<Vertex, Double> dist;
    private final WeightedGraph<Vertex> graph;

    public DijkstraSearch(WeightedGraph<Vertex> graph, Vertex source) {
        super(source);
        unsettledNodes = new HashSet<>();
        dist = new HashMap<>();
        this.graph = graph;

        dijkstra();
    }

    private void dijkstra() {
        dist.put(source, 0D);
        unsettledNodes.add(source);

        while (!unsettledNodes.isEmpty()) {
            Vertex currentNode = getVertexWithMinimumWeight(unsettledNodes);

            marked.add(currentNode);
            unsettledNodes.remove(currentNode);

            for (Edge<Vertex> edge : graph.getEdges(currentNode)) {
                Vertex neighbor = edge.getDest();
                double newDistance = getShortestDistance(currentNode) + edge.getWeight();

                if (getShortestDistance(neighbor) > newDistance) {
                    dist.put(neighbor, newDistance);
                    edgeTo.put(neighbor, currentNode); // inverted adding
                    unsettledNodes.add(neighbor);
                }
            }
        }
    }

    private double getDistance(Vertex node, Vertex target) {
        for (Edge<Vertex> edge : graph.getEdges(node)) {
            if (edge.getDest().equals(target)) {
                return edge.getWeight();
            }
        }
        throw new RuntimeException("Not found!");
    }

    private Vertex getVertexWithMinimumWeight(Set<Vertex> vertices) {
        Vertex min = null;
        for (Vertex v : vertices) {
            if (min == null) {
                min = v;
                continue;
            }

            if (getShortestDistance(v) < getShortestDistance(min)) {
                min = v;
            }
        }
        return min;
    }

    private double getShortestDistance(Vertex destination) {
        Double d = dist.get(destination);
        return (d == null ? Double.MAX_VALUE : d);
    }
}