import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class bj2346 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedList<int[]> deque = new LinkedList<>(); //풍선은 번호와 내부에 적힌 수를 가진다.{위치,종이에 적힌 수}
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine()); //풍선의 개수 n 입력받기
        StringTokenizer st = new StringTokenizer(br.readLine()," "); //풍선 내부의 수 입력받기

        for(int i=1;i<=n;i++){ // 풍선의 개수만큼 반복, 풍선의 번호와 내부의 종이를 deque에 저장
            deque.offer(new int[]{i,Integer.parseInt(st.nextToken())});
        }

        int temp = deque.pollFirst()[1]; //맨 앞 풍선을 터뜨리고 종이의 수를 temp에 초기화
        sb.append(1+" "); //터진 풍선의 번호를 sb에 저장
        while(!deque.isEmpty()){
            if(temp>0){ //종이의 수가 양수라면 맨앞의 요소를 맨뒤로 보내면서 터트릴 풍선을 제일 앞에 위치시키기
                for(int i=1;i<temp;i++){
                    deque.offerLast(deque.pollFirst());
                }
                sb.append(deque.peekFirst()[0]+" ");
                temp = deque.pollFirst()[1]; // 터진 풍선을 제거하면서 내부에 적힌 종이의 수를 가져오기
            } else{ // 종이의 수가 음수라면 맨뒤의 요소를 맨앞으로 보내면서 터트릴 풍선을 제일 뒤에 위치시키기
                for(int i=1;i<-temp;i++){
                    deque.offerFirst(deque.pollLast());
                }
                sb.append(deque.peekLast()[0]+" ");
                temp = deque.pollLast()[1];// 터진 풍선을 제거하면서 내부에 적힌 종이의 수를 가져오기
            }
        }
        System.out.print(sb);
    }
}
