public class TSP{
    public static void main(String[] args) {
        int[][] graph = {
            {0, 29, 20, 21},
            {29, 0, 15, 17},
            {20, 15, 0, 28},
            {21, 17, 28, 0}
        };

        int n = graph.length;
        int start = 0;

        boolean[] visited = new boolean[n];
        visited[start] = true;
         int minCost = tsp(graph, visited, start);

        System.out.println("Optimal TSP Cost: " + minCost);
    }

    static int tsp(int[][] graph, boolean[] visited, int current) {
        int n = graph.length;
        boolean allVisited = true;


        for (int i = 0; i < n; i++)
   {
            if (!visited[i]) 
      {
                allVisited = false;
                int minCost = Integer.MAX_VALUE;

                visited[i] = true;
                int cost = graph[current][i] + tsp(graph, visited, i);
                minCost = Math.min(minCost, cost);
                visited[i] = false;

                return minCost;
            }
        }

        if (allVisited && current != 0) {
            return graph[current][0];
        }

        return Integer.MAX_VALUE;
    }
}
