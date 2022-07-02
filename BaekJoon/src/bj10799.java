import java.util.Stack;
import java.io.*;

public class bj10799 {
    public static void main(String[] args) throws IOException{
        Stack<Character> stack = new Stack<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine(); // 입력 한 줄을 String에 저장
        int cnt=0;
        for(int i=0;i<str.length();i++){
            char c = (str.charAt(i)); // 입력을 한 문자씩 가져오기
            if(c == '('){ //왼쪽 괄호는 스택에 저장한다.
                stack.push(c);
            }else { //  오른쪽 괄호인 경우
                if(stack.peek() == '('){ // 바로앞 문자가 왼쪽괄호이면 레이저
                    stack.pop(); //레이저를 제거
                    if(str.charAt(i-1)=='(') // 레이저 앞 요소가 왼쪽괄호이면 여러개의 쇠막대기를 자른다.
                    {
                        cnt += stack.size(); //레이져의 왼쪽 모든 조각숫자를 더한다.
                    } else if(str.charAt(i-1)==')'){ // 레이저 앞 요소가 오른쪽 괄호
                        cnt += 1; //하나의 쇠막대가 끝나는 시점이므로 잘린 오른쪽 조각 하나를 추가한다.
                    }
                }
            }
        }
        System.out.print(cnt);
    }
}
