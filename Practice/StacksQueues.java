import java.util.Iterator;

public class Main {

    public static void main(String[] args) {

        Stack<Integer> stack = Math.random() < 0.5 ? new AStack<Integer>() :
                                                     new RStack<Integer>();

        int num = args.length == 1 ? Integer.parseInt(args[0]) : 10;

        System.out.println(stack);
        System.out.println("push");

        for (int i = 0; i < num; ++i) {
            stack.push(i);
            System.out.print(i + ": ");
            for (int j : stack) {
                System.out.print(j + " ");
            }
            System.out.println();
        }

        Integer i;

        System.out.println("pop");

        while ((i = stack.pop()) != null) {
            System.out.print(i + ": ");
            for (int j : stack) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}

interface Stack<E> extends Iterable<E> {
    boolean empty();
    E peek();
    E pop();
    void push(E data);
}

class AStack<E> implements Stack<E> {
    
    private Object[] stack = new Object[10];
    private int top;

    private class StackIterator<E> implements Iterator<E> { //Interator abstract class has 3 functions
        public boolean hasNext() {
            return curr > 0;
        }
        public E next() {
            return (E)stack[--curr];
        }
        public void remove() {
            throw new UnsupportedOperationException();
        }
        private int curr = top;
    }

    public boolean empty() {

        return top == 0;
    }

    private void grow() {

        Object[] temp = new Object[stack.length * 2];

        for (int i = 0; i < stack.length; ++i) {
            temp[i] = stack[i];
        }

        stack = temp;
    }

    public Iterator<E> iterator() {

        return new StackIterator<E>();
    }

    public E peek() { //

        E temp = pop();
        push(temp);
        return temp;
    }

    public E pop() {

        E temp = null;

        if (top <= stack.length / 3 && stack.length > 10) { //if the top (current) value is less than a third of the stack, shrink, and stack is greater than 10
            shrink();
        }

        if (top > 0) {
            temp = (E)stack[--top]; //return the one before the top, and assign top to that number
        }

        return temp;
    }

    public void push(E data) {

        if (top >= stack.length) { //check if we'd over flow
            grow();
        }

        stack[top++] = data;//set top to a number 1 more, and put data there in the array
    }

    private void shrink() {

        Object[] temp = new Object[stack.length / 2];

        for (int i = 0; i < temp.length; ++i) {
            temp[i] = stack[i];
        }

        stack = temp;
    }

}

class RStack<E> implements Stack<E> {

    private class Node<T> {
        private Node(T data) {
            this.data = data;
        }
        private T data;
        private Node<T> next;
    }

    public boolean empty() {

        return head == null; //just make the head reffrence empty
    }

    public Iterator<E> iterator() {

        return new Iterator<E>() { //what an itterator wants
            public boolean hasNext() {
                return curr != null;
            }
            public E next() {
                E temp = curr.data; //next reffrence's data
                curr = curr.next; //make current, the next reffrence
                return temp;
            }
            public void remove() {
                throw new UnsupportedOperationException(); 
            }
            private Node<E> curr = head; //reffrence pointer
        };
    }

    public E peek() {

        E temp = pop();
        push(temp);
        return temp;
    }

    public E pop() {

        E temp = null;
        
        if (head != null) {
            temp = head.data; //temp is the head's data
            head = head.next; //head is the next node
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
