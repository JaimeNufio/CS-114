
public class Project4<E extends Comparable<? super E>> extends BinaryTree<E>{
	
	public Iterator<E> iterator(){

                return null;
        }

        public void insert(E data){
                //no special cases

        }

        private void insert(E data, Node<E> Curr){
        }

        public void remove(E data){

        }

        public boolean search(E data){

                if (root != null){
                        search(data,root);
                }
                return false;
        }

        private boolean search(E data,Node<E> curr){
                if (curr == null){
                        return false;
                }
                if (curr.data == data){
                        return true;
                }
                if (data < curr.data){
                        return search(data,curr.left);
                }
                return search(data,curr.right);
        }
	
}


class BinarySearchTree<E extends Comparable<? super E>> extends BinaryTree<E>{

	protected class Node<T>{
		
		protected Node(E data){
			this.data = data;
		}

		protected T data;
		protected Node<T> left, right;
	}

	public abstract void insert(E data);
	public abstract void remove(E data);
	public abstract boolean search(E data);

	protected Node<E> root;
}
