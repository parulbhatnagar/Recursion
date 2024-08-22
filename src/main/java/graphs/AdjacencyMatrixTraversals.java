package graphs;

public class AdjacencyMatrixTraversals {

    public static void main(String[] args) {
        // number of vertice = 7
        // edges = [[0,1],[0,2][1,3],[2,4],[3,5],[5,4],[4,3][5,6]]
        // source = 0
        // destination = 5

        // create a matrix for size 7X7 populcated with edge input
        int [][] edge = {{0,1},{0,2},{1,3},{2,4},{3,5},{5,4},{4,3},{5,6}};
        int source = 0;
        int destination = 5;

        int [][]graph = new int[7][7];
        for(int i = 0; i < edge.length; i++){
            graph[edge[i][0]][edge[i][1]] = 1;
            graph[edge[i][1]][edge[i][0]] = 1;
        }
        // print the adjacency matrix
        for(int i = 0; i < graph.length; i++){
            for(int j = 0; j < graph.length; j++){
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }

        boolean visitedVertices[] = new boolean[graph.length];
        bfs(graph, source,destination, visitedVertices);
        dfs(graph, source,destination, visitedVertices);

    }

    public static void dfs(int[][] graph, int index, int destination, boolean[] visitedVertices) {
        // base condition
        if (visitedVertices[index] == true) {
            return;
        }
        // do small work and recurse
        System.out.println(index);
        visitedVertices[index]= true;
        for (int i = 0; i < graph.length; i++) {
            if (graph[index][i] == 1) {
                dfs(graph, i, destination, visitedVertices);
            }
        }


    }

    public static void bfs(int[][] graph, int index, int destination, boolean[] visitedVertices) {

    }
}
