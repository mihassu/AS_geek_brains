public class Node<T extends Comparable<? super T>> {

    T value;
    Node<T> prev, next;

    public Node(T value) {
        this.value = value;
        prev = next = null;
    }

}
