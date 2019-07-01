import java.util.Iterator;
import java.util.LinkedList;
import java.util.function.Consumer;

public class MyLinkedList<T> implements Iterable<T>{

    private Node<T> head, tail, iteratorNode;
    private Iterator<T> iterator;
    private int size;

    public MyLinkedList() {
        head = tail = null;
        size = 0;
    }

    public Iterator<T> iterator(){

        iteratorNode = head;

        return new Iterator<T>() {

            public void remove(){
                //TODO
                //удаляем текущий,
                //следующий становится текущим
            }

            @Override
            public boolean hasNext() {
                //TODO
                //проверка не ссылаемся ли мы на null
                return false;
            }

            @Override
            public T next() {
                //TODO
                //возвращаем текущий
                // и переходим к следющему
                return null;
            }
        };
    }

    void sortedAdd(T element){
        //TODO
        //вставляем с головы в ближайшее место,
        //для которого выполняется:
        //node.prev <= tmp <= node.next
    }

    void add(T element){
        if(size == 0){
            head = tail = new Node<>(element);
            size++;
            return;
        }
        Node<T> node = new Node<>(element);
        node.prev = tail;
        tail.next = node;
        tail = node;
        size++;
    }

    void add(int index, T element){
        //TODO
    }

    void remove(){
        //TODO
    }

    int size(){
        //TODO
        return size;
    }

    void remove(int index){
        //TODO
    }

    T get(int index){
        //TODO
        return null;
    }

    void set(int index, T value){
        //TODO
    }

    @Override
    public String toString() {
        //TODO
        //format: [1, 2, 3, 4, 5]
        return "";
    }
}
