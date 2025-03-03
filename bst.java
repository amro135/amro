package amro;
import java.util.Scanner;
public final class bst{
    static class  Node{
        Node left,right;
        int val;
        Node(int val){
            left=right=null;
            this.val=val;

        }
    
    }
    static Node insert(Node root,int val){
        if (root==null){
            return new Node(val);
           
        }
        if(val<root.val){
            root.left=insert(root.left,val);

        }else if(val>root.val){
            root.right=insert(root.right,val);
        }
        return root;
        
    }
    static Node find_min(Node root){
        while (root.left!=null){
            root=root.left;
        }
        return root;

    }
    static Node find_max( Node root){
        while(root.right!=null){
            root=root.right;

        }
        return root;
    }
    static Node delete(Node root,int val){
        if (root==null){
            return root;
        }
        if (val<root.val){
            root.left=delete(root.left,val);
        }else if(val>root.val){
            root.right=delete(root.right,val);
        }else {
            if (root.left==null && root.right==null){
                return null;
            }else if (root.left==null){
                return root.right ;
            }else if(root.right==null){
                return root.left;
            }else{
                Node min1=find_min(root.right);
                root.val=min1.val;
                root.right=delete(root.right, min1.val);
            }
          
          
        }
        return root;
            

    }
    static  int sum_j(Node root ,int j,int c){
        if (root==null){
            return 0;
        }

        if (c==j){
            return root.val;
        }
        return sum_j(root.left,j,c+1)+sum_j(root.right,j,c+1);


    }
    // static int  sum(Node root){
    //     if (root==null){
    //         return 0;
    //     }
    //     if (root.left==null &&root.right==null){
    //         return root.val;
    //     }
    //     return sum(root.left)+sum(root.right);

    // }
    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        String s=scan.nextLine();
        String[] s1=s.split(" ");
        int n=Integer.parseInt(s1[0]);
        int m=Integer.parseInt(s1[1]);
        int j=Integer.parseInt(s1[2]);
        Node root=new Node(n);
        for(int i=0;i<m;i++){
            String v=scan.nextLine();
            String[] v1=v.split(" ");
            int o=Integer.parseInt(v1[0]);
            int k=Integer.parseInt(v1[1]);
            if (o==1){
                root=insert(root, k);
            }else{
                root=delete(root, k);
            }
           

        }
        System.out.println(sum_j(root,j,1));


    }
}