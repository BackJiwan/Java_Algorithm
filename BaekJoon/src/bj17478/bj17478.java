package bj17478;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


public class bj17478 {
    static StringBuilder sb = new StringBuilder();
    static String under = "";
    public static void chatBot(int n){
        String bar = under;
        if(n==0){
            sb.append(bar+"\"재귀함수가 뭔가요?\"\n");
            sb.append(bar+"\"재귀함수는 자기 자신을 호출하는 함수라네\"\n");
            sb.append(bar+"라고 답변하였지.\n");
            return;
        }
        sb.append(bar+"\"재귀함수가 뭔가요?\"\n");
        sb.append(bar+"\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n");
        sb.append(bar+"마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n");
        sb.append(bar+"그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n");

        under += "____"; //재귀적으로 옛날얘기부분을 출력한 이후에 언더바가 변수 under에 추가된다.
        chatBot(n-1);
        sb.append(bar+"라고 답변하였지.\n"); //언더바가 추가되기 이전의 언더바 정보는 bar변수에 있으므로 bar변수와 under 변수를 별개로 관리한다.
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        sb.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n");
        chatBot(n);
        System.out.print(sb);
    }
}
