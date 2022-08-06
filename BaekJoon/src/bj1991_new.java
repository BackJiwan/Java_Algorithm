import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class bj1991_new {
    public static class Node { //노드클래스
        Node left;
        Node right;
        char data;

        public Node(char data) {
            this.data = data;
        }
    }
    public static class Tree {
        Node root;

        public void insert(char data_in,char left_in,char right_in){
            if(root==null){
                if(data_in != '.'){ //입력이 . 이 아닌 값이라면 data를 가지는 root 노드 생성
                    root = new Node(data_in);
                }
                if(left_in != '.'){//입력이 . 이 아닌 값이라면 data를 가지는 root 왼쪽 자식 노드 생성
                    root.left = new Node(left_in);
                }
                if(right_in != '.'){//입력이 . 이 아닌 값이라면 data를 가지는 root 오른쪽 자식 노드 생성
                    root.right = new Node(right_in);
                }
            } else { //root가 null이 아니라면 data의 위치를 search한다.
                search(root,data_in,left_in,right_in);
            }
        }

        public void search(Node root,char data_in,char left_in,char right_in){
            if(root ==null) { //입력받은 root가 null이라면 return한다.
                return;
            } else if(root.data == data_in){ //입력받은 data가 root의 데이터라면
                if(left_in != '.'){ //입력받은 left값이 .이 아니라면 왼쪽 자식에 새로운 left 노드를 생성
                    root.left = new Node(left_in);
                }
                if(right_in != '.'){ //입력받은 right값이 .이 아니라면 오른쪽 자식에 새로운 right 노드를 생성
                    root.right = new Node(right_in);
                }
            }else{
                search(root.left,data_in,left_in,right_in);
                search(root.right,data_in,left_in,right_in);
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

        public void inOrder(Node root){ //왼쪽,루트,오른쪽
            if(root.left != null){
                inOrder(root.left);
            }
            System.out.print(root.data);
            if(root.right != null){
                inOrder(root.right);
            }
        }

        public void postOrder(Node root){ //왼쪽,오른쪽,루트
            if(root.left != null){
                postOrder(root.left);
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
