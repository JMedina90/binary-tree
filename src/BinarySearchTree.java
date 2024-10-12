/*
    A Binary Search Tree: https://study.com/academy/lesson/binary-search-trees-definition-uses.html
*/
public class BinarySearchTree {
    Node root;

    BinarySearchTree() {
        // Init with an empty root.
        root = null;
    }

    // Method to initialize a tree with a given array of values
    public void createTree(int[] values) {
        for (int value : values) {
            addNode(value);
        }
    }

    // Public method to add a new node to the tree with the specified key
    public void addNode(int key) {
        root = addNodeToTree(root, key);
    }

    // Public method to delete a node with the specified key from the tree
    public void deleteNode(int key) {
        deleteNodeFromTree(root, key);
    }

    // Public method to print the tree nodes in InOrder traversal
    public void printInOrder() {
        printTreeInOrder(root);
    }

    // Public method to print the tree nodes in PreOrder traversal
    public void printPreOrder() {
        printTreePreOrder(root);
    }

    // Public method to print the tree nodes in PostOrder traversal
    public void printPostOrder() {
        printTreePostOrder(root);
    }

    private boolean keyExists(Node root, int key) {
        // Base case: if the tree is empty, or we've reached a leaf, return false
        if (root == null) {
            return false;
        }

        // If the current node's key matches the key we're searching for, return true
        if (root.key == key) {
            return true;
        }

        // Recur on the left subtree if the key is less than the current node's key
        if (key < root.key) {
            return keyExists(root.left, key);
        }

        // Otherwise, recur on the right subtree
        return keyExists(root.right, key);
    }

    // Helper method to add a new node to the tree
    private Node addNodeToTree(Node root, int key) {
        // If the tree is empty, create a new node as the root
        if (root == null) {
            root = new Node(key);
            return root;
        }

        // Recursively find the correct position for the new node
        if (key < root.key) {
            root.left = addNodeToTree(root.left, key);
        } else if (key > root.key) {
            root.right = addNodeToTree(root.right, key);
        }

        return root; // Return the root reference in case it the previous condition fails.
    }

    // Helper method to delete a node from the tree
    private Node deleteNodeFromTree(Node root, int key) {
        // if the tree is empty
        if (root == null) return root;
        // if key does not exist
        if (!keyExists(root, key)) {
            System.out.println("Key does not exists in Tree");
            return root;
        }

        // Find the node to be deleted
        if (key < root.key) {
            root.left = deleteNodeFromTree(root.left, key);
        } else if (key > root.key) {
            root.right = deleteNodeFromTree(root.right, key);
        } else {
            // Node with only one child or no child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            // Node with two children: get the smallest value in the right subtree
            root.key = minValueInTree(root.right);
            root.right = deleteNodeFromTree(root, root.key);

        }
        return root;
    }

    // Helper to find the minimum key value in a given tree/subtree
    private int minValueInTree(Node root) {
        int minValue = root.key;
        while (root.left != null) {
            minValue = root.left.key;
            root = root.left;
        }
        return minValue;
    }

    private void printTreeInOrder(Node root) {
        if (root != null) {
            printTreeInOrder(root.left);
            System.out.print(root.key + " ");
            printTreeInOrder(root.right);
        }
    }

    private void printTreePreOrder(Node root) {
        if (root != null) {
            System.out.print(root.key + " ");
            printTreePreOrder(root.left);
            printTreePreOrder(root.right);
        }
    }

    private void printTreePostOrder(Node root) {
        if (root != null) {
            printTreePostOrder(root.left);
            printTreePostOrder(root.right);
            System.out.print(root.key + " ");
        }
    }
}
