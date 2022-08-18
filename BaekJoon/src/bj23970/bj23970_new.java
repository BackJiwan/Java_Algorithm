package bj23970;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class bj23970_new {
    public static void main(String[] args) throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
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



        BubbleSort bSort = new BubbleSort(arr1,arr2,n);
        Check ch = new Check(arr1,arr2,n);
        Check_idx ci = new Check_idx(arr1,arr2,n);

        bSort.sort(arr1,arr2,n); //배열1을 버블 정렬 해준다.


        if(bSort.checked){ //만약 체크결과 true였던적이 있다면 1을 출력하고 아니면 0을 출력한다.
            System.out.print(1);
        } else{
            System.out.print(0);
        }

    }
}

class BubbleSort{
    int[] arr1;
    int[] arr2;
    int size;
    BubbleSort(int[] arr1,int[]arr2,int size){
        this.arr1 = arr1;
        this.arr2 = arr2;
        this.size = size;
    }
    Check c = new Check(arr1,arr2,size);
    boolean checked = false; //정렬도중 배열2와 같은 배열이 되는 경우가 있는지를 판별한다.
    public void sort(int[] arr1,int[] arr2,int size){
        if(c.check(arr1,arr2,size)){ //시작하는 배열부터 동일한지 확인해준다.
            checked = true;
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
                        checked = true;
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
    int[] arr1;
    int[] arr2;
    int size;
    Check(int[] arr1,int[]arr2,int size){
        this.arr1 = arr1;
        this.arr2 = arr2;
        this.size = size;
    }
    Check_idx ci = new Check_idx(arr1,arr2,size);
    public boolean check(int[] arr1,int[]arr2,int size){
        for(int i=ci.idx;i<size-ci.idx2;i++){
            if(arr1[i] != arr2[i]){
                return false; //한번이라도 요소가 다르면 바로 빠져나온다.
            }
        }
        return true; //다른적이 없다면 같은 배열이다.
    }
}
class Check_idx{
    int[] arr1;
    int[] arr2;
    int size;
    Check_idx(int[] arr1,int[]arr2,int size){
        this.arr1 = arr1;
        this.arr2 = arr2;
        this.size = size;
    }
    int idx=0;
    int idx2=0;
    public void check_idx(int[] arr1,int[]arr2,int size){
        for(int i=0;i<size;i++){
            if(arr1[i] == arr2[i]){
                idx++;
            } if(arr1[size-1-i] == arr1[size-1-i]){
                idx2++;
            } else{
                break;
            }
        }
    }
}