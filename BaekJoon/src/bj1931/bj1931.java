package bj1931;
/*
* 1.회의실은 단 한개!
* 2.N개의 회의가 이걸 쓰고자한다.
* 3.각 회의 개체는 시작시간과 끝나는시간을 가진다. -(2차원 배열?)
* 4.겹치지 않게 회의실을 사용할 수 있는 회의의 최대 개수 찾기 - (그리디)
* 5.첫째줄에 회의의 수 N 입력받기
* 6.N번 만큼 들어오는 회의의 정보를 br.readLine으로 읽고 StringTokenizer에 저장
* 7.시간 간격이 가장 긴것들 순으로 sort 한다.
* */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.Comparator;


public class bj1931 {
    public static void main(String[] args) throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine()); //회의의 개수
        int[][] list = new int[N][2]; //회의 정보를 담는 2차원 배열

        for(int i=0;i<N;i++){ //
            st = new StringTokenizer(br.readLine()," ");
            list[i][0] = Integer.parseInt(st.nextToken());//시작시간
            list[i][1] = Integer.parseInt(st.nextToken());//끝나는시간
        }

        Arrays.sort(list,new Comparator<int[]>(){
            @Override
            public int compare(int[] a,int[] b){ //끝나는 시간이 가장 이른 회의를 앞으로 정렬한다.
                if(a[1] == b[1]){
                    return a[0] - b[0]; //만약 종료시점이 같다면 더 일찍 시작하는 회의가 앞으로 정렬된다. (더 긴 회의)
                }
                return a[1]-b[1];
            }
        });

        int count=0; //열린 회의의 카운트
        int prev=0; //가장 최근에 종료된 회의의 종료시간을 저장

        for(int i=0;i<N;i++){
            if(prev <= list[i][0]){ //직전회의의 종료 시간보다 다음 회의의 시작 시간이 같거나 크다면 회의를 열 수 있다.
                prev = list[i][1];
                count++;
            }
        }
        System.out.println(count);
    }
}
