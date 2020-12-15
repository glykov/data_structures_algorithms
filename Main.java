/**
 * Реализовать программу, в которой задается граф из 10 вершин. Задать ребра и
 * найти кратчайший путь с помощью поиска в ширину.
 */

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph(10);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(3, 5);
        graph.addEdge(4, 5);
        graph.addEdge(4, 6);
        graph.addEdge(5, 6);
        graph.addEdge(6, 7);
        graph.addEdge(6, 8);
        graph.addEdge(7, 8);
        graph.addEdge(7, 8);
        graph.addEdge(8, 9);

        // System.out.println(graph.getAdjList(1));

        // DepthFirstPaths dfp = new DepthFirstPaths(graph, 2);
        // System.out.println(dfp.hasPathTo(0));
        // System.out.println(dfp.pathTo(0));

        // BreadthFirstPaths bfp = new BreadthFirstPaths(graph, 2);
        // System.out.println(bfp.hasPathTo(0));
        // System.out.println(bfp.pathTo(0));

        BreadthFirstPaths bfp = new BreadthFirstPaths(graph, 0);
        bfp.printShortestPath(graph, 1, 9);

    }
}
