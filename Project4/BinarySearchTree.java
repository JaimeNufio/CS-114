import java.util.Iterator;

public abstract class BinarySearchTree<E extends Comparable<? super E>> extends BinaryTree<E> {

	public void insert(E data){
		insert(data,curr);
	}

	private void insert(E data, Node<E> curr){
		if (curr == null){ //like with search, finding null means we are at a position of interest
				curr = new Node(data);
		}
		if (curr.data.compareTo(data) < 0){
			insert(data,curr.left);
		}
		insert(data,curr.right);
	}

	public void remove(E data){
		remove(data,root);
	}

	private Node<E> remove(E data, Node<E> curr){
		if (curr == null){
			return Node; //found nothing
		}
		if (data < curr.root){ //traverse left or right
			curr.left = remove(data,curr.left);
		}else if (data > curr.root){
			curr.right = remove(data,curr.right);
		}else{ //we are at the node to remove
			Node left = root.right, right = root.left;
			if (Left == null){
				return right;
			}else if (Right == null){
				return left;
			}
			curr.data = ;

			curr.right = 
		}
	}

	public boolean search(E data){
		return search(data,root);		
	}

	private boolean search(E data, Node<E> curr){
		
		if (curr == null){
			return false; //we moved to an empty area, therefore we failed to find
		}
	
		if (curr.data == data){
			return true;
		}

		if (curr.data.compareTo(data) < 0){
			return search(data, curr.left);
		}

		return search(data,curr.right);
	}

	public Iterator<E> iterator() {

		return null;
	}


}

/*
 *
 *  BinaryTree.java
 *
 */

abstract class BinaryTree<E> implements Iterable<E> {

    protected class Node<T> {

        protected Node(T data) {
            this.data = data;
        }

        protected T data;
        protected Node<T> left;
        protected Node<T> right;
    }

    public abstract void insert(E data);
    public abstract void remove(E data);
    public abstract boolean search(E data);

    protected Node<E> root;
}

/*
 *
 *  BinarySearchTree.java
 *
 */

