
public class Main {

    public static void main(String[] args) {


        MyGraph<String> graph = new MyGraph<>(true);
        fillWithoutWeights(graph);

        System.out.println("DFS:");
        Search<String> dfs = new DepthFirstSearch<>(graph, "Dinara");
        outputPath(dfs, "Zhanylsha");


        System.out.println("BFS:");
        Search<String> bfs = new BreadthFirstSearch<>(graph, "Dinara");
        outputPath(bfs, "Zhanylsha");

        WeightedGraph<String> weightedGraph = new WeightedGraph<>(true);
        fillWithWeights(weightedGraph);

        System.out.println("Dijkstra:");
        Search<String> djk = new DijkstraSearch<>(weightedGraph, "Dinara");
        outputPath(djk, "Zhanylsha");

    }

    public static void fillWithoutWeights(MyGraph<String> graph) {
        graph.addEdge("Aman", "Dinara"); // 16 - 19
        graph.addEdge("Dinara", "Gulnar");
        graph.addEdge("Dinara", "Zhanylsha");
        graph.addEdge("Aman", "Gulnar");
    }

    public static void fillWithWeights(WeightedGraph<String> graph) {
        graph.addEdge("Aman", "Dinara", 2.1);
        graph.addEdge("Dinara", "Gulnar", 7.8);
        graph.addEdge("Dinara", "Zhanylsha", 7.1);
        graph.addEdge("Aman", "Gulnar", 7.2);
    }

    public static void outputPath(Search<String> search, String key) {
        for (String v : search.pathTo(key)) {
            System.out.print(v + " -> ");
        }

        System.out.println();
    }
}