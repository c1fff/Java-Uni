//Rauan Dauletbek, 12336677
package einfprog;

public class Bsp07 {
    public static void main(String[] args) {
        //i am tired
        int[][] g1 = createGraph(5);
        addEdge(g1, 0, 1);
        addEdge(g1, 0, 4);
        addEdge(g1, 1, 2);
        addEdge(g1, 2, 3);

        System.out.println(isComplete(g1));
        System.out.println(missingEdges(g1));
        System.out.println(maxDegree(g1));
        System.out.println(isPath(g1, new int[]{0, 1, 2, 3}));
        System.out.println(isPath(g1, new int[]{1, 2}));
        System.out.println(isPath(g1, new int[]{0, 3}));

        int[][] g2 = createGraph(4);
        addEdge(g2, 0, 3);
        addEdge(g2, 1, 2);
        addEdge(g2, 2, 1);
        addEdge(g2, 2, 3);
        addEdge(g2, 3, 0);

        System.out.println(isComplete(g2));
        System.out.println(missingEdges(g2));
        System.out.println(maxDegree(g2));
        System.out.println(isPath(g2, new int[]{1, 2, 3, 0}));
        System.out.println(isPath(g2, new int[]{1, 2}));
        System.out.println(isPath(g2, new int[]{1, 3}));

        int[][] g3 = createGraph(2);
        addEdge(g3, 0, 1);
        addEdge(g3, 1, 0);

        System.out.println(isComplete(g3));
        System.out.println(missingEdges(g3));
        System.out.println(maxDegree(g3));
        System.out.println(isPath(g3, new int[]{1, 2, 3, 0}));
        System.out.println(isPath(g3, new int[]{1, 0}));
    }



    ////// PART 1
    /** 
     * Creates an empty graph with the given order.
     * 
     * @param order number of nodes
     * @return adjacency matrix of a graph with order nodes, or null if 
     *  order is > 9 or <= 0.
     */
     public static int[][] createGraph(int order) {
        if (order <= 0 || order > 9) {
            return null;
        }
        return new int[order][order];
    }


    /** 
     * Adds an edge to the graph.
     * 
     * @param graph adjacency matrix of the graph
     * @param src source node
     * @param dst destination node
     * @return true if the edge was added or was already present, false if 
     *  the edge could not be added (e.g., because src or dst are invalid, 
     *  or src is equal to dst, or the graph is null).
     */
    public static boolean addEdge(int[][] graph, int src, int dst) {
        if (graph == null || src == dst || src < 0 || dst < 0 || src >= graph.length || dst >= graph.length) {
            return false;
        }
        graph[src][dst] = 1;
        return true;
    }

    /** 
     * Returns true if, and only if, the graph is complete.
     * 
     * @param graph adjacency matrix of the graph
     * @return true if the graph is complete, false otherwise
     */
    public static boolean isComplete(int[][] graph) {
        if (graph == null) {
            return false;
        }
        int order = graph.length;
        for (int i = 0; i < order; i++) {
            for (int j = 0; j < order; j++) {
                if (i != j && graph[i][j] != 1) {
                    return false;
                }
            }
        }
        return true;
    }

    /** 
     * Returns the number of missing edges in the graph.
     * 
     * @param graph adjacency matrix of the graph
     * @return number of missing edges, or -1 if graph is null
     */
    public static int missingEdges(int[][] graph) {
        if (graph == null) {
            return -1;
        }
        int count = 0;
        int order = graph.length;
        for (int i = 0; i < order; i++) {
            for (int j = 0; j < order; j++) {
                if (i != j && graph[i][j] != 1) {
                    count++;
                }
            }
        }
        return count;
    }
    
    /** 
     * Returns the maximum degree of the graph.
     * 
     * @param graph adjacency matrix of the graph
     * @return maximum degree of the graph, or -1 if graph is null
     */
    public static int maxDegree(int[][] graph) {
        if (graph == null) {
            return -1;
        }
        int maxDegree = 0;
        int order = graph.length;
        for (int i = 0; i < order; i++) {
            int degree = 0;
            for (int j = 0; j < order; j++) {
                if (graph[i][j] == 1) {
                    degree++;
                }
            }
            if (degree > maxDegree) {
                maxDegree = degree;
            }
        }
        return maxDegree;
    }

    /** 
     * Returns true if, and only if, the path is present in the graph.
     * 
     * @param graph adjacency matrix of the graph
     * @param path array of nodes
     * @return true if the path exists, false otherwise
     */
    public static boolean isPath(int[][] graph, int[] path) {
        if (graph == null || path == null || path.length < 2) {
            return false;
        }
        for (int i = 0; i < path.length - 1; i++) {
            if (graph[path[i]][path[i + 1]] != 1) {
                return false;
            }
        }
        return true;
    }
    
    ////// PART 2
    /**
     * Returns the direct neighbors of a node, in ascending order.
     * 
     * The direct neighbors of a node are all nodes that are directly 
     * reachable from that node.
     * 
     * @param graph adjacency matrix of the graph
     * @param node node for which the direct neighbors are to be returned
     * @return array of nodes that are directly reachable from the given node, 
     *  or null if the node is invalid
     */
    public static int[] directNeighbors(int[][] graph, int node) {
        if (graph == null || node < 0 || node >= graph.length) {
            return null;
        }

        int count = 0;
        for (int i = 0; i < graph[node].length; i++) {
            if (graph[node][i] == 1) {
                count++;
            }
        }

        int[] neighbors = new int[count];
        int index = 0;
        for (int i = 0; i < graph[node].length; i++) {
            if (graph[node][i] == 1) {
                neighbors[index++] = i;
            }
        }
        return neighbors;
    }
}