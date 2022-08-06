import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class bj5639 {
    public static class Node{ //노드는 왼쪽자식,오른쪽 자식과 정수 key를 가진다.
        Node left;
        Node right;
        int value;
        Node(int data){ //생성자
            this.value = data;
            this.left = null;
            this.right = null;
        }
        void insert(int num){ //값을 넣는 메서드는 이진 검색 트리의 정의를 따른다.
            if(num<this.value){ //작다면 왼쪽 자식으로 보내는데
                if(this.left != null){ //만약 왼쪽 자식이 비어있지 않다면 해당 위치에서 재귀적으로 insert 메서드를 실행
                    this.left.insert(num);
                }else { //만약 왼쪽 자식이 null이라면 해당 key를 가지는 노드를 생성한다.
                    this.left = new Node(num);
                }
            } else{ //크거나 같다면 오른쪽 자식으로 보내는데
                if(this.right != null){ //만약 오른쪽 자식이 비어있지 않다면 해당 위치에서 재귀적으로 insert 메서드를 실행
                    this.right.insert(num);
                } else { //만약 오른쪽 자식이 null이라면 해당 key를 가지는 노드를 생성한다.
                    this.right = new Node(num);
                }
            }
        }
    }

    public static void postOrder(Node node){ //후위순환
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
            if(input==null || input.equals("")) //종료조건
                break;
            tree.insert(Integer.parseInt(input));
        }
        postOrder(tree);
    }
}