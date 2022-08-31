package bj9461;
/*
* 1 ,1, 1, 2, 2, 3, 4, 5, 7, 9
* */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class bj9461 {
    static int[] arr2 = new int[101];
    static int cnt=4;
    static int cnt_temp=0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int test = Integer.parseInt(br.readLine());
        int[] arr1 = new int[test];
        arr2[1] = 1;
        arr2[2] = 1;
        arr2[3] = 1;
        for(int i=0;i<test;i++){
            int n = Integer.parseInt(br.readLine());
            bw.write(padoBan(n)+"\n");
        }
        br.close();

//        //규칙을 파악해보면 n>=4 일때 arr2[n] = arr2[n-2] + arr2[n-3]

        bw.flush();
        bw.close();
    }
    public static int padoBan(int n){
        if(n<4){
            return arr2[n];
        }else{
            if(maxCnt(n)){
                for(int i=cnt_temp;i<cnt+1;i++){
                    arr2[i] = arr2[i-2]+arr2[i-3];
                }
                return arr2[cnt];
            } else{
                return arr2[cnt];
            }
        }
    }
    public static boolean maxCnt(int n){
        if(cnt <= n){
            cnt_temp = cnt;
            cnt = n;
            return true;
        }
        return false;
    }
}
