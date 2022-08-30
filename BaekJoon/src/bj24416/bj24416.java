package bj24416;
//동적 프로그래밍을 이용해서 피보나치수열을 구현하기
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class bj24416 {
    static int cnt1=0;
    static int cnt2=0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        recursive(n);
        dynamic(n);

        System.out.println(cnt1+" "+cnt2);
    }
    public static int recursive(int data){
        if(data <= 2){
            cnt1++;
            return 1;
        } else{
            return recursive(data-1)+recursive(data-2);
        }
    }
    public static int dynamic(int data){
        Integer[] cache = new Integer[data];
        cache[0] = 0;
        cache[1] = 1;

        for(int idx =2;idx<data;idx++){
            cnt2++;
            cache[idx] = cache[idx-1] + cache[idx-2];
        }
        return cache[data-1];
    }
}
