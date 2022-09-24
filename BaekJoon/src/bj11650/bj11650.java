package bj11650;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.Comparator;

public class bj11650 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][2]; //2차원배열 선언

        StringTokenizer st;
        for(int i = 0;i<n;i++){ //좌표 입력받기
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        br.close();

        Arrays.sort(arr, new Comparator<int[]>() { //타입은 int[] 배열로 지정
            @Override
            public int compare(int[] a, int[] b) { //compare메소드 override 해주기
                if(a[0] == b[0]) { // 만약 x 좌표가 같다면 y좌표 끼리 비교한다.
                    return a[1] - b[1];
                }
                else {
                    return a[0] - b[0];
                }
            }
        });

        for(int i =0;i<n;i++){
            bw.write(Integer.toString(arr[i][0])+" "+Integer.toString(arr[i][1])+"\n");
        }
        bw.close();
    }
}
