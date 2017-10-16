import java.util.Iterator;
import java.util.Random;

public class example{

    public static void main(String[] args) {

        Random rand = new Random(1);
        SortedList<Integer> list = new SortedList<Integer>();
        int m = args.length == 1 ? Integer.parseInt(args[0]) : 10;

        System.out.println("insert");
        for (int i = 0; i < m; ++i) {
            int n = rand.nextInt(m);
            list.insert(n);
            System.out.print(n + ": ");
            for (Integer j : list) {
                System.out.print(j + " ");
            }
            System.out.println();
        }

        // rand = new Random(1);

        System.out.println("remove");
        for (int i = 0; i < m; ++i) {
            int n = rand.nextInt(m);
            list.remove(n);
            System.out.print(n + ": ");
            for (Integer j : list) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
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

    public void insert(E data) {

        Node<E> temp = new Node<E>(data);

        if (head == null || data.compareTo(head.data) < 0) {
            temp.next = head;
            head = temp;
        }
        else {
            Node<E> curr;
            for (curr = head; curr.next != null; curr = curr.next) {
                if (data.compareTo(curr.next.data) < 0) {
                    temp.next = curr.next;
                    curr.next = temp;
                    return;
                }
            }
            curr.next = temp;
        }
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

    public void remove(E data) {

        if (head != null) {
            if (data.compareTo(head.data) == 0) {
                head = head.next;
            }
            else {
                for (Node<E> curr = head; curr.next != null; curr = curr.next) {
                    if (data.compareTo(curr.next.data) == 0) {
                        curr.next = curr.next.next;
                        return;
                    }
                }
            }
        }
    }

    public E retrieve(int index) {

        E temp = null;
        int i = 0;

        for (Node<E> curr = head; curr != null; curr = curr.next, ++i) {
            if (i == index) {
                temp = curr.data;
                break;
            }
        }

        return temp;
    }

    public boolean search(E data) {

        for (Node<E> curr = head; curr != null; curr = curr.next) {
            if (data.compareTo(curr.data) == 0) {
                return true;
            }
        }

        return false;
    }
}
