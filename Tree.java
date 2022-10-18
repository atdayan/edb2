import java.util.Queue;
import java.util.LinkedList;

class Node {
    public char value;
    public Node left;
    public Node right;
    public int height;

    public Node(char value) {
        this.value = value;
    }
}

public class Tree {
    public static void main(String[] args) {
        
        Node a = new Node('A');

        a.left = new Node('B');
        a.left.left = new Node('D');
        a.left.right = new Node('H');
        a.left.left.right = new Node('J');

        a.right = new Node('C');
        a.right.left = new Node('E');
        a.right.right = new Node('F');
        a.right.right.left = new Node('I');

        postOrder(a);
        System.out.println();

        breadthSearch(a);
        System.out.println();
    }

    public static void postOrder(Node node) {
        if (node.left != null)
            postOrder(node.left);
        if (node.right != null)
            postOrder(node.right);
        calcHeight(node);
        System.out.format("%c ", node.value);
    }

    public static void calcHeight(Node node) {
        int h1 = 0;
        int h2 = 0;
        if (node.left != null)
            h1 = node.left.height;
        if (node.right != null)
            h2 = node.right.height;
        node.height = (h1 > h2) ? h1 + 1 : h2 + 1;
    }

    public static void breadthSearch(Node node) {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(node);
        
        while (!queue.isEmpty()) {
            Node n = queue.remove();
            System.out.format("%c ", n.value);
            if (n.left != null)
                queue.add(n.left);
            if (n.right != null)
                queue.add(n.right);
        }
    }
}
