import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class bj2075 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine()); // n입력받기

        //우선순위 큐를 이용하여 최대힙 선언
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " "); //한줄 입력받고 쪼개기
            for (int j = 0; j < n; j++) {
                heap.add(Integer.parseInt(st.nextToken())); //최대 힙에 차례대로 insert
            }
        }
        for(int i=0;i<n-1;i++){ //최상단 루트부터 가장큰수가 들어있으며 n-1번 제거
            heap.remove();
        }
        System.out.print(heap.poll()); //n번째요소를 poll 하며 출력
    }
}