import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

public class MyLinkedList<T extends Comparable<? super T>> implements Iterable<T> {

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
                //удаляем текущий,
                //следующий становится текущим

                if (iteratorNode == head) {
                    iteratorNode.next.prev = null;
                    iteratorNode = iteratorNode.next;

                } else if (iteratorNode == tail) {
                    iteratorNode.prev.next = null;
                    iteratorNode = null;

                } else {

                    iteratorNode.prev.next = iteratorNode.next;
                    iteratorNode.next.prev = iteratorNode.prev;
                    iteratorNode = iteratorNode.next;
                }
            }

            @Override
            public boolean hasNext() {
                //проверка не ссылаемся ли мы на null

                return iteratorNode != null;
            }

            @Override
            public T next() {
                //возвращаем текущий
                // и переходим к следющему
                Node<T> temp = iteratorNode;
                iteratorNode = iteratorNode.next;
                return temp.value;
            }
        };
    }

    <T extends Comparable<? super T>> void sortedAdd(T element){
        //вставляем с головы в ближайшее место,
        //для которого выполняется:
        //node.prev <= tmp <= node.next
        Node<T> current = (Node<T>) head;
        Node<T> previous = null;
        Node<T> newNode = new Node<>(element);

        //условие пустого списка
//        if(size == 0){
//            head = tail = newNode; //не понимаю почему(((((
//            size++;
//            return;
//        }

        //остановка когда: current.value > element, поэтому добавлять надо перед current
        while (current != null && element.compareTo(current.value) > 0) {
            previous = current;
            current = current.next;
        }

        //при этом условии не найдено значение больше element
        // и в previous лежит последний элемент, поэтому добавляем newNode в конец
        if (current == null) {
            previous.next = newNode;
            newNode.prev = previous;

        } else {
            newNode.prev = previous;
            newNode.next = current;
            previous.next = newNode;
            current.prev = newNode;
        }
        size++;
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

        Node<T> newNode = new Node<>(element);
        Node<T> current;
        int i = 0;

        if(size == 0) {
            head = tail = newNode;
            size ++;
            return;
        }

        //если элементов мало - добавляем в конец
        if (index >= size) {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;

        } else if (index <= 0) { //при таком условии - добавляем в начало
            newNode.next = head;
            head.prev = newNode;
            head = newNode;

        } else {
            current = head;
            while (i < index) {
                current = current.next;
                i++;
            }
            newNode.next = current;
            newNode.prev = current.prev;
            current.prev.next = newNode;
            current.prev = newNode;
        }
        size++;
    }

    void remove(){ //удалить последний
        Node<T> temp = tail;
        tail.prev.next = null;
        tail = tail.prev;
        size--;
    }

    int size(){
        return size;
    }

    void remove(int index){

        Node<T> current;
        int i = 0;

        //если элементов мало - удаляем последний
        if (index >= size) {
            tail = tail.prev;
            tail.next = null;

        } else if (index <= 0) { //при таком условии - удаляем первый
            head = head.next;
            head.prev = null;

        } else {
            current = head;
            while (i < index) {
                current = current.next;
                i++;
            }
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }
        size--;

    }

    T get(int index){
        Node<T> current;
        int i = 0;

        //возвращаем последний
        if (index >= size) {
            return tail.value;

        } else if (index <= 0) { //при таком условии - возвращаем первый
            return head.value;

        } else {
            current = head;
            while (i < index) {
                current = current.next;
                i++;
            }
            return current.value;
        }

    }

    void set(int index, T value){
        Node<T> current;
        int i = 0;

        //заменяем последний
        if (index >= size) {
            tail.value = value;

        } else if (index <= 0) { //при таком условии - заменяем первый
            head.value = value;

        } else {
            current = head;
            while (i < index) {
                current = current.next;
                i++;
            }
            current.value = value;
        }
    }

    @Override
    public String toString() {
        //format: [1, 2, 3, 4, 5]

        String str;
        Node<T> current = head;
        List<T> tempList = new ArrayList<>();

        while (current != null) {
            tempList.add(current.value);
            current = current.next;
        }

        str = tempList.toString();
        return str;
    }

}
