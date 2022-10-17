package bj11047;

/*
* 1.필요한 동전의 개수의 최솟값 = 비싼 동전을 많이 사용해야함
* 2.동전은 쪼개어질 수 없다.
* 3.입력 받은 금액을 남은금액 변수에 초기화(remain)
* 4.remain 금액보다 같거나 작은 동전을 찾을때까지 반복문
* 5.찾게 되면 해당 금액의 인덱스를 기억하고 한번빼면서 사용한 동전 인덱스의 개수를 +1한다.
* 6.4번을 다시 돌린다.
* 7.종료조건은 남은금액 remain이 ==0 이되면 종료
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;


public class bj11047 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Integer[] arr = new Integer[n];
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        br.close();

        int remain = k; //남은 금액의 초기값은 K
        int count = 0; //사용된 동전을 카운트
        int current = n-1; //현재 동전의 위치를 가장 비싼 동전 위치로 올려놓기 = 입력이 오름차순이므로

        while(remain != 0){ //remain이 0이 될때까지 반복
            if(arr[current]>remain){ //만약 남은 금액이 현재 동전의 위치보다 크다면
                while(arr[current] > remain){ //남은 금액보다 작은 동전을 고를때까지 current를 내리기
                    current -= 1;
                }
            } //탈출할 경우 current는 remain보다 작은 동전을 가리키고 있다.
            remain -= arr[current]; //remain에서 current 동전값을 제거한다.
            count++; //사용된 동전 카운트
        }
        System.out.println(count);
    }
}
