/*	Sorted List
 *		-Differ from not having to move data	
 *
 *
*/
import java.util.Random;
public class listImplement{

	public static void main(string[] args){
		
		List<Integer> list = new SortedList<Integer>();
		Random rand = new Random();
		
		for (int i = 0; i<10;i++){
			list.insert(rand.nextInt());
		}
		
		

	}

}

interface List<E>{
	void insert(E data);
	E remove(E data);
}

class SortedList<E extends comparabe<? super>>> implements List<E> { //E is a data that extends some comparable for some super class of E

	//This example is going to be iterable, assignment will be recursive

	private class Node<T>{
		private Node(T data){
			this.data = data;
		}
		private T data;
		private Node<T> next;
	}

	public void insert(E data){

		Node<E> temp = new Node<E>(data);
		
		//short circuit eval
		//when head empty, list empty
		//if second part is false, we know there is a head and can compare
		if(head == null || (temp.data.comparTo(head.data)<0){
			temp.next = head;
			head = null;
		}else{ //at this point we know: list is not empty, and we are not inserting prior to first node
			Node<E>curr = head;
			while ( curr.next != null ){
				if (temp.data.compareTo(curr.next.data) < 0){
					break;
				}
				curr = curr.next
			}
			temp.next = curr.next;
			curr.next = temp;
		}

		//inserting prior to first node

	}

	public E remove(E data){
		E temp = null;
		if (head != null){//if list not empty
			if (data.compareTo(head.data) == 0){ //pop
				temp = head.data;
				head = head.next;
			}
		}else{
			//pointer needs to be one behind, just like in insert
			for (Node<E> curr = head; curr.next !=null; curr = curr.next){
				if (data.compareTo(curr.next.data) == 0){
					temp = curr.next.data;
					curr.next = curr.next.next;
					break;
				}
			}
		}
	}
}
