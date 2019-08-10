public class MyStack {

    private int[] stackArr;
    private int top;
//    private int size;

    public MyStack(int maxSize) {
        this.stackArr = new int[maxSize];
        this.top = -1;

    }

    public void push(int i) {
        stackArr[++top] = i;
    }

    public int pop() {
        if (!isEmpty()) {
            return stackArr[top--];
        } else {
            return -1;
        }
    }

    public int peek() {
        return stackArr[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }
}
