import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Collections;

public class bj11279_new {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> heap  = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0;i<n;i++){
            int num = Integer.parseInt(br.readLine());
            if(num == 0){
                if(heap.isEmpty()){
                    System.out.println(0);
                } else {
                    System.out.println(heap.poll());
                }
            } else {
                heap.offer(num);
            }
        }
    }
}

