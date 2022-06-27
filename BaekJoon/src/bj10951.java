import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj10951 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        String str;
        //readLine으로 null을 체크해야 하는데 이때 체크하면서 줄을 넘어가면서 유실되기 때문에
        //이것을 임시로 저장해둘 String 타입의 포인터를 선언해둔다.
        while((str=br.readLine()) != null){
            st = new StringTokenizer(str," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(a+b).append("\n");
        }
        System.out.print(sb);
    }
}
