public class AdjacencyMatrixTest {
    public static void main(String[] args) {

        Graph graph = new Graph(7);

        graph.addNode(new Node("Ukr"));
        graph.addNode(new Node("Mol"));
        graph.addNode(new Node("Rom"));
        graph.addNode(new Node("Bul"));
        graph.addNode(new Node("Hun"));
        graph.addNode(new Node("Aus"));
        graph.addNode(new Node("Ger"));

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 0);
        graph.addEdge(2, 3);
        graph.addEdge(2, 1);
        graph.addEdge(2, 0);
        graph.addEdge(2, 4);
        graph.addEdge(3, 2);
        graph.addEdge(4, 5);
        graph.addEdge(4, 2);
        graph.addEdge(5, 6);
        graph.addEdge(5, 4);
        graph.addEdge(6, 5);

        graph.print();


    }
}