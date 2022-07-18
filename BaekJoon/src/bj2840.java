/*
1. 원판의 움직임을 생각하면 화살표가 가리키는 곳이 Deque에서  맨 앞의 원소일때
2. 한칸씩 화살표가 이동하는 것을 Deque의 맨 뒤의 요소를 하나씩 앞으로 옮겨주는 것으로 생각할 수 있다.
*/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.StringTokenizer;
import java.io.IOException;


public class bj2840 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st1,st2;

        ArrayDeque<Character> deque = new ArrayDeque<Character>();
        ArrayDeque<Character> deque_clone;
        st1 = new StringTokenizer(br.readLine() +" ");

        int N = Integer.parseInt(st1.nextToken()); //바퀴의 칸수
        int K = Integer.parseInt(st1.nextToken()); //돌리는 횟수

        boolean isTrue = true; //행운 바퀴가 존재하는지 여부를 판단한다.
        for(int i=0;i<N;i++){ //deque를 ?를 가지는 큐로 초기화
            deque.offer('?');
        }

        int S =0;
        char C ='A';
        for(int i=0;i<K;i++){ //돌리는 횟수만큼 반복
            st2 = new StringTokenizer(br.readLine()," ");
            S = Integer.parseInt(st2.nextToken()); //바뀐 횟수
            C = st2.nextToken().charAt(0); //화살표가 가리키는 글자
            for(int j=0;j<S;j++){ //바뀐횟수만큼 맨앞의 요소를 맨뒤로 보내는 것으로 돌림판의 동작을 구현
                deque.offerFirst(deque.pollLast());
            }
            if((deque.peekFirst()!='?') && (deque.peekFirst()!= C)){
                //만약 돌리는 중에 도착한 칸이 기존의 값과 다르고 ?도 아니라면 바퀴가 존재하지 않는 경우이다.
                isTrue = false;
                break;
            }
            deque.pollFirst(); //화살표가 가리키는 위치를 제거하고 전달받은 문자C를 저장한다.
            deque.offerFirst(C);
        }
        br.close();

        deque_clone = deque.clone(); // deque에 물음표를 제외한 중복요소가 있는지 검사하기 위해 복제본을 만든다.
        for(int i =0;i<N;i++){ // 최종 배열의 물음표를 제거해버린 deque_clone을 만든다.
            Character Q = deque_clone.poll(); //첫번째 요소를 빼서 검사한다.
            if(Q == '?'){
                continue; //요소가 물음표라면 빠진상태 그대로 다음 요소를 검사하러 간다.
            } else{
                deque_clone.offerLast(Q); //물음표가 아닌 문자라면 다시 맨뒤로 돌려놓는다.
            }

        }

        if(deque_clone.size() != deque_clone.stream().distinct().count()){
            //stream().distinct()는 Stream의 중복을 제거 하고 count를 통해서 중복이 제거된 Stream의 사이즈를 리턴한다.
            //만약 이것이 중복제거 이전의 stream의 크기와 다르다면 중복이 있고 그것이 제거되었다는 뜻이다.
            //같은 문자는 물음표를 제외하고 바퀴에 존재할수 없기 때문에 이 경우는 존재하지 않는 바퀴이므로 느낌표출력을 위한 분기로 이동해야함
            isTrue = false;
        }




        if(isTrue == false){ // 만약 존재하지 않는 바퀴라면 느낌표를 출력한다.
            bw.write('!');
            bw.flush();
            bw.close();
        } else{
            for(int i=0;i<N;i++){
                bw.write(deque.pollFirst());
            }
            bw.flush();
            bw.close();
        }
    }
}
