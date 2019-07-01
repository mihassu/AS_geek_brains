import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i+1);
        }
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext())
            System.out.println(iterator.next());
        for(Integer i : list) {
            System.out.println(i);
        }

    }
}
