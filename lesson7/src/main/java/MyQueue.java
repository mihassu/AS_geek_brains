public class MyQueue {

    private int[] queueArr;
    private int maxSize;
    private int size;
    private int first;
    private int last;

    public MyQueue(int max) {
        this.maxSize = max;
        this.queueArr = new int[maxSize];
        this.size = 0;
        this.first = 0;
        this.last = -1;
    }

    public void push(int i) {

        //циклический перенос
        if (last == size - 1) {
            last = -1;
        }

        queueArr[++last] = i;
        size++;
    }

    public int pop() {
        int temp = queueArr[first++];

        //циклический перенос
        if (first == maxSize) {
            first = 0;
        }
        size--;
        return temp;
    }

    public int peek() {
        return queueArr[first];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void print() {
        System.out.print("queue: ");
        for (int i = first; i < maxSize; i++) {
            System.out.print(queueArr[i]);
        }
        System.out.println();
    }
}

