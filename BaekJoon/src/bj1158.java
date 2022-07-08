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

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();

        for(int i=1;i<=n;i++){
            list.offer(i);
        }

        while(!list.isEmpty()){
            for(int j=0;j<k;j++){
                if(j == k-1) //j가 k번째 도착했다면
                {
                    sb.append(list.poll()).append(", ");
                } else{
                    list.add(list.poll());
                }
            }
        }
        System.out.println("<"+sb.substring(0,sb.length()-2)+">");
    }
}
