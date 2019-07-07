public class Queue<T> implements Fifo<T> {

    private OneLinkNode<T> head, last;
    private int size;

    public Queue() {
        this.head = null;
        this.last = null;
        this.size = 0;
    }

    @Override
    public String toString() {
        //TODO
        return "";
    }

    @Override
    public void push(T element) {
        OneLinkNode<T> newLink = new OneLinkNode<>(element);
        if (isEmpty()) {
            head = newLink;
        } else {
            last.setNext(newLink);
        }

        last = newLink;
        size++;
    }

    @Override
    public T pop() {
        OneLinkNode<T> temp = head;

        if (head.getNext() == null) {
            last = null;
        }

        head = head.getNext();

        size--;
        return temp.getValue();
    }

    @Override
    public T peek() {
        return head.getValue();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void order() {
        OneLinkNode<T> current = head;

        while (current != null) {
            System.out.print(current.getValue() + " ");
            current = current.getNext();
        }
    }

    public boolean isEmpty() {
        return (head == null);
    }
}
