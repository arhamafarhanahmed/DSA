public class BinaryTree {
    class Node{
        Node left;
        Node right;
        int key;

        Node(int key){
            this.key = key;
            this.left = null;
            this.right = null;
        }

    }

    Node root;
    BinaryTree(int root){
        this.root = new Node(root);

    }

   public  int calculateLevel(Node node , int key , int currentlevel){
        if(node == null){
            return -1;
        }

        if(node.key == key){
            return currentlevel;
        }

        int leftlevel = calculateLevel(node.left,key,currentlevel + 1);
        if(leftlevel != -1){
            return leftlevel;
        }

        return calculateLevel(node.right,key,currentlevel + 1);


    }




    public void constructTree(){
        root.left = new Node(10);
        root.right = new Node(20);

        root.left.left = new Node(8);
        root.left.right = new Node(2);

        root.right.left = new Node(18);
        root.right.right = new Node(2);
    }


    public boolean sumproperty(Node node){
        if(node == null || (node.left == null && node.right == null)){
            return true;
        }

        int leftsum = 0;
        if(node.left != null){
            leftsum = node.left.key;
        }

        int rightsum = 0;
        if(node.right != null){
            rightsum = node.right.key;
        }

        if(node.key == leftsum + rightsum){
            return sumproperty(node.left) && sumproperty(node.right);
        }else {
            return false;
        }
    }
    public boolean checkTree(Node node , int index, int nodeCount){
        if (node == null) {
            return true;

        }
        if(index >= nodeCount){
            return false;
        }
        return checkTree(node.left ,2 * index + 1,nodeCount)&&
                checkTree(node.right,2 * index + 2 ,nodeCount);

    }

    public int countNodes(Node node) {
        if (node == null) {
            return 0;

        }

        // Count the node + left subtree + right subtree
        return 1 + countNodes(node.left) + countNodes(node.right);
    }


    public static void main(String[] args) {
        BinaryTree t = new BinaryTree(30);
        t.constructTree();
        int key = 20;
       int level = t.calculateLevel(t.root,key,0);
        System.out.println(key +" is found at" +level+ "level");





if(t.sumproperty(t.root)){
    System.out.println("satisfy property");
}else {
    System.out.println("not satisfy");
}






        int count = t.countNodes(t.root);
        if(t.checkTree(t.root, 0,count)) {
            System.out.println("tree is complete");
        }else{
            System.out.println("tree is not complete");
        }

    }
}
