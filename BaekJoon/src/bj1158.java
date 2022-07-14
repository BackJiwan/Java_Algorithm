import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.LinkedList;


public class bj1158 {
    public static void main(String[] args) throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        LinkedList<Integer> list = new LinkedList<>();
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int n = Integer.parseInt(st.nextToken()); // 사람의 수
        int k = Integer.parseInt(st.nextToken()); // K번째 카운팅
        StringBuilder sb = new StringBuilder();

        for(int i=1;i<=n;i++){ //리스트를 1부터 순차적으로 초기화한다.
            list.offer(i);
        }

        while(!list.isEmpty()){ //리스트가 빌때까지 == 사람이 모두 제거될때까지
            for(int j=0;j<k;j++){ // k번쨰 사람을 카운트 하기위한 반복문
                if(j == k-1) //j가 k번째 도착했다면
                {
                    sb.append(list.poll()).append(", "); //K번쨰에 도착하면 맨 앞원소(K번째해당)를 추출하고 스트링빌더에 추가한다.
                } else{
                    list.offerLast(list.pollFirst()); // k번째 사람을 가장 앞으로 끌어오기 위한 순환동작
                }
            }
        }
        System.out.println("<"+sb.substring(0,sb.length()-2)+">"); // substring을 사용하여 불필요한 부분제거
    }
}
