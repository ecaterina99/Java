import java.util.ArrayList;

public class Graph {

    ArrayList<Node> nodesList;
    int[][] matrix;

    public Graph(int size) {
        nodesList = new ArrayList<>();
        matrix = new int[size][size];
    }

    public void addNode(Node node) {
        nodesList.add(node);
    }

    public void addEdge(int src, int dest) {
        matrix[src][dest] = 1;
    }

    public boolean checkEdge(int src, int dest) {
        if (matrix[src][dest] == 1) {
            return true;
        }
        return false;
    }

    public void print() {
        System.out.print("   ");

        for (Node node : nodesList) {
            System.out.print(node.data+ " ");
        }
        System.out.println();

        for (int i = 0; i < matrix.length; i++) {
            System.out.print(nodesList.get(i).data + " ");
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "   ");
            }
            System.out.println();
        }
    }

}
