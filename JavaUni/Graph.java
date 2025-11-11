package einfprog;

public class Graph {
    private String title;
    private int[][] adjacencyMatrix;

    public Graph(String title, int[][] adjacencyMatrix) {
        this.title = title;
        this.adjacencyMatrix = adjacencyMatrix;
    }

    public boolean isSymmetric() {
        int size = adjacencyMatrix.length;
        if (size != adjacencyMatrix[0].length) {
            return false;
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (adjacencyMatrix[i][j] != adjacencyMatrix[j][i]) {
                    return false;
                }
            }
        }
        return true;
    }

    public void turnEdges() {
        int size = adjacencyMatrix.length;
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                int temp = adjacencyMatrix[i][j];
                adjacencyMatrix[i][j] = adjacencyMatrix[j][i];
                adjacencyMatrix[j][i] = temp;
            }
        }
    }
}

