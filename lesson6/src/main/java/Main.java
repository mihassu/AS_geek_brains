import java.util.Random;

public class Main {

    public static void main(String[] args) {
        BST<Integer> tree = new BST<>();
        tree.add(5);
        for (int i = 0; i < 5; i++) {
            tree.add(new Random().nextInt(50));
        }
        tree.add(5);
        for (int i = 0; i < 5; i++) {
            tree.add(new Random().nextInt(50));
        }

        System.out.println("inOrder: " + tree.inOrder());
        System.out.println("preOrder: " + tree.preOrder());
        System.out.println("postOrder: " + tree.postOrder());

        System.out.println("find(): " + tree.find(22));
        System.out.println("fingElemrnt(): " + tree.findElement(22));

        tree.remove(5);
        System.out.println("remove(5): " + tree.inOrder());
    }
}
