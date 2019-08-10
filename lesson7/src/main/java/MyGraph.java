public class MyGraph {

    private final int MAX_VERTEX = 20;
    private Vertex[] vertexList;
    private int[][] adjMat; //adjacent - смежный
    private int size;
    private MyStack stack;
    private MyQueue queue;

    public MyGraph() {
        this.vertexList = new Vertex[MAX_VERTEX];
        this.adjMat = new int[MAX_VERTEX][MAX_VERTEX];
        this.size = 0;
        stack = new MyStack(MAX_VERTEX);
        queue = new MyQueue(MAX_VERTEX);

        //заполняем матрицу смежности нулями
        for (int i = 0; i < MAX_VERTEX; i++) {
            for (int j = 0; j < MAX_VERTEX; j++) {
                adjMat[i][j] = 0;
            }
        }
    }

    public void addVertex(char label) {
        vertexList[size++] = new Vertex(label);
    }

    public void addEdge(int firstVertex, int seconVertex) {
        adjMat[firstVertex][seconVertex] = 1;
        adjMat[seconVertex][firstVertex] = 1;
    }

    public void displayVertex(int v) {
        System.out.println(vertexList[v].getLabel());
    }

    //вернуть непосещенную смежную верштну. Если их нет вернуть -1
    public int getAdjNoVisitedVertex(int v) {
        for (int i = 0; i < MAX_VERTEX; i++) {
            if (adjMat[v][i] == 1 && !vertexList[i].isVisited()) {
                return i;
            }
        }

        return -1;
    }

    //обход в глубину
    public void dfs(int vertex) {
        stack.push(vertex);
        vertexList[vertex].setVisited(true);
        displayVertex(vertex);

        while (!stack.isEmpty()) {
            int v = getAdjNoVisitedVertex(stack.peek());
            if (v == -1) { //если у вершине нет смежных вершин
                stack.pop(); //извлекаем ее из стека

            } else {
                stack.push(v);
                vertexList[v].setVisited(true);
                displayVertex(v);
            }
        }

        for (int i = 0; i < size; i++) {
            vertexList[i].setVisited(false); //помечаем все вершины непосещенными (сбрасываем состояние)
        }
    }

    //обход в глубину рекурсия (неправильно, не знаю((( )
    public void dfsRec(int vertex) {
        displayVertex(vertex);
        vertexList[vertex].setVisited(true);
        int v;
        if ((v = getAdjNoVisitedVertex(vertex)) != -1) {
            dfsRec(v);
        }
    }

    //обход в ширину
    public void bfs(int vertex) {
        int v2;
        queue.push(vertex);
        vertexList[vertex].setVisited(true);
        displayVertex(vertex);

        while (!queue.isEmpty()) {
            int v = queue.pop();
            while ((v2 = getAdjNoVisitedVertex(v)) != -1) {
                queue.push(v2);
                vertexList[v2].setVisited(true);
                displayVertex(v2);

            }
        }
        for (int i = 0; i < size; i++) {
            vertexList[i].setVisited(false); //помечаем все вершины непосещенными (сбрасываем состояние)
        }
    }

    public void findMinBfs(int fin) {
        int v2;
        queue.push(0);
        vertexList[0].setVisited(true);
        displayVertex(0);
        int flag = 0;

        while (!queue.isEmpty()) {
            if (flag == 1) {
                System.out.println("break out");
                break;
            }
            int v = queue.pop();
            while ((v2 = getAdjNoVisitedVertex(v)) != -1) {
                queue.push(v2);
                vertexList[v2].setVisited(true);
                displayVertex(v2);

                if (vertexList[v2].getLabel() == vertexList[fin].getLabel()) {
                    System.out.println(vertexList[v2].getLabel() + " = " + vertexList[fin].getLabel());
                    queue.print();
                    System.out.println("break in");
                    flag = 1;
                    break;
                }
            }
        }
        for (int i = 0; i < size; i++) {
            vertexList[i].setVisited(false); //помечаем все вершины непосещенными (сбрасываем состояние)
        }


    }
}
