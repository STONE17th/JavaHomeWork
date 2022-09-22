import java.util.ArrayDeque;
import java.util.Scanner;

public class Task015 {

    public static class Node{
        int value;
        Node left, right;
        boolean visited;

        public Node(int value) {
            this.value = value;
            this.visited = false;
        }
    }

    public static void searchBFS(StringBuilder path, ArrayDeque<Node> BFS, Node node){
        if (node == null) return;
        path.append("->");

        if (node.left != null && !node.left.visited){
            BFS.addLast(node.left);
            node.left.visited = true;
        }
        if (node.right != null && !node.right.visited){
            BFS.addLast(node.right);
            node.right.visited = true;
        }

        searchBFS(path.append(node.value), BFS, BFS.pollFirst());
    }

    public static void searchDFS(StringBuilder path, ArrayDeque<Node> BFS, Node node){
        if (node == null) return;
        path.append("->");

        if (node.right != null && !node.right.visited){
            BFS.addFirst(node.right);
            node.right.visited = true;
//            searchDFS(path.append(node.value), BFS, BFS.pollFirst());
        }
        if (node.left != null && !node.left.visited){
            BFS.addFirst(node.left);
            node.left.visited = true;
//            searchDFS(path.append(node.value), BFS, BFS.pollFirst());
        }
        searchDFS(path.append(node.value), BFS, BFS.pollFirst());
    }

    public static void printTree(){
        System.out.println("        1");
        System.out.println("      /   \\ ");
        System.out.println("    2       3");
        System.out.println("   / \\     / \\ ");
        System.out.println("  4   5   6   7");
        System.out.println(" /         \\ ");
        System.out.println("8           9");
    }

    public static void main(String[] args) {
        Node mainTree = new Node( 1);
        Node levelOneLeft = new Node(2);
        Node levelOneRight = new Node(3);
        Node levelTwoOneLeft = new Node(4);
        Node levelTwoOneRight = new Node(5);
        Node levelTwoTwoLeft = new Node(6);
        Node levelTwoTwoRight = new Node(7);
        Node levelThreeOneLeft = new Node(8);
        Node levelThreeThreeRight = new Node(9);
        mainTree.left = levelOneLeft;
        mainTree.right = levelOneRight;
        levelOneLeft.left = levelTwoOneLeft;
        levelOneLeft.right = levelTwoOneRight;
        levelOneRight.left =  levelTwoTwoLeft;
        levelOneRight.right = levelTwoTwoRight;
        levelTwoOneLeft.left = levelThreeOneLeft;
        levelTwoTwoLeft.right = levelThreeThreeRight;

        printTree();
        Scanner input = new Scanner(System.in);
        System.out.print("Выберите метод обхода (1 - в ширину, 2 - в глубину): ");
        int option = input.nextInt();
        ArrayDeque<Node> deque = new ArrayDeque<>();
        StringBuilder path = new StringBuilder();
        if (option == 1) {
            searchBFS(path, deque, mainTree);
            System.out.println("Обход в ширину:");
            System.out.println(path);
        }
        else {
            searchDFS(path, deque, mainTree);
            System.out.println("Обход в ширину:");
            System.out.println(path);
        }

    }
}
