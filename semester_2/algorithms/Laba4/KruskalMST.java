package semester_2.algorithms.Laba4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class KruskalMST {

    //ребро графа
    static class Edge {
        int src, dest, weight;

        public Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return String.format("(%d, %d) = %d", src, dest, weight);
        }
    }

    // Клас для структури "union-find"
    static class UnionFind {
        int[] parent, rank;

        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }

        // Пошук кореня для елемента з компресією шляху
        public int find(int i) {
            if (parent[i] != i) {
                parent[i] = find(parent[i]);
            }
            return parent[i];
        }

        // Об’єднання двох підмножин за ранговою політикою
        public void union(int x, int y) {
            int xRoot = find(x);
            int yRoot = find(y);

            if (xRoot == yRoot)
                return;

            if (rank[xRoot] < rank[yRoot]) {
                parent[xRoot] = yRoot;
            } else if (rank[xRoot] > rank[yRoot]) {
                parent[yRoot] = xRoot;
            } else {
                parent[yRoot] = xRoot;
                rank[xRoot]++;
            }
        }
    }

    // Метод для перетворення матриці вагів у список ребер
    public static List<Edge> matrixToEdgeList(int[][] matrix) {
        int n = matrix.length;
        List<Edge> edges = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                // 0 означає відсутність ребра
                if (matrix[i][j] != 0) {
                    edges.add(new Edge(i, j, matrix[i][j]));
                }
            }
        }
        return edges;
    }

    // Метод, що реалізує алгоритм Крускала та повертає мінімальне покриваюче дерево як список ребер
    public static List<Edge> kruskalMST(int[][] matrix) {
        int n = matrix.length;
        List<Edge> edges = matrixToEdgeList(matrix);
        
        edges.sort(Comparator.comparingInt(e -> e.weight));

        UnionFind uf = new UnionFind(n);

        List<Edge> result = new ArrayList<>();

        for (Edge edge : edges) {
            int x = uf.find(edge.src);
            int y = uf.find(edge.dest);

            // Якщо додавання ребра не створює цикл, додаємо його до результату
            if (x != y) {
                result.add(edge);
                uf.union(x, y);
            }

            // Якщо вже знайдено n-1 ребро то програма завершується
            if (result.size() == n - 1) {
                break;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {0, 2, 0, 6, 0},
                {2, 0, 3, 8, 5},
                {0, 3, 0, 0, 7},
                {6, 8, 0, 0, 9},
                {0, 5, 7, 9, 0}
        };

        List<Edge> mst = kruskalMST(matrix);
        System.out.println("Мінімальне покриваюче дерево складається з наступних ребер:");
        for (Edge edge : mst) {
            System.out.println(edge);
        }
    }
}