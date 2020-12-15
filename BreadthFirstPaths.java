import java.util.LinkedList;

public class BreadthFirstPaths extends Path {

    public BreadthFirstPaths(Graph g, int source) {
        super(g, source);
        bfs(g, source);
    }

    private void bfs(Graph g, int source) {
        LinkedList<Integer> queue = new LinkedList<>();
        queue.addLast(source);
        marked[source] = true;
        while (!queue.isEmpty()) {
            int vertex = queue.removeFirst();
            for (int w : g.getAdjList(vertex)) {
                if (!marked[w]) {
                    marked[w] = true;
                    edgeTo[w] = vertex;
                    queue.addLast(w);
                }
            }
        }
    }

    private boolean bfs(Graph g, int source, int dest, int[] pred, int[] dist) {
        LinkedList<Integer> queue = new LinkedList<>();

        // обнуляем массивы посещенных вершин и расстоний
        for (int i = 0; i < g.getVertexCount(); i++) {
            marked[i] = false;
            dist[i] = Integer.MAX_VALUE;
            pred[i] = -1;
        }

        marked[source] = true;
        dist[source] = 0;
        queue.addLast(source);

        while (!queue.isEmpty()) {
            int vertex = queue.removeFirst();
            LinkedList<Integer> adj = g.getAdjList(vertex);
            for (int i = 0; i < adj.size(); i++) {
                if (!marked[adj.get(i)]) {
                    marked[adj.get(i)] = true;
                    dist[adj.get(i)] = dist[vertex] + 1;
                    pred[adj.get(i)] = vertex;
                    queue.addLast(adj.get(i));

                    if (adj.get(i) == dest) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public void printShortestPath(Graph g, int source, int dest) {
        // массив для хранения предков текущей вершины
        int[] pred = new int[g.getVertexCount()];
        // массив для хранения рассояния до текущей вершины
        int[] dist = new int[g.getVertexCount()];
        LinkedList<Integer> path = new LinkedList<>();

        if (!bfs(g, source, dest, pred, dist)) {
            System.out.println("Source and destination are not connected!");
            return;
        }

        int crawl = dest;
        path.add(crawl);
        while (pred[crawl] != -1) {
            path.add(pred[crawl]);
            crawl = pred[crawl];
        }

        // Print distance
        System.out.println("Shortest path length is: " + dist[dest]);

        // Print path
        System.out.println("Path is ::");
        for (int i = path.size() - 1; i >= 0; i--) {
            System.out.print(path.get(i) + " ");
        }
    }
}