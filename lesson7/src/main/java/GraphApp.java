public class GraphApp {

    public static void main(String[] args) {

        MyGraph myGraph = new MyGraph();
        myGraph.addVertex('A');
        myGraph.addVertex('B');
        myGraph.addVertex('C');
        myGraph.addVertex('D');
        myGraph.addVertex('E');
        myGraph.addVertex('F');
        myGraph.addVertex('G');
        myGraph.addVertex('H');


        myGraph.addEdge(0, 1);
        myGraph.addEdge(1, 2);
        myGraph.addEdge(2, 3);
        myGraph.addEdge(3, 4);
        myGraph.addEdge(0, 5);
        myGraph.addEdge(5, 4);
        myGraph.addEdge(0, 6);
        myGraph.addEdge(6, 7);
        myGraph.addEdge(7, 4);

//        myGraph.dfs(0);
//        System.out.println();
//        myGraph.dfsRec(0);
//        myGraph.bfs(0);
        myGraph.findMinBfs(4);

    }
}
