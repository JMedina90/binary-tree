class BinarySearchTree {
    Node root;

    // Method to initialize a tree with a given array of values
    public void createTree() {
        int[] data = {1, 2, 3, 4, 5, 6, 7};
        root = buildBinarySearchTree(data, 0, data.length - 1);
    }

    // Public method to add a new node to the tree with the specified key
    public void addNode(int key) {
        root = addNodeToTree(root, key);
    }

    private Node buildBinarySearchTree(int[] arr, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        Node node = new Node(mid + 1);
        node.left = buildBinarySearchTree(arr, start, mid - 1);
        node.right = buildBinarySearchTree(arr, mid + 1, end);
        return node;
    }

    // Public method to delete a node with the specified key from the tree
    public void deleteNode(int key) {
        root = deleteNodeFromTree(root, key);
    }

    // Public method to print the tree nodes in InOrder traversal
    public void printInOrder() {
        printTreeInOrder(root);
        System.out.println();
    }

    // Public method to print the tree nodes in PreOrder traversal
    public void printPreOrder() {
        printTreePreOrder(root);
    }

    // Public method to print the tree nodes in PostOrder traversal
    public void printPostOrder() {
        printTreePostOrder(root);
    }

    // Recursive function to insert a new key in BST
    private Node addNodeToTree(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }
        if (key < root.data) {
            root.left = addNodeToTree(root.left, key);
        } else if (key > root.data) {
            root.right = addNodeToTree(root.right, key);
        }
        return root;
    }

    // Recursive function to delete a node
    private Node deleteNodeFromTree(Node root, int key) {
        if (root == null) return root;

        // Find the node to be deleted
        if (key < root.data) {
            System.out.println("Going left from " + root.data);
            root.left = deleteNodeFromTree(root.left, key);
        } else if (key > root.data) {
            System.out.println("Going right from " + root.data);
            root.right = deleteNodeFromTree(root.right, key);
        } else {
            System.out.println("Deleting node " + key);
            // Node with only one child or no child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            // Node with two children: get the smallest value in the right subtree
            root.data = minValueInTree(root.right);
            root.right = deleteNodeFromTree(root.right, root.data);
        }
        return root;
    }

    // Helper to find the minimum key value in a given tree/subtree
    private int minValueInTree(Node root) {
        int minValue = root.data;
        while (root.left != null) {
            minValue = root.left.data;
            root = root.left;
        }
        return minValue;
    }

    private void printTreeInOrder(Node root) {
        if (root != null) {
            printTreeInOrder(root.left);
            System.out.print(root.data + " ");
            printTreeInOrder(root.right);
        }
    }

    private void printTreePreOrder(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            printTreePreOrder(root.left);
            printTreePreOrder(root.right);
        }
    }

    private void printTreePostOrder(Node root) {
        if (root != null) {
            printTreePostOrder(root.left);
            printTreePostOrder(root.right);
            System.out.print(root.data + " ");
        }
    }
}
