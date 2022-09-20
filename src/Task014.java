public class Task014 {

    public static class Node{
        int value;
        Node left, right;

        public Node(int value) {
            this.value = value;
             }
    }
    public static StringBuilder printTree(Node node, StringBuilder treeString){
        treeString.append(node.value);
        if (node.left == null && node.right == null){
            return treeString;
        }
        if (node.left == null) {
            treeString.append("(nil,");
        }
        else {
            printTree(node.left, treeString.append("("));
            treeString.append(",");
        }
        if (node.right == null) {
            treeString.append("nil)");
        }
        else{
            printTree(node.right, treeString);
            treeString.append(")");
        }
        return treeString;

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

        StringBuilder treeString = new StringBuilder();
        System.out.println(printTree(mainTree, treeString));


    }
}
