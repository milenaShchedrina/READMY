import java.util.ArrayList;
import java.util.List;


public class FloydAlgorith {
    public static class FloydResult {
        private final double[][] distances;
        private final Integer[][] nextVertices;

        public FloydResult(double[][] distances, Integer[][] nextVertices) {
            this.distances = distances;
            this.nextVertices = nextVertices;
        }

        public double[][] getDistances() {
            return distances;
        }

        public Integer[][] getNextVertices() {
            return nextVertices;
        }
    }

    public static FloydResult mayweather(double[][] graph) {
        int n = graph.length;
        double[][] dist = new double[n][n];
        Integer[][] nextVertices = new Integer[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = graph[i][j];
                if (graph[i][j] != Double.POSITIVE_INFINITY && i != j) {
                    nextVertices[i][j] = j;
                } else {
                    nextVertices[i][j] = null;
                }
            }
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                        nextVertices[i][j] = nextVertices[i][k];
                    }
                }
            }
        }

        return new FloydResult(dist, nextVertices);
    }

    public static List<Integer> getPath(int start, int end, Integer[][] nextVertices) {
        if (nextVertices[start][end] == null) {
            return null;
        }

        List<Integer> path = new ArrayList<>();
        path.add(start);

        int current = start;
        while (current != end) {
            current = nextVertices[current][end];
            path.add(current);
        }

        return path;
    }
}
