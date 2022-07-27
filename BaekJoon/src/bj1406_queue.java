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

        Deque<Character> stack_left = new LinkedList<>();
        Deque<Character> stack_right = new LinkedList<>();

        String input = br.readLine(); //문자열 입력
        int M = Integer.parseInt(br.readLine()); //명령 횟수

        for(int i=0;i<input.length();i++){ //문자열을 char단위로 쪼개서 왼쪽 스택에 적재
            stack_left.addLast(input.charAt(i));
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            char c = st.nextToken().charAt(0);//명령어를 c에 저장

            switch (c){
                case 'L':
                    if(!stack_left.isEmpty()){
                        stack_right.addFirst(stack_left.pollLast());
                    }
                    break;
                case 'D' :
                    if(!stack_right.isEmpty()){
                        stack_left.addLast(stack_right.pollFirst());
                    }
                    break;
                case 'B' :
                    if(!stack_left.isEmpty()){
                        stack_left.pollLast();
                    }
                    break;
                case 'P' :
                    stack_left.addLast(st.nextToken().charAt(0));
                    break;
                default :
                    break;
            }
        }
        br.close();
        while(!stack_left.isEmpty()){
            bw.write(stack_left.pollFirst());
        }
        while(!stack_right.isEmpty()){
            bw.write(stack_right.pollFirst());
        }
        bw.flush();
        bw.close();
    }
}

