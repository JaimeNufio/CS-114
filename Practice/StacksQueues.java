public class StacksandQueues{
	
	public static void (String[] a){

	}
	
}

Interface Stack<E> extends Iterable<E>{ //Why are we extending iterable? is it used?
	pop();
	push();
	peek();
	grow();
	shrink();
}

class RStack<E> implements Stack<E>{

	private class Node<T>{
	private  Node(data E){
		this.data = E;
	}
		private Node<T> next;
		private T data;		
	}

	public boolean empty(){
		head = null;
	}


	public E peek() {

        	E temp = pop();
     		push(temp);
        	return temp;
    	}

    	public E pop() {

        	E temp = null;
        
        	if (head != null) {
        		temp = head.data;
            		head = head.next;
        	}

        	return temp;
    	}

    	public void push(E data) {

        	Node<E> temp = new Node<E>(data);
        	temp.next = head;
        	head = temp;
    	}

    	private Node<E> head;

}


