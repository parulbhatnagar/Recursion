package graphs;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Traversals {

    static class Edge {
        int source;
        int destination;
        int weight;

        Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return source + " -> " + destination + " weight = " + weight;
        }
    }
    public static void createGraph(ArrayList<Edge> graph[]) {

                /*
            1 ----- 3  \
            /       |    \
           0        |     5 -- 6
            \       |    /
            2 ----- 4  /
        */

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));
        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));
        graph[2].add(new Edge(2, 0, 1));

        graph[2].add(new Edge(2, 4, 1));
        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 5, 1));
        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));
        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 4, 1));
        graph[5].add(new Edge(5, 6, 1));
        graph[6].add(new Edge(6, 5, 1));

    }

    // dfs traversal
    public static void printInDFS(ArrayList<Edge>graph[], boolean visited[], int currIndex){

        if (visited[currIndex]== true){
            return;
        }

        var listOfEdges = graph[currIndex];
        visit(graph[currIndex], currIndex);
        visited[currIndex]=true;
        for (int i = 0; i < listOfEdges.size(); i++) {
            printInDFS(graph,visited,listOfEdges.get(i).destination);
        }
    }

    private static void visit(ArrayList<Edge> edges, int currIndex) {
        System.out.print(currIndex + " ");
    }


    // bfs traversal
    public static void printInBFS(ArrayList<Edge>graph[], boolean visited[], int start){

        Queue <Integer> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()){
            int node = queue.remove();
            if (visited[node] == false) {
                visit(graph[node], node);
                visited[node]=true;
                for (int i = 0; i < graph[node].size(); i++) {
                    queue.add(graph[node].get(i).destination);
                }
            }
        }


    }

    public static void printAdjacencyList(ArrayList<Edge> graph[]){
        for (int i = 0; i < graph.length; i++) {
            System.out.print(i + ": [");
            for (int j = 0; j < graph[i].size(); j++) {
                System.out.print("{" + graph[i].get(j).source + "," + graph[i].get(j).destination + "}");
            }
            System.out.println("]");
        }
    }

    // Given a matrix of m X n convert it into Adjacency list

    public static ArrayList<Edge>[] convertAdjacencyMatrixToAdjacencyList(int [][] input){
        ArrayList<Edge>graph[] = new ArrayList[input.length];
        for (int i = 0; i < input.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[i].length; j++) {
                if (input[i][j] == 1){
                    graph[i].add(new Edge(i,j,1));
                }
            }
        }
        return graph;
    }



    public static void main(String[] args) {
        int vertices = 7;
        ArrayList<Edge> graph[] = new ArrayList[vertices];
        boolean [] visited = new boolean[vertices];
        createGraph(graph);
        printAdjacencyList(graph);
        System.out.println("DFS Traversal");
        for (int i = 0; i < visited.length; i++) {
            if (visited[i] == false) {
                printInDFS(graph, visited, 0);
            }
        }
        System.out.println();
        System.out.println("BSF Traversal");

        visited = new boolean[vertices];
        for (int i = 0; i < visited.length; i++) {
            if (visited[i] == false) {
                printInBFS(graph, visited, 0);
            }
        }

        testIsland();


    }

    private static void testIsland() {
        int[][] grid = new int[][]{
                {1,1,1,1,0},
                {1,1,0,1,0},
                {1,1,0,0,0},
                {0,0,0,0,0}
        };

        int [][] grid2 = new int [][]{
                {1,1,0,0,0},
        {1,1,0,0,0},
        {0,0,1,0,0},
        {0,0,0,1,1}
        };
        System.out.println();
        System.out.println("Testing islands");

        ArrayList<Edge> graph[] = convertAdjacencyMatrixToAdjacencyList(grid);

        printAdjacencyList(graph);

        boolean visited[] = new boolean[graph.length];
        int countOfIslands = 0;
        for (int i = 0; i < visited.length; i++) {
            if (visited[i] == false){
                printInDFS(graph,visited,0);
                countOfIslands ++;
            }
        }
        System.out.println("Number of islands: " + countOfIslands);

        System.out.println("Second testcase");
        visited = new boolean[graph.length];
        countOfIslands = 0;
        graph = convertAdjacencyMatrixToAdjacencyList(grid2);
        for (int i = 0; i < visited.length; i++) {
            if (visited[i] == false){
                printInDFS(graph,visited,0);
                countOfIslands ++;
            }
        }
        System.out.println("Number of islands: " + countOfIslands);

    }
}
