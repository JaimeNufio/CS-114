import java.util.Random;
import java.util.Vector;

public class Main {

    public static void main(String[] args) {

        BinaryTree<Integer> tree = new BinarySearchTree<Integer>();
        Random rand;
        int num = args.length == 1 ? Integer.parseInt(args[0]) : 1;
        long start, stop;

        rand = new Random(1);
        System.out.print("insert: ");
        start = System.currentTimeMillis();
        for (int i = 0; i < num; ++i) {
            tree.insert(rand.nextInt(num));
        }
        stop = System.currentTimeMillis();
        System.out.println(stop - start);

        rand = new Random(1);
        System.out.print("search: ");
        for (int i = 0; i < num; ++i) {
            if (!tree.search(rand.nextInt(num))) {
                System.out.println("Fail");
                break;
            }
        }
        for (Integer i : tree) {
            if (!tree.search(i)) {
                System.out.println("Fail");
                break;
            }
        }
        System.out.println("Pass");

        tree.remove(num+1);

        rand = new Random(1);
        System.out.print("remove: ");
        start = System.currentTimeMillis();
        for (int i = 0; i < num; ++i) {
            tree.remove(rand.nextInt(num));
        }
        stop = System.currentTimeMillis();
        System.out.println(stop - start);

        rand = new Random(1);
        System.out.print("search: ");
        for (int i = 0; i < num; ++i) {
            if (tree.search(rand.nextInt(num))) {
                System.out.println("Fail");
                break;
            }
        }
        System.out.println("Pass");

        System.out.println(tree.root == null);
    }
}
