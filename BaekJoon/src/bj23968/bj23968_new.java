package bj23968;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class bj23968_new {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BubbleSort2 bSort = new BubbleSort2();

        StringTokenizer st =new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken()); //크기
        int k = Integer.parseInt(st.nextToken()); //k번째 교환되는 경우
        int[] arr = new int[n];

        StringTokenizer st2 =new StringTokenizer(br.readLine()," ");
        for(int i=0;i<n;i++){
            arr[i] = (Integer.parseInt(st2.nextToken())); //입력받은 배열을 arr에 저장
        }
        bSort.sort(arr,n,k); // 버블 정렬을 시행
        if(bSort.swap2 == false){ //교환횟수가 k보다 작았다면 -1을 출력 그렇지 않다면 두 개의 수를 출력
            System.out.print("-1");
        } else{
            System.out.print(bSort.a+" "+bSort.b);
        }

    }
}
class BubbleSort2{
    int a=0,b=0;
    boolean swap2=false;
    public void sort(int[] arr1,int size,int k){
        int n=0;
        for(int idx=0;idx<size-1;idx++){
            boolean swaped= false;
            for(int idx2=0;idx2<size-1-idx;idx2++){
                if(arr1[idx2]>arr1[idx2+1]){
                    int temp = arr1[idx2];
                    arr1[idx2] = arr1[idx2+1];
                    arr1[idx2+1] = temp;
                    swaped = true;
                    n++;
                }
                if(n==k){ // 매 교환 작업마다 교환카운트n이 k와 동일한지 확인하고 같다면 조건문으로 들어와서 a,b에 저장하고
                    a=arr1[idx2]; //다음 작업에서 교환이 발생하지 않아서 n이 k와 한번더 동일하고 idx2값이 달라지는 일을 방지하고자
                    b=arr1[idx2+1]; //한번 이 조건문에 들어와서 swap2를 참으로 조정한 이후에는 다시 들어오지 않도록 n을 1증가 시킨다.
                    swap2 =true;
                    n++;
                }
            }
            if(swaped ==false){
                break;
            }
        }
    }
}

