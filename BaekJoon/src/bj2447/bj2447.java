package bj2447;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class bj2447 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String[][] arr = new String[n][n]; //2차원 배열 선언

        for(int i=0; i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                arr[i][j] = " "; //2차원 배열 내부를 공백으로 초기화
            }
        }

        star(arr,0,0,n);

        for(String[] string1 : arr){
            for(String string2 : string1){
                bw.write(string2);
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }

    public static void star(String[][] arr,int x,int y,int n){
        if(n==1){
            arr[x][y] = "*";
            return;
        }
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(!(i==1 && j ==1)){ //i와 j 가 둘다 중간에 위치하는 부분은 별로 채우지 않고 공백으로 남겨둔다.
                    star(arr,x+i*(n/3),y+j*(n/3),n/3);
                }
            }
        }
    }
}
/*
* 만약 n=9로 입력되었을 경우
* 1. star(arr,0,0,9)을 적재(1칸)한다. 반복문 두개를 지나면서 (i,j) = (0,0)이 된다
* 2. 첫번째로 star 재귀함수 호출부분을 통해서 star(arr,0,0,3)을 호출한다. 다른 작업을 중지한채 최초함수위에 star(arr,0,0,3)를 적재(2칸)한다.
* 3. star(arr,0,0,3)를 실행하면 다시 두개의 중첩 반복문 내부로 들어가면서 (i,j)=(0,0)이 되고
* 4. star(arr,0,0,1)을 호출한다. 다음작업을 중지한채로 그 위에 star(arr,0,0,1)를 적재(3칸)한다.
* 5. star(arr,0,0,1)을 실행하면 조건문에 걸려서 (0,0)좌표에 별을 찍고 return 으로 메서드를 종료한다.(3칸 삭제)
* 6. 5번 메서드를 종료하였다면 3번메서드로(2칸) 돌아와서 내부 반복문의 j++를 통해서 (0,1)이 되며 다시
* 7. star(arr,0,1,3/3)을 실행한다. 그러면 (0,1)에 별이 찍히고 이러한 로직이 n=3인동안 반복적으로 실행된다.
* 8. (0,1)~(2,2)까지 별을 모두 찍고 리턴하면 가장 작은 3*3 단위 패턴이 완성되고 n=3인 재귀함수들은 모두 리턴된 상태이다.
* 8-1. 여기까지가 n=9이고 (0,0)=(x,y)의 내부에서 벌어진일이다.
* 9. 스택 1칸에 중지되어 있던 star(arr,0,0,9)의 남은 부분을 실행하기 시작하면 내부 반복문을 한번 나와서 j++를 수행하고(j=1)(n=9)
* 10. star(arr,0,3,9)(i=0,j=1이고 n=9이므로)을 적재(1칸) 하고, 내부에서 재귀함수호출로 star(arr,0,3,3)을 적재(2칸)한다.
* 11. star(0,3,3)을 실행하면 중첩 반복문 내부로 들어가면서 (i,j)=(0,0)이 되고
* 12. star(0,3,1)을 호출한다. 다음 작업을 중지한채로 그 위에 star(0,3,1)을 적재 (3칸)한다.
* 13. star(0,3,1)을 실행하면 조건문에 걸려서 (0,3)좌표에 별을 찍게 되고 return으로 메서드를 종료한다. (3칸삭제)
* 14. 13번 메서드를 종료하였다면 11번메서드(2번째칸)로 돌아와서 내부반복문의 j++를 통해서 (0,4)가 되며 다시
* 15. star(0,4,3/3)을 실행한다. 그러면 (0,4)에 별이 찍히고 이러한 로직이 n=3인 동안 반복적으로 실행된다.
* 16. (0,3~5),{1,3~5(4=x)},(2,3~5)까지의 별을 모두 찍고 리턴하면 맨처음에 찍은 가장작은 3*3패턴의 오른쪽에 동일한 패턴이 찍히게 된다.
* 16-1 여기까지가 n=9이고 (0,1)=(x,y)의 내부에서 벌어진일이다.
* 16-2 동일하게 (0,2)=(x,y)를 통해서 오른쪽에 한번더 패턴을 찍어주고 이후 한칸 아래로 내려가서 동일한 작업을 반복한다.
* 17. 채워지는 순서는 가장 윗줄부터 끝까지 오른쪽으로 채우고 한칸내려와서 오른쪽으로 끝까지 채우기를 반복하는 방식이다.
* */