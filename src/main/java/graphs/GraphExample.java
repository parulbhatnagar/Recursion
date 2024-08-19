package graphs;

import java.util.*;

public class GraphExample {

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

    public static void bfs(ArrayList<Edge> graph[], int vertices) {

        boolean visitedVertices[] = new boolean[graph.length];
        Queue<Integer> queue = new ArrayDeque<>();

        // initialize the queue
        queue.add(3);
        // level print
        while (!queue.isEmpty()) {
            Integer curr = queue.remove();
            if (visitedVertices[curr] != true) {

                // 1. print vertices
                System.out.println(curr);
                // 2. add it to visited
                visitedVertices[curr] = true;
                // 3. add vertices connections in the queue
                for (int i = 0; i < graph[curr].size(); i++) {
                    queue.add(graph[curr].get(i).destination);
                }
            }
        }
    }

    public static void dfs(ArrayList<Edge> graph[], int index, boolean visitedVertices[]) {
        var curr = graph[index];
        // base condition
        if (visitedVertices[index] == true) {
            return;
        }

        // do small work and recurse
        System.out.println(index);
        visitedVertices[index]= true;
        for (int i = 0; i < curr.size(); i++) {
            dfs(graph, curr.get(i).destination, visitedVertices);
        }

    }

    public static void dfsAllRoutes(ArrayList<Edge> graph[], boolean visitedVertices[], int start, int end, String route){
        if (start == end){
            System.out.println(route + end);
            return;
        }

        var curr = graph[start];
        for (int i = 0; i < curr.size() ; i++) {
            if (visitedVertices[start] !=true){
            visitedVertices[start] = true;
            dfsAllRoutes(graph, visitedVertices, curr.get(i).destination,end, route+ start);
            visitedVertices[start] = false;}
        }
    }



    public static void main(String[] args) {
        /*
            1 ----- 3  \
            /       |    \
           0        |     5 -- 6
            \       |    /
            2 ----- 4  /
        */
        int vertices=7;

        ArrayList<Edge> graph[] = new ArrayList[vertices];

        boolean visitedVertices[] = new boolean[vertices];
        createGraph(graph);
        System.out.println("bfs:");

        bfs(graph, vertices);

        System.out.println("dfs");

        //dfs (graph, 0, visitedVertices);

        dfsAllRoutes( graph, visitedVertices, 0,5, "");



        /*for(int i = 0; i < vertices; i++){
            System.out.println(i + " -> " + graph[i].toString());
        }*/
    }
}
