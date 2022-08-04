import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
import java.io.IOException;

public class bj1406_queue {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        Deque<Character> queue_left = new LinkedList<>();
        Deque<Character> queue_right = new LinkedList<>();

        String input = br.readLine(); //문자열 입력
        int M = Integer.parseInt(br.readLine()); //명령 횟수

        for(int i=0;i<input.length();i++){ //문자열을 char단위로 쪼개서 왼쪽 큐에 저장
            queue_left.addLast(input.charAt(i));
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            char c = st.nextToken().charAt(0);//명령어를 c에 저장


            switch (c){
                case 'L':
                    if(!queue_left.isEmpty()){
                        queue_right.addFirst(queue_left.pollLast());
                    }
                    break;
                case 'D' :
                    if(!queue_right.isEmpty()){
                        queue_left.addLast(queue_right.pollFirst());
                    }
                    break;
                case 'B' :
                    if(!queue_left.isEmpty()){
                        queue_left.pollLast();
                    }
                    break;
                case 'P' :
                    queue_left.addLast(st.nextToken().charAt(0));
                    break;
                default :
                    break;
            }
        }
        br.close();
        while(!queue_left.isEmpty()){
            bw.write(queue_left.pollFirst());
        }
        while(!queue_right.isEmpty()){
            bw.write(queue_right.pollFirst());
        }
        bw.flush();
        bw.close();
    }
}

