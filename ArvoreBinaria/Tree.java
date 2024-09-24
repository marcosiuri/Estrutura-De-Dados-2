public class Tree {
    private Node root;

    public Tree() {
        this.root = null;
    }

    public void insert(int value) {
        if (root == null) {
            root = new Node(value);
        } else {
            insertRecursively(root, value);
        }
    }

    private void insertRecursively(Node node, int value) {
        if (value < node.value) {
            if (node.left == null) {
                node.left = new Node(value);
            } else {
                insertRecursively(node.left, value);
            }
        } else {
            if (node.right == null) {
                node.right = new Node(value);
            } else {
                insertRecursively(node.right, value);
            }
        }
    }

    public void displayInOrder() {
        displayInOrderRecursively(root);
    }

    private void displayInOrderRecursively(Node node) {
        if (node != null) {
            displayInOrderRecursively(node.left);
            System.out.print(node.value + " ");
            displayInOrderRecursively(node.right);
        }
    }
}
