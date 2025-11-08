public class GraphUtils {
    public static double[][] createTestGraph() {
        double INF = Double.POSITIVE_INFINITY;

        return new double[][] {
                {0,   3,  5,  2},
                {3,   0,  2, INF},
                {5,   2,  0,  1},
                {2, INF,  1,  0}
        };
    }
    public static void printMatrix(double[][] matrix, String title) {
        int n = matrix.length;

        System.out.println(title);
        System.out.print("   ");
        for (int col = 0; col < n; col++) {
            System.out.printf("%5d ", col + 1);
        }
        System.out.println();

        for (int i = 0; i < n; i++) {
            System.out.printf("%2d ", i + 1);
            for (int j = 0; j < n; j++) {
                String value;
                if (matrix[i][j] == Double.POSITIVE_INFINITY) {
                    value = "  inf ";
                } else {
                    value = String.format("%5.0f ", matrix[i][j]);
                }
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    public static void printNextVertices(Integer[][] nextVertices, String title) {
        int n = nextVertices.length;

        System.out.println(title);
        System.out.print("   ");
        for (int col = 0; col < n; col++) {
            System.out.printf("%5d ", col + 1);
        }
        System.out.println();

        for (int i = 0; i < n; i++) {
            System.out.printf("%2d ", i + 1);
            for (int j = 0; j < n; j++) {
                String value = (nextVertices[i][j] == null) ? "  null" :
                        String.format("%5d", nextVertices[i][j] + 1);
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}