import java.io.*;
import java.util.StringTokenizer;

public class bj10871 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine()+" ");

        int n=Integer.parseInt(st1.nextToken());
        int x=Integer.parseInt(st1.nextToken());
        StringTokenizer st2 = new StringTokenizer(br.readLine()+" ");
        br.close();

        StringBuilder sb = new StringBuilder();

        for(int i=0;i<n;i++){
            int a= Integer.parseInt(st2.nextToken());
            if(a<x){
                sb.append(a+" ");
            } else{
                continue;
            }
        }
        System.out.print(sb);
    }
}
