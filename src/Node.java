public class Node {
    int key; //
    Node left, right;

    public Node(int item){
        this.key = item;

        // Initializes the left and right child references to null indicating this node has no children yet
        left = right = null;
    }
}
