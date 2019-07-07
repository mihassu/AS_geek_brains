public class MyHeap {

    private float[] heapArr;
    private int size;

    public MyHeap(int max) {
        this.size = 0;
        this.heapArr = new float[max];
    }

    public void add(float element) {

        heapArr[size] = element;
        int index = size;
        int parent = (index - 1) / 2;
        float temp = element;

        while (index > 0 && heapArr[parent] > element) {
            heapArr[index] = heapArr[parent];
            index = parent;
            parent = (parent - 1) / 2;
        }

        heapArr[index] = temp;

        size++;
    }

    public float remove() {

        float first = heapArr[0];
        heapArr[0] = heapArr[size - 1];
        float temp = heapArr[0];
        int index = 0;
        int child1 = 2 * index + 1;
        int child2 = 2 * index + 2;
        int child = getMinChild(child1, child2);

        while (index < size / 2 && heapArr[index] > heapArr[child]) {

            heapArr[index] = heapArr[child];
            heapArr[child] = temp;
            index = child;
            child1 = 2 * index + 1;
            child2 = 2 * index + 2;
            child = getMinChild(child1, child2);
        }
        heapArr[index] = temp;
        size--;
        return first;
    }

    public int getMinChild(int c1, int c2) {

        int minChild = c1;
        if (heapArr[minChild] > heapArr[c2]) {
            minChild = c2;
        }

        return minChild;
    }


    public void printHeap(){

        for (int i = 0; i < size; i++) {
            System.out.print((int) heapArr[i] + " ");
        }
        System.out.println();
    }
}
