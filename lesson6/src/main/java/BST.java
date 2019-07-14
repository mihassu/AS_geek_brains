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
        if(element.compareTo(node.value) < 0){ //если поставить >= то будут добавляться одинаковые элементы
            if(node.left == null){
                node.left = new Node<>(element);
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

        if (root.value == element) {
            return true;
        } else if (element.compareTo(root.value) < 0){
            return find(root.left, element);
        } else {
            return find(root.right, element);
        }
    }

    private boolean find(Node<T> node, T element) {
        if (node == null){return false;}
        if (node.value == element) {return true;}

        if (find(node.left, element)) {
            return true;
        } else {
            return find(node.right, element);
        }
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
        str = new StringBuilder();
        str.append('[');
        postOrder(root);
        str.delete(str.length()-2, str.length());
        str.append(']');
        return str.toString();
    }

    private void postOrder(Node<T> node) {
        if (node == null){return;}

        postOrder(node.left);
        postOrder(node.right);
        str.append(node.value).append(',').append(' ');
    }


    @Override
    public int size() {
        return size;
    }
}
