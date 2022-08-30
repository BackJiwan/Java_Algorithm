package bj1904;
/*
* N=1 -> 1 = 1개
* 2 -> 11, 00 = 2개
* 3 -> 111, 100, 001 = 3개
* 4 -> 1111,0011,1001,1100,0000 = 5개
* 5 -> 11111,00111,10011,11001,11100,00001,10000,00100 = 8개
* 6 -> 111111,001111,100111,110011,111001,111100,000011,001001,001100,100001,110000,000000,100100 = 13개
* 7 -> 1111111,0011111,1001111,1100111,1110011,1111001,1111100,0000111,0010011,0011001,0011100,1000011,1001001,1001100,1100001,1100100,1110000,
*      0000001,0000100,0010000,1000000 = 21개
*  규칙을 찾아보면 N번째 시행의 개수는 (N-1) + (N-2) 번째 시행의 합이다.
* */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class bj1904 {
    public static int[] arr = new int[1000001];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 2;

        for(int i=3;i<arr.length;i++){
            arr[i] = arr[i-1]+ arr[i-2];
        }
        System.out.println(arr[n] % 15746);
    }
}
