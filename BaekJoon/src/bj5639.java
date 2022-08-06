import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class bj5639 {
    public static class Node{
        Node left;
        Node right;
        int value;
        Node(int data){
            this.value = data;
            this.left = null;
            this.right = null;
        }
        void insert(int num){
            if(num<this.value){
                if(this.left != null){
                    this.left.insert(num);
                }else {
                    this.left = new Node(num);
                }
            } else{
                if(this.right != null){
                    this.right.insert(num);
                } else {
                    this.right = new Node(num);
                }
            }
        }
    }

    public static void postOrder(Node node){
        if(node == null)
            return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.value);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Node tree = new Node(Integer.parseInt(br.readLine()));

        while(true){
            String input = br.readLine();
            if(input==null || input.equals(""))
                break;
            tree.insert(Integer.parseInt(input));
        }
        postOrder(tree);
    }
}