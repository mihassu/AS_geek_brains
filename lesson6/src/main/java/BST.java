public class BST<T extends Comparable<T>> implements Tree<T>{

    private int size;
    private Node<T> root;

    public BST() {
        size = 0;
        root = null;
    }

    @Override
    public void add(T element) {
        if(size == 0){
            root = new Node<>(element);
        }
        else {
            add(root, element);
        }
        size++;
    }

    private void add(Node<T> node, T element){
        if(element.compareTo(node.value) < 0){
            if(node.left == null){
                node.left  = new Node<>(element);
            }
            else{
                add(node.left, element);
            }
        }
        else if(element.compareTo(node.value) > 0){
            if(node.right == null){
                node.right = new Node<>(element);
            }
            else{
                add(node.right, element);
            }
        }
    }

    @Override
    public void remove(T element) {

    }

    @Override
    public boolean find(T element) {
        return false;
    }

    static StringBuilder str;

    @Override
    public String preOrder() {
        str = new StringBuilder();
        preOrder(root);
        str.insert(0, '[');
        str.delete(str.length()-2, str.length());
        str.append(']');
        return str.toString();
    }

    private void preOrder(Node<T> node) {
        if(node == null) return;
        str.append(node.value).append(',').append(' ');
        preOrder(node.left);
        preOrder(node.right);
    }

    @Override
    public String inOrder() {
        str = new StringBuilder();
        inOrder(root);
        str.insert(0, '[');
        str.delete(str.length()-2, str.length());
        str.append(']');
        return str.toString();
    }

    private void inOrder(Node<T> node) {
        if(node == null) return;
        inOrder(node.left);
        str.append(node.value).append(',').append(' ');
        inOrder(node.right);
    }

    @Override
    public String postOrder() {
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
