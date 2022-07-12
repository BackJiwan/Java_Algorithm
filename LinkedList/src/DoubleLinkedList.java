public class DoubleLinkedList <T>{


    public static void main(String[] args){
        DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();

        list.addNode(1);
        list.addNode(2);
        list.addNode(3);
        list.addNode(4);
        list.addNode(5);
        list.printAll();
        System.out.println("---------------------");

        list.insertToFront(3,2);
        list.printAll();
        System.out.println("---------------------");

        list.insertToFront(6,2);
        list.insertToFront(1,0);
        list.printAll();
        System.out.println("---------------------");

        list.addNode(6);
        list.printAll();
    }

    public Node<T> head = null;
    public Node<T> tail = null;

    public class Node<T>{
        T data;
        Node<T> prev = null;
        Node<T> next = null;

        public Node(T data){
            this.data = data;
        }
    }

    public void addNode(T data){
        if(this.head == null){   // 만약 head가 null이라면 head에 data를 가지는 노드를 생성
            this.head = new Node<T>(data);
            this.tail = this.head;
        } else{ //head가 null이 아니라면 data를 가지는 현재 노드 node를 생성
            Node<T> node = this.head; //헤드를 현재노드로 보기

            while(node.next != null){ //null 만날때까지 next로 이동
                node = node.next;
            }
            node.next = new Node<T>(data); //현재 노드의 next는 null 이므로 data노드 추가
            node.next.prev = node; // data노드의 이전 노드는 현재 node
            this.tail = node.next; // null 되어있는 tail을 마지막 노드로 설정
        }
    }

    public void printAll(){
        if(this.head != null){
            Node<T> node = this.head;
            System.out.println(node.data);
            while(node.next != null){
                node = node.next;
                System.out.println(node.data);
            }
        }
    }

    public T searchFromHead(T isData){
        if(this.head == null){
            return null;
        } else {
            Node<T> node = this.head;
            while(node != null){
                if(node.data == isData){
                    return node.data;
                } else {
                    node = node.next;
                }
            }
            return null;
        }
    }

    public T searchFromTail(T isData){
        if(this.tail == null){
            return null;
        } else {
            Node<T> node = this.tail;
            while(node != null){
                if(node.data ==isData){
                    return node.data;
                } else {
                    node = node.prev;
                }
            }
            return null;
        }

    }

    public boolean insertToFront(T existedData,T addData) {
        if (this.head == null) {
            this.head = new Node<T>(addData);
            this.tail = this.head;
            return true;
        } else if (this.head.data == existedData) {
            Node<T> newHead = new Node<T>(addData);
            newHead.next = this.head;
            this.head = newHead;
            return true;
        } else {
            Node<T> node = this.head;
            while (node != null) {
                if (node.data == existedData) {
                    Node<T> nodePrev = node.prev;

                    nodePrev.next = new Node<T>(addData);
                    nodePrev.next.next = node;

                    nodePrev.next.prev = nodePrev;
                    node.prev = nodePrev.next;
                    return true;
                } else {
                    node = node.next;
                }
            }
            return false;
        }
    }
}
