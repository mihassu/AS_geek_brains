import java.util.Random;

public class Main {

    public static void main(String[] args) {
        BST<Integer> tree = new BST<>();
        for (int i = 0; i < 10; i++) {
            tree.add(new Random().nextInt(50));
            tree.add(5);
        }
        System.out.println("inOrder: " + tree.inOrder());
        System.out.println("preOrder: " + tree.preOrder());
        System.out.println("postOrder: " + tree.postOrder());

        System.out.println("find(): " + tree.find(22));
    }
}
