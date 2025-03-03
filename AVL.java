package amro;
// AVL Tree implementation in Java
class Node {
    int key, height;
    Node left, right;

    public Node(int key) {
        this.key = key;
        this.height = 1;
    }
}

class AVLTree {
    private Node root;

    // Get the height of the node
    private int height(Node node) {
        return (node == null) ? 0 : node.height;
    }

    // Get balance factor
    private int getBalance(Node node) {
        return (node == null) ? 0 : height(node.left) - height(node.right);
    }

    // Right rotate
    private Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        // Perform rotation
        x.right = y;
        y.left = T2;

        // Update heights
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x;
    }

    // Left rotate
    private Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        // Perform rotation
        y.left = x;
        x.right = T2;

        // Update heights
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y;
    }

    // Insert a key
    public void insert(int key) {
        root = insert(root, key);
    }

    private Node insert(Node node, int key) {
        if (node == null)
            return new Node(key);

        if (key < node.key)
            node.left = insert(node.left, key);
        else if (key > node.key)
            node.right = insert(node.right, key);
        else
            return node; // Duplicates not allowed

        // Update height of this node
        node.height = Math.max(height(node.left), height(node.right)) + 1;

        // Get balance factor
        int balance = getBalance(node);

        // Balancing
        if (balance > 1 && key < node.left.key)
            return rightRotate(node); // Left-Left case

        if (balance < -1 && key > node.right.key)
            return leftRotate(node); // Right-Right case

        if (balance > 1 && key > node.left.key) {
            node.left = leftRotate(node.left);
            return rightRotate(node); // Left-Right case
        }

        if (balance < -1 && key < node.right.key) {
            node.right = rightRotate(node.right);
            return leftRotate(node); // Right-Left case
        }

        return node;
    }

    // Find the node with minimum value
    private Node minValueNode(Node node) {
        Node current = node;
        while (current.left != null)
            current = current.left;
        return current;
    }

    // Delete a key
    public void delete(int key) {
        root = delete(root, key);
    }

    private Node delete(Node root, int key) {
        if (root == null)
            return root;

        if (key < root.key)
            root.left = delete(root.left, key);
        else if (key > root.key)
            root.right = delete(root.right, key);
        else {
            if ((root.left == null) || (root.right == null)) {
                Node temp = (root.left != null) ? root.left : root.right;
                if (temp == null) {
                    temp = root;
                    root = null;
                } else
                    root = temp;
            } else {
                Node temp = minValueNode(root.right);
                root.key = temp.key;
                root.right = delete(root.right, temp.key);
            }
        }

        if (root == null)
            return root;

        root.height = Math.max(height(root.left), height(root.right)) + 1;

        int balance = getBalance(root);

        // Balancing
        if (balance > 1 && getBalance(root.left) >= 0)
            return rightRotate(root); // Left-Left case

        if (balance > 1 && getBalance(root.left) < 0) {
            root.left = leftRotate(root.left);
            return rightRotate(root); // Left-Right case
        }

        if (balance < -1 && getBalance(root.right) <= 0)
            return leftRotate(root); // Right-Right case

        if (balance < -1 && getBalance(root.right) > 0) {
            root.right = rightRotate(root.right);
            return leftRotate(root); // Right-Left case
        }

        return root;
    }

    // Inorder traversal
    public void inorder() {
        inorder(root);
        System.out.println();
    }

    private void inorder(Node node) {
        if (node != null) {
            inorder(node.left);
            System.out.print(node.key + " ");
            inorder(node.right);
        }
    }

    // Main function to test AVL Tree
    public static void main(String[] args) {
        AVLTree tree = new AVLTree();
        tree.insert(10);
        tree.insert(20);
        tree.insert(30);
        tree.insert(40);
        tree.insert(50);
        tree.insert(25);

        System.out.println("Inorder traversal:");
        tree.inorder();

        tree.delete(30);
        System.out.println("Inorder traversal after deletion:");
        tree.inorder();
    }
}
