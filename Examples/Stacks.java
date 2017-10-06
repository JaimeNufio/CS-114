public class Main{
	public static void main(String[] args){

		Stack<Integer> stack = Math.random() < 0.5 ? newAStack<Integer>()
							: newRStack<Integer>()
	}
}

interface Stack<E>{
	pop();
	void push(E data);
}

class AStack<E> implements Stack<E>{
	public E pop(){
		E temp = null;
		if (top > 0){
			temp = (E) stack[top];
		}
		return temp;
	}

	public void push(E data){
		if (top < stack.length){
			stack[top++] = data;
		}
	}

	private void grow(){
		Object[] temp = new Object[stack.length*2];
		for (int i =0; i< stack.length;i++){
			temp[i] = stack[i];
		}
		stack = temp;
	}

	private void shrink(){
		Object[] temp = new Object[stack.length/2];
		for (int i = 0; i<temp;i++){
			temp[i]=stack[i];
		}
	}

	privat Object[] stack = new Object[10]
	private int top;
}

class RStack<E> implents Stack<E>{ //Linked List?
	//LIFO 
	private class Node<T>{
		private Node(T data){
			this.data = data;
		
		private T data;
		private Node<T> next; 
	}


	public E pop(){
		E temp = null;
		if (head != null){ //if stack not empty
			temp = head.data;
			head = head.next;
		}
		return temp;
	}
	public void push(E data){
		Node<E> temp  = new Node<E>(data);
		temp.next = head;
		head = temp;
	}
}
