public class Deque<T> implements TwoSizeQueue<T> {

    private TwoLinkNode<T> front, back;
    private int size;

    @Override
    public String toString() {
        //TODO
        return "";
    }

    @Override
    public void addBack(T element) {
        TwoLinkNode<T> newNode = new TwoLinkNode<>(element);
        if (isEmpty()) {
            front = newNode;

        } else {
            back.setNext(newNode);
            newNode.setPrev(back);
        }

        back = newNode;
        size++;
    }

    @Override
    public void addFront(T element) {
        TwoLinkNode<T> newNode = new TwoLinkNode<>(element);

        if (isEmpty()) {
            back = newNode;

        } else {
            front.setPrev(newNode);
            newNode.setNext(front);
        }

        front = newNode;
        size++;
    }

    @Override
    public T popBack() {
        TwoLinkNode<T> temp = back;
        back = back.getPrev();
        back.setNext(null);

        return temp.getValue();
    }

    @Override
    public T popFront() {
        TwoLinkNode<T> temp = front;
        front = front.getNext();
        front.setPrev(null);

        return temp.getValue();
    }

    @Override
    public T back() {
        return back.getValue();
    }

    @Override
    public T front() {
        return front.getValue();
    }

    @Override
    public void order() {
        TwoLinkNode<T> temp = front;
        System.out.print("---> : ");
        while (temp != null) {
            System.out.print(temp.getValue() + " ");
            temp = temp.getNext();
        }
        System.out.println();
    }

    @Override
    public void reverseOrder() {
        TwoLinkNode<T> temp = back;
        System.out.print("<--- : ");
        while (temp != null) {
            System.out.print(temp.getValue() + " ");
            temp = temp.getPrev();
        }
        System.out.println();
    }

    @Override
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
