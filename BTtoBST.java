public class BTtoBST {
    class Node {
        Node left;
        Node right;
        int key;

        Node(int key) {
            this.key = key;
            this.left = null;
            this.right = null;
        }
    }

    Node root;

    BTtoBST(int node) {
        this.root = new Node(node);
    }

    // In-order traversal to collect all node values in an array
    public void inorderTraversal(Node node, int[] arr, int[] index) {
        if (node == null) {
            return;
        }

        inorderTraversal(node.left, arr, index);  // Traverse left subtree
        arr[index[0]++] = node.key;  // Store the current node's key in the array
        inorderTraversal(node.right, arr, index); // Traverse right subtree
    }

    // Bubble sort method to sort the array in ascending order
    public void bubblesort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Convert Binary Tree to Binary Search Tree
    public void bttobst() {
        // Step 1: Get all the node values in an array using in-order traversal
        int size = countNodes(root);
        int[] arr = new int[size];
        int[] index = {0};
        inorderTraversal(root, arr, index);

        // Step 2: Sort the array
        bubblesort(arr);

        // Step 3: Traverse the tree again and update the node values from the sorted array
        index[0] = 0; // Reset index for the sorted array
        inorderTraversalAndSort(root, arr, index);
    }

    // In-order traversal to assign sorted values back to the tree
    public void inorderTraversalAndSort(Node node, int[] arr, int[] index) {
        if (node == null) {
            return;
        }

        inorderTraversalAndSort(node.left, arr, index);
        node.key = arr[index[0]++];  // Assign sorted value to node
        inorderTraversalAndSort(node.right, arr, index);
    }

    // Method to count the number of nodes in the binary tree
    public int countNodes(Node root) {
        if (root == null) {
            return 0;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    // In-order traversal to print the tree
    public void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.key + " ");
        inorder(root.right);
    }

    public void ConstructBT() {
        // simple binary tree (not a BST)
        root.left = new Node(99);
        root.left.left = new Node(78);
        root.left.right = new Node(40);
        root.right = new Node(24);
        root.right.left = new Node(45);
        root.right.right = new Node(18);
    }

    public static void main(String[] args) {
        BTtoBST tree = new BTtoBST(100);

        // Construct the Binary Tree
        tree.ConstructBT();

        System.out.println("Original Binary Tree (In-order traversal): ");
        tree.inorder(tree.root);
        System.out.println();

        // Convert the Binary Tree to Binary Search Tree
        tree.bttobst();

        System.out.println("\nConverted Binary Search Tree (In-order traversal): ");
        tree.inorder(tree.root);
    }
}
