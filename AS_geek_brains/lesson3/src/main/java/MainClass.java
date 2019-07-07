public class MainClass {

    public static void main(String[] args) {

//        Queue<Integer> queue = new Queue<>();
//
//        for (int i = 0; i < 10; i++) {
//            queue.push(i);
//        }
//        queue.order();
//        System.out.println();
//
//        while (!queue.isEmpty()) {
//            System.out.print(queue.pop() + " ");
//        }

        Deque<Integer> deque = new Deque<>();

        deque.addBack(7);
        deque.addBack(2);
        deque.addBack(4);
        deque.addBack(6);
        deque.addBack(1);
        deque.addBack(8);
        deque.order();

        System.out.println("popBack():");
        deque.popBack();
        deque.order();

        System.out.println("addFront(9):");
        deque.addFront(9);
        deque.order();

        System.out.println("popFront():");
        deque.popFront();
        deque.order();
        deque.reverseOrder();

    }
}
