package bj9184;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class bj9184 {
    static int[][][] arr = new int[21][21][21]; //a,b,c의 인덱스는 0~20까지면 충분하다.

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while(true){
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(a==-1 && b==-1 && c==-1){
                break; //종료조건
            }
            sb.append("w("+a+", "+b+", "+c+") = ").append(w(a,b,c)).append("\n");

        }
        System.out.println(sb);
    }
    static int w(int a,int b,int c){
        //만약 0~20 사이이고 배열에 저장된 값을 조회한다면 아래의 조건문을 거치지 않고 바로 값을 반환해줄 수 있다.
        if(under20(a,b,c)&&over0(a,b,c)&&arr[a][b][c] != 0){
            return arr[a][b][c];
        }
        //주어진 재귀함수는 그대로 사용하되 시행할때마다 사용한 값을 배열에 저장하는 것으로 메모이제이션을 구현한다.
        //공간복잡도를 희생하고 시행히 늘어날수록 시간복잡도에서 우세하다.
        if(a<=0 || b<=0 || c<= 0) {
            return 1;
        }
        if(a>20 || b>20 || c>20){
            return arr[20][20][20] = w(20,20,20);
        }
        if(a<b && b<c){
            return arr[a][b][c] = w(a,b,c-1) + w(a,b-1,c-1) - w(a,b-1,c);
        }

        return arr[a][b][c] = w(a-1,b,c) + w(a-1,b-1,c) + w(a-1,b,c-1)-w(a-1,b-1,c-1);

    }
    static boolean under20(int a,int b,int c){
        if(a<=20 && b<=20 && c<=20){
            return true;
        } else {
            return false;
        }
    }
    static boolean over0(int a,int b,int c){
        if(a>=0 && b>=0 && c>= 0){
            return true;
        } else{
            return false;
        }
    }
}
