public class NodeTree{

    public static void main(String[] args) {

        BinaryTree<Integer> tree = new BinaryTree<Integer>();

        tree.root = tree.new Node<Integer>(60);
        tree.root.left = tree.new Node<Integer>(20);
        tree.root.right = tree.new Node<Integer>(70);
        tree.root.left.left = tree.new Node<Integer>(10);
        tree.root.left.right = tree.new Node<Integer>(40);
        tree.root.left.right.left = tree.new Node<Integer>(30);
        tree.root.left.right.right = tree.new Node<Integer>(50);

        System.out.println("pre order");
        tree.preOrder(tree.root);
        System.out.println("\nin order");
        tree.inOrder(tree.root);
        System.out.println("\npost order");
        tree.postOrder(tree.root);
        System.out.println();
    }
}

class BinaryTree<E> {

    class Node<T> {
        Node(T data) {
            this.data = data;
        }
        T data;
        Node<T> left;
        Node<T> right;
    }

    public void inOrder(Node<E> curr) {

        if (curr != null) {
            inOrder(curr.left);
            System.out.print(curr.data + " ");
            inOrder(curr.right);
        }
    }

    public void preOrder(Node<E> curr) {

        if (curr != null) {
            System.out.print(curr.data + " ");
            preOrder(curr.left);
            preOrder(curr.right);
        }
    }

    public void postOrder(Node<E> curr) {

        if (curr != null) {
            postOrder(curr.left);
            postOrder(curr.right);
            System.out.print(curr.data + " ");
        }
    }

    Node<E> root;
}
