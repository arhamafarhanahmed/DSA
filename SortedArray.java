public class SortedArray {
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
    SortedArray(){
        root=null;
    }

       public    Node builtBST(Node root , int val){

        if(root == null){
            return  new Node(val);
        }


        if(root.key > val){
            root.left =builtBST(root.left , val);
        }else if(root.key < val){
           root.right = builtBST(root.right , val);
        }
        return root;
       }




    void displayInOrder(Node node) {
        if (node == null)
            return;

        displayInOrder(node.left);
        System.out.print(node.key + " ");  // Print current node
        displayInOrder(node.right);
    }


    public static void main(String[] args) {
        SortedArray tree = new SortedArray();

        int arr[] = {1 , 2 , 3 ,4 ,5 ,6 ,7};
        for(int i=0 ; i < arr.length ; i++){
            tree.root = tree.builtBST(tree.root, arr[i]);
        }
        System.out.println("inorder traversal :");
        tree.displayInOrder(tree.root);




    }
}
