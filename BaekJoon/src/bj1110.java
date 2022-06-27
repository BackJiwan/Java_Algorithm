import java.io.*;

public class bj1110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str =br.readLine(); //두자리인지 한자리인지 구분하기 위해서 String에 저장

        int a,b;
        int a2,b2;

        if (str.length() == 2) {
            a = Integer.parseInt(str.substring(0,1));
            b = Integer.parseInt(str.substring(1,2));
        } else{
            a = 0;
            b = Integer.parseInt(str.substring(0,1));
        } //첫 숫자가 a,b로 나뉘어 들어왔다.
        a2 = a;
        b2 = b;
        int k;
        int n=100;
        int cnt=0;
        while(n != (a*10)+(b)){
            k = (a2+b2)%10;
            n = (b2*10)+k;
            a2 = n/10;
            b2 = n%10;
            cnt++;
        }
        System.out.print(cnt);
    }
}
