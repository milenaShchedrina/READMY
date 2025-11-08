import java.util.List;
public class Main {

    public static void main(String[] args) {
        double[][] graph = GraphUtils.createTestGraph();
        int n = graph.length;

        GraphUtils.printMatrix(graph, "Начальная матрица расстояний:");

        FloydAlgorith.FloydResult result = FloydAlgorith.mayweather(graph);
        double[][] dist = result.getDistances();
        Integer[][] nextVertices = result.getNextVertices();


        GraphUtils.printMatrix(dist, "Финальная матрица кратчайших расстояний:");

        System.out.println("Все кратчайшие пути (по номерам вершин):");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    List<Integer> path = FloydAlgorith.getPath(i, j, nextVertices);
                    if (path != null) {
                        List<Integer> prettyPath = path.stream()
                                .map(vertex -> vertex + 1)
                                .toList();
                        System.out.printf("%d → %d: %s, длина %.0f%n",
                                i + 1, j + 1, prettyPath, dist[i][j]);
                    } else {
                        System.out.printf("%d → %d: пути нет%n", i + 1, j + 1);
                    }
                }
            }
        }
    }
}