import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.io.IOException;
import java.util.StringTokenizer;

public class bj1406_stack {
    public static void main(String[] args) throws IOException{
        long start = System.currentTimeMillis();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        Stack<Character> stack_left = new Stack<>();
        Stack<Character> stack_right = new Stack<>();

        String input = br.readLine(); //문자열 입력
        int M = Integer.parseInt(br.readLine()); //명령 횟수

        for(int i=0;i<input.length();i++){ //문자열을 char단위로 쪼개서 왼쪽 스택에 적재
            stack_left.push(input.charAt(i));
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            char c = st.nextToken().charAt(0);//명령어를 c에 저장

            switch (c){
                case 'L':
                    if(!stack_left.isEmpty()){
                        stack_right.push(stack_left.pop());
                    }
                    break;
                case 'D' :
                    if(!stack_right.isEmpty()){
                        stack_left.push(stack_right.pop());
                    }
                    break;
                case 'B' :
                    if(!stack_left.isEmpty()){
                        stack_left.pop();
                    }
                    break;
                case 'P' :
                    stack_left.push(st.nextToken().charAt(0));
                    break;
                default :
                    break;
            }
        }
        br.close();
        while(!stack_left.isEmpty()){
            stack_right.push(stack_left.pop());
        }
        while(!stack_right.isEmpty()){
            bw.write(stack_right.pop());
        }
        long end = System.currentTimeMillis();
        System.out.println("실행시간 : " + (end - start)/1000.0);
        bw.flush();
        bw.close();
    }
}
