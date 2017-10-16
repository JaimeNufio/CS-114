import java.util.Iterator;
import java.util.Random;

/*
	Jaime Nufio, Jen25
	CS114-005, Prof Kapleau

	Vim w/ Tabstop=4.

*/
public class Project1{

    public static void main(String[] args) {

        Random rand = new Random(1);
        SortedList<Integer> list = new SortedList<Integer>();
        int m = args.length == 1 ? Integer.parseInt(args[0]) : 10;

        System.out.println("insert");
        for (int i = 0; i < m; ++i) {
            int n = 10-i;//rand.nextInt(m);
            list.insert(n);
            System.out.print(n + ": ");
            for (Integer j : list) {
                System.out.print(j + " ");
            }
            System.out.println();
        }

        // 	rand = new Random(1);

        System.out.println("remove");
        for (int i = 0; i < m; ++i) {
            int n = i;//rand.nextInt(m);
            list.remove(n);
            System.out.print(n + ": ");
            for (Integer j : list) {
                System.out.print(j + " ");
            }
            System.out.println();
        }

		//	System.out.println(list.hasNext());
    }
}

abstract class List<E> implements Iterable<E> {

    protected class Node<T> {

        protected Node(T data) {
            this.data = data;
        }

        protected T data;
        protected Node<T> next;
    }

    public abstract void insert(E data);
    public abstract void remove(E data);
    public abstract E retrieve(int index);
    public abstract boolean search(E data);

    protected Node<E> head;
}


class SortedList<E extends Comparable<? super E>> extends List<E> {

    public void insert(E data){
	    
		//I decided to settle the special case outside of the recursion. 
		//This way we can avoid checking that one-tme condition over again.

		Node<E>temp = new Node<E>(data);
		
		if (head == null || data.compareTo(head.data)<0){
			temp.next = head;
			head = temp;
		}else{	
			insert(temp, head);
		}

	}

	public void insert(Node<E> temp, Node<E> curr){

		//I feel like I used too many if statements.

		if (curr != null && curr.next != null){
			if (temp.data.compareTo(curr.next.data) < 0){
				temp.next = curr.next;
				curr.next = temp;
			}else{
				insert(temp,curr.next);
			}	
		}else{
			curr.next = temp;
		}
	}

	public void remove(E data){
		
		//handle the special case w/o regression
		
		if (head != null){ 
			if (data.compareTo(head.data) == 0)
				head = head.next; 
		}else
			return; //empty set.
	
		remove(data, head);
	}

	public void remove(E data, Node<E> curr){

		if (curr != null && curr.next != null){
			if(data.compareTo(curr.next.data) == 0){
				curr.next = curr.next.next;
				return;
			}else
				remove(data,curr.next);
		}
	}

	public E retrieve(int index){
		return retrieve(head,index,0);	
	}

	public E retrieve(Node<E> curr, int index, int count){
		
		//No special cases as far as I can tell.
			
		if (count == index){
			return curr.data;
		}
		if (curr.next != null)
			return retrieve(curr.next,index,++count);
		else
			throw new IndexOutOfBoundsException();
	}

	public boolean search(E data){
		return search(data, head);
	}

	public boolean search(E data, Node<E> curr){

		//two cases. Find, or not found.
		//Also, its kinda odd it doesn't 
		//return the value, but hey. 
		//Sometimes you just gotta know
		//what's in a set lol

		if (data.compareTo(curr.data) == 0){
			return true;
		}

		if (curr.next != null){
			return search(data,curr.next);
		}
		
		return false;
	}
			
    public Iterator<E> iterator() {

        return new Iterator<E>() {
            public boolean hasNext() {
                return curr != null;
            }
            public E next() {
                E temp = curr.data;
                curr = curr.next;
                return temp;
            }
            public void remove() {
                throw new UnsupportedOperationException();
            }
            private Node<E> curr = (Node<E>)head;
        };
    }
}

