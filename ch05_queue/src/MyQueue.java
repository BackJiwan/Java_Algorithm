import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;

public class MyQueue<T>{ //제네릭타입의 클래스를 먼저 만든다.
    private ArrayList<T> queue = new ArrayList<T>();

    public void enqueue(T item){
        queue.add(item);
    }
    public T dequeue(){
        if(queue.isEmpty()){
            return null;
        }
        return queue.remove(0);
    }
    public boolean isEmpty(){
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