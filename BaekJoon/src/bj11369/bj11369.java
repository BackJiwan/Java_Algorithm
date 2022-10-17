package bj11369;

/*
* 1. N명의 사람이 줄 서있다.
* 2. i번 사람이 돈을 인출하는데에 걸리는 시간은 Pi분이다.
* 3. 첫째줄에 N명의 사람
* 4. 둘째줄에는 각 사람마다 걸리는 시간
* 5. 그냥 Arrays.sort로 정렬해버리고... 순회하면서 다 더해버리기..?
* */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class bj11369 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int[] timeArr = new int[N];
        for(int i=0;i<N;i++){
            timeArr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(timeArr);
        int sum=0;
        int sum2=0;
        int[] timeArr2 = new int[N];
        for(int i =0;i<N;i++){
            sum += timeArr[i];
            timeArr2[i] = sum;
        }
        for(int i =0;i<N;i++){
            sum2 += timeArr2[i];
        }
        System.out.println(sum2);
    }
}
