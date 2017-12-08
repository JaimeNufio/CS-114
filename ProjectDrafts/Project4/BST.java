import java.util.Iterator;
import java.util.Stack;

public class BST<E extends Comparable<? super E>> extends BinaryTree<E> {

	public void insert(E data){
		root = insert(data,root); //our recursive method returns a new bst, at the root
	}

	private Node<E> insert(E data, Node<E> curr){ //this method recursively parses the BST adds the node, and returns a new BST

		if (curr == null){ //null means we add a new node
			return new Node<E>(data);
		}else if (curr.data.compareTo(data) <= 0){ //less than equal b/c of duplicates
			curr.left = insert(data,curr.left); 
		}else if (curr.data.compareTo(data) > 0){
			curr.right = insert(data,curr.right);
		}
		return curr;
	}

	public void remove(E data){
		root = remove(data,root); //like with insert, we are returing a new bst and it requires we change the root reffrence
	}

	private Node<E> remove(E data, Node<E> curr){

		Node<E> left = curr.left, right = curr.right; //save on some typing
		if (curr == null){ //go back up a layer
			   	return null;
		}
		if (curr.data.compareTo(data) < 0){ //traverse left or right
			left = remove(data,left);
		}else if (curr.data.compareTo(data) > 0){
			right = remove(data,right);
		}else{ //  we found the node of interest 
		
			if (left == null && right == null){
				return node = null; // we can cleanly erase
			}	

			if (right == null){ //if no right node, but have a left, it becomes parent
				curr = left; //NOTE: if the left node is also null, we'll return null so its ok
			}else if (left == null){
				curr = right;
			}else{
				//we are in a position where we now have both a left and right subtree
				curr.data = min(right); //right will be larger than left, so lets begin here
				right = remove(data,right);
			}
		}

		return curr;
	}

	private <E extends Comparable<? super E>> E min(Node<E> curr){
		//traverse recursively left to locate the smallest value from the root of subtree
		//This could be done itteratively something like while(curr.left!=null)
		//but lets try recursion
		
		if (curr.left != null){ 	
			return min (curr.left);
		}
		
		return curr.data;
	}

	public boolean search(E data){
		return search(data,root);		
	}

	private boolean search(E data, Node<E> curr){
		
		if (curr == null){
			return false; //we moved to an empty area, therefore we failed to find
		}
	
		if (curr.data.compareTo(data) == 0){
			return true;
		}

		if (curr.data.compareTo(data) < 0){
			return search(data, curr.left);
		}

		//unless....
		//
		//unless.. unless...
	

		return search(data,curr.right);
	}
 	
	public Iterator<E> iterator() {

		
		return new Iterator<E>(){	
			
			private Stack<Node<E>> subTrees = new Stack<Node<E>>();

			public boolean hasNext(){
				return !subTrees.empty();
			}

			public E next(){
				Node<E> curr = subTrees.pop();
				nextTree(curr.right); 
				return curr.data;
			}

            public void remove() {
            	throw new UnsupportedOperationException();
            }

			public void nextTree(Node<E> curr){
				while (curr != null){
					subTrees.push(curr);
					curr = curr.left;
				}
			}
        };
    }

}
