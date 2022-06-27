import java.io.*;
import java.util.StringTokenizer;

public class bj10952 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while(true){
            st = new StringTokenizer(br.readLine()+" ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(a==0 && b==0){
                break;
            } else {
                sb.append(a+b+"\n");
            }
        }
        System.out.print(sb);
    }
}
