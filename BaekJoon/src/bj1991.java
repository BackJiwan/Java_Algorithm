import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class bj1991 {
    public static class Node {
        Node left;
        Node right;
        char data;

        Node(char data) {
            this.data = data;
        }
    }
    public static class Tree {
        Node root;

        public void insert(char data,char left,char right){
            if(root==null){
                if(data != '.'){
                    root = new Node(data);
                }
                if(left != '.'){
                    root.left = new Node(left);
                }
                if(right != '.'){
                    root.right = new Node(right);
                }
            } else {
                search(root,data,left,right);
            }
        }

        public void search(Node root,char data,char left,char right){
            if(root ==null) {
                return;
            } else if(root.data == data){
                if(left != '.'){
                    root.left = new Node(left);
                }
                if(right != '.'){
                    root.right = new Node(right);
                }
            }else{
                search(root.left,data,left,right);
                search(root.right,data,left,right);
            }
        }

        public void preOrder(Node root){ //루트 , 왼쪽, 오른쪽
            System.out.print(root.data);
            if(root.left != null){
                preOrder(root.left);
            }
            if(root.right != null){
                preOrder(root.right);
            }
        }

        public void inOrder(Node root){
            if(root.left != null){
                inOrder(root.left);
            }
            System.out.print(root.data);
            if(root.right != null){
                inOrder(root.right);
            }
        }

        public void postOrder(Node root){
            if(root.left != null){
                preOrder(root.left);
            }
            if(root.right != null){
                postOrder(root.right);
            }
            System.out.print(root.data);
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine()); //노드의 개수

        Tree tree = new Tree();

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine()," ");
            tree.insert(st.nextToken().charAt(0),st.nextToken().charAt(0),st.nextToken().charAt(0));
        }
        tree.preOrder(tree.root);
        System.out.println();
        tree.inOrder(tree.root);
        System.out.println();
        tree.postOrder(tree.root);
    }
}
