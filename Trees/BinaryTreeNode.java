import java.util.Scanner;
// creating a class BinaryTreeNode class for implementing the Tree
class BinaryTreeNode<T>{
    T data;                // here we created our node as generic (which means we can insert any datatype)
    BinaryTreeNode left;
    BinaryTreeNode right;

    BinaryTreeNode(T data){  // Implementing the constructor of BinaryTreeNode class for creation of node
        this.data = data;     // Initialise the data of node of tree
        this.left = null;     // Initially setting left and right child of node as null(empty).
        this.right = null;
    }
    
    public static BinaryTreeNode<Integer> takeInput(){
        Scanner sc = new Scanner(System.in);
        int rootdata = sc.nextInt();   // taking data as input
        
        if(rootdata == -1){    // If data is -1 means it is a null pointer 
            return null;
        }
        // dynamically create rootnode which calls the constructor of same class 
        BinaryTreeNode<Integer> root = new BinaryTreeNode(rootdata);
        
        BinaryTreeNode<Integer> left = takeInput();   // Recursively calling over left subtree
        BinaryTreeNode<Integer> right = takeInput();  // Recursively calling over right subtree
        
        // Alloting the left and right child to the root node
        root.left = left;
        root.right = right;
        
        
        // return the root of tree we have created
        return root;
    }
    
    // method to print tree recursively in level-order
    public static void printTree(BinaryTreeNode<Integer> root){
        // base case
        if(root == null){   // if root is null then simply return
            return;
        }
        System.out.print(root.data+" ");   // displaying the root data
        // Recursively calling over left and right subtree
        printTree(root.left);
        printTree(root.right);
    }
    public static int countNode(BinaryTreeNode<Integer> root){
        // base case  --> if root is null means the our tree is empty
        if(root == null){
            return 0;
        }
        // Recursively calling the method over left and right subtree for their length and adding 1 to it because of node itself
        return 1 + countNode(root.left) + countNode(root.right);
    }
    
    // Method to find the maximum value present in Binary Tree  (T.C :- O(N) S.C :- O(N) for stack space)
    public static int findMaxmimum(BinaryTreeNode<Integer> root){
        // base-case
        if(root == null){
            return Integer.MAX_VALUE;
        }
        // Basic logic :- 
        // Maximum of tree will be maximum of left subtree, right subtree and root data itself
        
        
        int rData = root.data;    // data at root node
        int lMax = findMaxmimum(root.left);     // find the maximum value in left subtree Recursively
        int rMax = findMaxmimum(root.right);    // find the maximum value in right subtree Recursively
        
        return Math.max(rData, Math.max(lMax, rMax));
    }
    
    // Method to print Binary Tree in Inorder Traversal (LEFT -> ROOT -> RIGHT)
    public static void inOrder(BinaryTreeNode<Integer> root){
        
    }
    
}
public class Main{
    public static void main(String[] args){
        BinaryTreeNode root = BinaryTreeNode.takeInput();  // Taking a binary tree as Input
        // calling the method printTree from class BinaryTreeNode to display the tree in level order manner
        BinaryTreeNode.printTree(root);
        int totalNodes = BinaryTreeNode.countNode(root);
        System.out.println();
        System.out.println("Total number of nodes present in tree :- "+totalNodes);
    }
}
