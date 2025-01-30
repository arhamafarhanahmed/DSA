public class BinaryExpression{
    class Node{
        Node left;
        Node right;
        String key;

        Node(String key){
            this.key = key;
            this.left = null;
            this.right = null;
        }
    }

    Node root;

    BinaryExpression(String root){
        this.root = new Node(root);
    }


     void inorderTraversal(Node node){     //left , root , right
        if(node == null)
            return;

        inorderTraversal(node.left);
        System.out.print(node.key + " ");
        inorderTraversal(node.right);

    }



    void preorderTraversal(Node node){  //root,left,right
        if(node == null) {
            return;
        }

        System.out.print(node.key);
        preorderTraversal(node.left);
        preorderTraversal(node.right);


    }

    void postorderTraversal(Node node) // LEFT,RIGHT,ROOT
    {
        if(node == null) {
            return;
        }

        postorderTraversal(node.left);
        postorderTraversal(node.right);
        System.out.print(node.key+" ");


    }


    public void tree(){


         root.left = new Node("*");
         root.left.left = new Node("+");
         root.left.right = new Node("-");
         root.left.left.left = new Node("5");
         root.left.left.right = new Node("2");
         root.left.right.left = new Node("2");
         root.left.right.right = new Node("1");


          root.right = new Node("+");
          root.right.left = new Node("2");
          root.right.right = new Node("9");


    }



    public static void main(String[] args) {

       BinaryExpression T = new BinaryExpression("/");
             T.tree();
        System.out.println("Inorder traversal :");
             T.inorderTraversal(T.root);
        System.out.println();

        System.out.println("postorder traversal :");
             T.postorderTraversal(T.root);
        System.out.println();
        System.out.println("preorder traversal :");
             T.preorderTraversal(T.root);
        System.out.println();















    }
}