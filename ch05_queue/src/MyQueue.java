import java.util.ArrayList;

public class MyQueue<T>{ //제네릭타입의 클래스를 먼저 만든다.
    private ArrayList<T> queue = new ArrayList<T>(); //내부에서 사용할(외부접근X) 제네릭 큐를 만든다.

    public void enqueue(T item){
        queue.add(item);
    }
    public T dequeue() {
        if(queue.isEmpty()){
            return null;
        }
        return queue.remove(0); //ArrayList는 맨앞의 요소를 꺼내라는 지정을 0 으로해주어야한다.
    }
    public boolean isEmpty() { //없어도 되는 메서드 이지만, MyQueue<T>클래스에 데이터가 있는지 없는지 알아보는 메서드
        return queue.isEmpty();
    }
    public static void main(String[] args){
        MyQueue<Integer> mq = new MyQueue<Integer>();
        mq.enqueue(1);
        mq.enqueue(2);
        mq.enqueue(3);
        System.out.println(mq.dequeue());
        System.out.println(mq.dequeue());
        System.out.println(mq.dequeue());
    }
}