import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.LinkedList;

public class bj1021_try2 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedList<Integer> deque = new LinkedList<>();
        StringTokenizer st1,st2;

        st1 = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st1.nextToken()); //큐의 크기
        int m = Integer.parseInt(st1.nextToken()); //뽑은 횟수
        for(int i=1;i<=n;i++){ //큐를 원소의 위치를 의미하는 숫자로 초기화한다.
            deque.add(i);
        }

        st2 = new StringTokenizer(br.readLine()," ");
        int[] arr = new int[m];
        for(int i =0;i<m;i++){
            arr[i] = Integer.parseInt(st2.nextToken());
        }

        int cnt =0;

        for(int i=0; i<m; i++){ //매 반복이후 큐의 구성이 달라지기 때문에 반복문 안쪽에서 half를 회차마다 새로 만들어 내야한다.
            int half;
            int idx = deque.indexOf(arr[i]);

            if(deque.size() % 2 == 0){ //half에 해당하는 위치와 같거나 작은 경우 2번 연산이 최솟값을 만들어내고 그 이외는 3번 연산이 필요하다.
                half = deque.size()/2-1;
            } else {
                half = deque.size()/2;
            }

            if(idx <= half){ //뽑고자 하는수가 deque의 어디위치에 있는지 또한 반복마다 변화한다.
                for(int j =0;j<idx;j++){
                    deque.offerLast(deque.pollFirst());
                    cnt++;
                }
            } else{
                for(int j=0;j<deque.size()-idx;j++){
                    deque.offerFirst(deque.pollLast());
                    cnt++;
                }
            }
            deque.pollFirst();
        }
        System.out.println(cnt);
    }
}
