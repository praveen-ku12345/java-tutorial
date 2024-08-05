public class FloydWarshall {
    public static void main(String[] args) {
        int INF = Integer.MAX_VALUE;
        int[][] graph = {
            {0, INF, 3, INF},
            {2, 0, INF, INF},
            {INF, 7, 0, 1},
            {6, INF, INF, 0}
        };

        int numVertices = graph.length;

        // Initialize the distance matrix with the graph's adjacency matrix.
        int[][] distance = new int[numVertices][numVertices];
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                distance[i][j] = graph[i][j];
            }
        }

        // Perform the Floyd-Warshall algorithm
        for (int k = 0; k < numVertices; k++) {
            for (int i = 0; i < numVertices; i++) {
                for (int j = 0; j < numVertices; j++) {
                    if (distance[i][k] != INF && distance[k][j] != INF &&
                        distance[i][k] + distance[k][j] < distance[i][j]) {
                        distance[i][j] = distance[i][k] + distance[k][j];
                    }
                }
            }
        }

        // Print the shortest path matrix
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                if (distance[i][j] == INF) {
                    System.out.print("INF\t");
                } else {
                    System.out.print(distance[i][j] + "\t");
                }
            }
            System.out.println();
        }
    }
}
