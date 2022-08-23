/*
1.피보나치 수
2.0번째 =0, 1번째 =1 2부터는 바로 앞 두 피보나치 수의 합이된다.
3.n이 주어졌을때n번째 피보나치 수를 구하는 프로그램 작성하기
* */
package bj10870;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


public class bj10870 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        br.close();
        System.out.println(fibonacci(n));
    }
    public static int fibonacci(int n){
        if(n==0){
            return 0;
        } else if(n==1){
            return 1;
        } else{
            return fibonacci(n-1)+fibonacci(n-2);
        }
    }
}
