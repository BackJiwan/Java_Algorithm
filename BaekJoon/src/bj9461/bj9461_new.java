package bj9461;
/*
 * 1 ,1, 1, 2, 2, 3, 4, 5, 7, 9
 * 규칙을 파악해보면 n>=4 일때 arr2[n] = arr2[n-2] + arr2[n-3]
 * */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;


public class bj9461_new {
    static long[] arr = new long[101];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int test = Integer.parseInt(br.readLine());

        for(int i=0;i<101;i++){ //배열을 -1로 초기화
            arr[i] = -1;
        }

        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 1;
        arr[3] = 1; //동적 프로그래밍에 필요한 초깃값 셋팅

        for(int i=0;i<test;i++){
            int n = Integer.parseInt(br.readLine());
            bw.write(padoVan(n)+"\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }
    public static long padoVan(int n){
        if(arr[n] == -1){ //만약 배열에 없다면 재귀 호출
            arr[n] = padoVan(n-2) + padoVan(n-3);
        }
        return arr[n];
    }
}
