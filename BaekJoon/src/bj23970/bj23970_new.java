package bj23970;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.io.IOException;

public class bj23970_new {
    public static void main(String[] args) throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st1,st2;
        int n = Integer.parseInt(br.readLine()); //배열의 크기

        st1 = new StringTokenizer(br.readLine()," "); // 배열1
        st2 = new StringTokenizer(br.readLine()," "); // 배열2
        br.close();
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        for(int i=0;i<n;i++){ //배열1과 배열2를 채워준다.
            arr1[i] = Integer.parseInt(st1.nextToken());
            arr2[i] = Integer.parseInt(st2.nextToken());
        }



        BubbleSort bSort = new BubbleSort();
        bSort.sort(arr1,arr2,n); //배열1을 버블 정렬 해준다.

        if(bSort.check){ //만약 체크결과 true였던적이 있다면 1을 출력하고 아니면 0을 출력한다.
            System.out.print(1);
        } else{
            System.out.print(0);
        }

    }
}

class BubbleSort{
    Check c = new Check();
    boolean check = false; //정렬도중 배열2와 같은 배열이 되는 경우가 있는지를 판별한다.
    public void sort(int[] arr1,int[] arr2,int size){
        if(c.check(arr1,arr2,size)){ //시작하는 배열부터 동일한지 확인해준다.
            check = true;
            return;
        }
        for(int idx=0;idx<size-1;idx++){
            boolean swaped= false;
            for(int idx2=0;idx2<size-1-idx;idx2++){
                if(arr1[idx2]>arr1[idx2+1]){
                    int temp = arr1[idx2];
                    arr1[idx2] = arr1[idx2+1];
                    arr1[idx2+1] = temp;
                    swaped = true;
                    if(c.check(arr1,arr2,size)){ //매 swap 동작때마다 배열2와 동일한배열인지 확인해준다.
                        check = true;
                        return;
                    }
                }
            }
            if(swaped ==false){
                break;
            }
        }
    }
}
class Check{
    Check_idx ci = new Check_idx();
    public boolean check(int[] arr1,int[]arr2,int size){
        for(int i=ci.idx;i<size;i++){
            if(arr1[i] != arr2[i]){
                return false; //한번이라도 요소가 다르면 바로 빠져나온다.
            }
        }
        return true; //다른적이 없다면 같은 배열이다.
    }
}
class Check_idx{
    int idx=0;
    public int check_idx(int[] arr1,int[]arr2,int size){
        for(int i=0;i<size;i++){
            if(arr1[i] == arr2[i]){
                idx++;
            } else{
                break;
            }
        }
        return idx;
    }
}