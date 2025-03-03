package amro;
import java.util.Scanner;


public final class avl1 {
    static  class Node{
        int val;
        int height;
        Node left,right;
        Node(int val){
            this.val=val;
            left=right=null;
            height=1;

        }
    
    }
    static int height(Node root){

        return root==null?0:root.height;

    }
    static int getBalance(Node node){
        return node==null?0:height(node.left)-height(node.right);

    }
    static Node leftRotate(Node root){
        
        Node temp=root.right;
        Node t=temp.left;
        temp.left=root;

        root.right=t;
        root.height=Math.max(height(root.left),height(root.right))+1;
        temp.height=Math.max(height(temp.left),height(temp.right))+1;
        return temp;


    }
    static Node rightRotate(Node root){
        
        Node temp=root.left;
        Node t=temp.right;
        temp.right=root;

        root.left=t;
        root.height=Math.max(height(root.left),height(root.right))+1;
        temp.height=Math.max(height(temp.left),height(temp.right))+1;
        return temp;


    }

    static Node insert(Node root,int val){
        if (root==null){
            return new Node(val);
        }
        if (val<root.val){
            root.left=insert(root.left,val);
        }else if(val>root.val){
            root.right=insert(root.right,val);

        }else{
            return root;
        }
        root.height = Math.max(height(root.left), height(root.right)) + 1;

        int balance = getBalance(root);
    
        
        if (balance > 1 && val < root.left.val) {
            System.out.printf("Inserting %d makes the tree unbalanced in the subtree with root: %d after rotating: Right\n",val,root.val);
            return rightRotate(root);  
        }
        if (balance < -1 && val > root.right.val) {
            System.out.printf("Inserting %d makes the tree unbalanced in the subtree with root: %d after rotating: Left\n",val,root.val);
            return leftRotate(root);   
        }
        if (balance > 1 && val > root.left.val) {
            System.out.printf("Inserting %d makes the tree unbalanced in the subtree with root: %d after rotating: Left/Right\n",val,root.val);
            root.left = leftRotate(root.left); 
            return rightRotate(root);
        }
        if (balance < -1 && val < root.right.val) {
            System.out.printf("Inserting %d makes the tree unbalanced in the subtree with root: %d after rotating: Right/Left\n",val,root.val);
            root.right = rightRotate(root.right); 
            return leftRotate(root);
        }
    
        return root;

    }
    static Node findMin(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
    static Node delete(Node node,int val){
        if (node == null) {
            return node;
        }

       
        if (val < node.val) {
            node.left = delete(node.left, val);
        } else if (val > node.val) {
            node.right = delete(node.right, val);
        } else {
            if (node.left == null || node.right == null) {
                Node temp = (node.left != null) ? node.left : node.right;
                node = temp;
            } else {
                Node temp = findMin(node.right);
                node.val = temp.val;
                node.right = delete(node.right, temp.val);
            }
        }

        if (node == null) {
            return node;
        }

        node.height = Math.max(height(node.left), height(node.right)) + 1;

        int balance = getBalance(node);

        
        if (balance > 1 && getBalance(node.left) >= 0) {
            System.out.printf("Inserting %d makes the tree unbalanced in the subtree with root: %d after rotating: Right\n",val,node.val);
            return rightRotate(node);
        }
        
        if (balance > 1 && getBalance(node.left) < 0) {
            System.out.printf("Inserting %d makes the tree unbalanced in the subtree with root: %d after rotating: Left/Right\n",val,node.val);
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
      
        if (balance < -1 && getBalance(node.right) <= 0) {
            System.out.printf("Inserting %d makes the tree unbalanced in the subtree with root: %d after rotating: Left\n",val,node.val);
            return leftRotate(node);
        }
        
        if (balance < -1 && getBalance(node.right) > 0) {
            System.out.printf("Inserting %d makes the tree unbalanced in the subtree with root: %d after rotating: Right/Left\n",val,node.val);
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;

    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int a = scan.nextInt();   
        scan.nextLine();  
        if (a>1){
            String[] l1 = scan.nextLine().split(" ");
            int x1 = Integer.parseInt(l1[1]); 
            Node root = new Node(x1);
            for (int i = 0; i < a - 1; i++) {
                String[] l = scan.nextLine().split(" ");
                
                if (l.length < 2) {
                    System.out.println("Invalid input at operation " + (i + 1));
                    continue;
                }
                
                String operation = l[0];
                int val = Integer.parseInt(l[1]);  
        
                if (operation.equals("insert")) {
                    root = insert(root, val);
                } else if (operation.equals("delete")) {
                    root = delete(root, val);
                } else {
                    System.out.println("Unknown operation: " + operation);
                }
            }
            
            scan.close();
        }else{
            return;
        }

        }
        
      

    
        
    
    
}
