

class BinaryOperations {
    class Node {
        int key;
        Node left;
        Node right;

        Node(int key) {
            this.key = key;
            this.left = null;
            this.right = null;
        }
    }

    Node root;

    BinaryOperations() {
        root = null;  // Initialize empty tree
    }

    // Method to insert a node into the binary search tree
    public Node insert(Node root, int val) {
        if (root == null) {
            return new Node(val);  // Create a new node if tree is empty
        }

        if (val < root.key) {
            root.left = insert(root.left, val);  // Insert in left subtree
        } else {
            root.right = insert(root.right, val); // Insert in right subtree
        }

        return root;
    }

    // Postorder Traversal: left, right, root
    void displayPostOrder(Node node) {
        if (node == null)
            return;

        displayPostOrder(node.left);
        displayPostOrder(node.right);
        System.out.print(node.key + " ");  // Print current node
    }

    // Inorder Traversal: left, root, right
    void displayInOrder(Node node) {
        if (node == null)
            return;

        displayInOrder(node.left);
        System.out.print(node.key + " ");  // Print current node
        displayInOrder(node.right);
    }

    // Preorder Traversal: root, left, right
    void displayPreOrder(Node node) {
        if (node == null)
            return;

        System.out.print(node.key + " ");  // Print current node
        displayPreOrder(node.left);
        displayPreOrder(node.right);
    }

    // Search for a value in the binary search tree
    Node searchingdata(Node root, int val) {
        if (root == null) {
            return null;  // Value not found
        }
        if (val < root.key) {
            return searchingdata(root.left, val);  // Search in left subtree
        } else if (val > root.key) {
            return searchingdata(root.right, val); // Search in right subtree
        } else {
            return root;  // Value found
        }
    }

    // Method to delete a node with a specific key
    public Node delete(Node root, int key) {
        if (root == null) {
            return null; // Key not found
        }

        // Traverse the tree to find the node to delete
        if (key < root.key) {
            root.left = delete(root.left, key);
        } else if (key > root.key) {
            root.right = delete(root.right, key);
        } else {
            // Node found
            // Case 1: Node has no children (leaf node)
            if (root.left == null && root.right == null) {
                return null;
            }
            // Case 2: Node has one child
            else if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            // Case 3: Node has two children
            else {
                // Find the in-order successor (smallest node in the right subtree)
                Node successor = findMin(root.right);
                root.key = successor.key; // Replace root's value with successor's value
                root.right = delete(root.right, successor.key); // Delete the successor
            }
        }
        return root;
    }

    // Helper method to find the minimum value node in a subtree
    public Node findMin(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    public static void main(String[] args) {

        int[] value = {5, 1, 3, 4, 2, 7};
        BinaryOperations tree = new BinaryOperations();

        // Insert values into the tree using the instance
        for (int val : value) {
            tree.root = tree.insert(tree.root, val);
        }

        System.out.println("Inorder Traversal:");
        tree.displayInOrder(tree.root);
        System.out.println();

        System.out.println("Preorder Traversal:");
        tree.displayPreOrder(tree.root);
        System.out.println();

        System.out.println("Postorder Traversal:");
        tree.displayPostOrder(tree.root);
        System.out.println();

        // Search for a value in the tree
        int searchValue = 4;
        Node result = tree.searchingdata(tree.root, searchValue);
        if (result != null) {
            System.out.println("Value " + searchValue + " found in the tree.");
        } else {
            System.out.println("Value " + searchValue + " not found in the tree.");
        }

        // Delete a node and show updated traversals
        int deleteValue = 3;
        System.out.println("Deleting value " + deleteValue);
        tree.root = tree.delete(tree.root, deleteValue);

        System.out.println("Inorder Traversal after deletion:");
        tree.displayInOrder(tree.root);
        System.out.println();
    }
}
