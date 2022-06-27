import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[]args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

       int a,b;
       int n = Integer.parseInt(br.readLine());

       StringTokenizer st;

       for(int i=1;i<=n;i++){
           st = new StringTokenizer(br.readLine()+" ");
           a = Integer.parseInt(st.nextToken());
           b = Integer.parseInt(st.nextToken());
           bw.write(String.format("Case #%d: %d + %d = %d\n",i,a,b,a+b));
       }
       br.close();

       bw.flush();
       bw.close();
    }
}

