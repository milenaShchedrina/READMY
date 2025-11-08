import java.util.List;
public class PathAnalyzer {

    public static void printDetailedAnalysis(double[][] graph, FloydAlgorith.FloydResult result) {
        int n = graph.length;
        double[][] dist = result.getDistances();
        Integer[][] nextVertices = result.getNextVertices();


        System.out.println("ДЕТАЛЬНЫЙ АНАЛИЗ ПУТЕЙ");


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    System.out.printf("%nПуть из %d в %d:%n", i + 1, j + 1);

                    List<Integer> path = FloydAlgorith.getPath(i, j, nextVertices);

                    if (path != null) {
                        System.out.printf("  Длина пути: %.0f%n", dist[i][j]);
                        System.out.printf("  Вершины пути: %s%n",
                                path.stream().map(v -> v + 1).toList());

                        System.out.print("  Ребра пути: ");
                        for (int k = 0; k < path.size() - 1; k++) {
                            int from = path.get(k);
                            int to = path.get(k + 1);
                            double weight = graph[from][to];
                            System.out.printf("%d→%d(%.0f)", from + 1, to + 1, weight);
                            if (k < path.size() - 2) {
                                System.out.print(" → ");
                            }
                        }
                        System.out.println();
                    } else {
                        System.out.println("  Пути не существует");
                    }
                }
            }
        }
    }
}