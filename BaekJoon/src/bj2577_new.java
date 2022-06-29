import java.io.*;

public class bj2577_new {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int val = ((Integer.parseInt(br.readLine()))*(Integer.parseInt(br.readLine()))*(Integer.parseInt(br.readLine())));
        int[] arr= new int[10];
        String str = String.valueOf(val);

        for(int i=0;i<str.length();i++){
            arr[(str.charAt(i)-48)]++;
        }
        for(int j:arr)
            System.out.println(j);
    }
}
