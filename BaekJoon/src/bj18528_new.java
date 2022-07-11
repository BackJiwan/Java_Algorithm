import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class bj18528_new {
    public static void main(String[] args) throws IOException{
        LinkedList<Integer> list = new LinkedList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        while(n-- > 0){
            st = new StringTokenizer(br.readLine()," ");
            switch (st.nextToken()){
                case "push" :
                    list.offer(Integer.parseInt(st.nextToken()));
                    break;
                case "pop" :
                    Integer num = list.poll();
                    if(num == null){
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(num).append("\n");
                    }
                    break;
                case "size" :
                    sb.append(list.size()).append("\n");
                    break;
                case "empty" :
                    if(list.isEmpty()){
                        sb.append(1).append("\n");
                    } else {
                        sb.append(0).append("\n");
                    }
                    break;
                case "front" :
                    Integer num1 = list.peekFirst();
                    if(num1 == null){
                        sb.append(-1).append("\n");
                    } else{
                        sb.append(num1).append("\n");
                    }
                    break;
                case "back" :
                    Integer num2 = list.peekLast();
                    if(num2 ==null){
                        sb.append(-1).append("\n");
                    } else{
                        sb.append(num2).append("\n");
                    }
                    break;
            }
        }
        br.close();
        System.out.println(sb);
        System.out.println(sb);
    }
}
