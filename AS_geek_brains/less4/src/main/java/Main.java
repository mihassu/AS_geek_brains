import java.util.Comparator;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
//        MyLinkedList<Integer> list = new MyLinkedList<>();
//        for (int i = 0; i < 10; i++) {
//            list.add(i+1);
//        }
//        for(Iterator<Integer> iterator = list.iterator(); iterator.hasNext();){
//            int value = iterator.next();
//            System.out.println(value);
//        }
//
//        for (Integer i : list){
//
//        }

//        MyLinkedList<Integer> myList = new MyLinkedList<>();
//        myList.add(1);
//        myList.add(2);
//        myList.add(3);
//        myList.add(6);
//        myList.add(7);
//        myList.add(20);
//        System.out.println(myList.toString());
//
//        myList.sortedAdd(4);
//        myList.sortedAdd(5);
//
//        System.out.println(myList.toString());
//
//        myList.add(0, 7);
//        System.out.println(myList.toString());
//
//        myList.remove();
//        System.out.println(myList.toString());
//
//        System.out.print("remove(5): ");
//        myList.remove(5);
//        System.out.println(myList.toString());
//
//        System.out.println(myList.get(5));
//
//        myList.set(3, 9);
//        System.out.println(myList.toString());

        MyHeap myHeap = new MyHeap(20);
        myHeap.add(5);
        myHeap.add(7);
        myHeap.add(9);
        myHeap.add(10);
        myHeap.add(4);
        myHeap.add(1);
        myHeap.add(8);
        myHeap.add(3);
        myHeap.add(15);
        myHeap.add(6);
        myHeap.add(18);
        myHeap.printHeap();

        System.out.println(myHeap.remove());
        myHeap.printHeap();

        System.out.println(myHeap.remove());
        myHeap.printHeap();

        System.out.println(myHeap.remove());
        myHeap.printHeap();

        System.out.println(myHeap.remove());
        myHeap.printHeap();

        System.out.println(myHeap.remove());
        myHeap.printHeap();


    }
}
