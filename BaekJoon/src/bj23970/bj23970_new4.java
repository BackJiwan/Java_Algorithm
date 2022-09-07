package bj23970;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;
import java.util.Arrays;

public class bj23970_new4 {
    static int checked_idx;
    public static void check_idx(int[] arr1,int[] arr2,int size,int check){
        checked_idx=check;
        for(int i=check;i<size;i++){
            if(arr1[i] == arr2[i]){
                checked_idx++;
            }  else{
                break;
            }
        }
    }

    public static boolean Check(int[] arr1,int[] arr2,int size){
        for(int i=checked_idx;i<size;i++){
            if(arr1[i] != arr2[i]){
                return false; //한번이라도 요소가 다르면 바로 빠져나온다.
            } else{
                continue;
            }
        }
        return true; //다른적이 없다면 같은 배열이다.
    }
    public static boolean bsort(int[] arr1,int[] arr2,int size){
        if(Arrays.equals(arr1,arr2)){ //sort이전에 두 배열이 완벽히 동일한 배열인치 확인한다.
            return true;
        }
        int[] arr3 = arr1.clone();
        int[] arr4 = arr2.clone();
        Arrays.sort(arr3);
        Arrays.sort(arr4);
        if(!Arrays.equals(arr3,arr4)){ //혹시 두 배열의 구성하는 요소가 아예 다르다면 판별해볼 필요도 없다.
            return false;
        }

        for(int idx=0;idx<size-1;idx++){
            boolean swaped= false;
            for(int idx2=0;idx2<size-1-idx;idx2++){
                if(arr1[idx2]>arr1[idx2+1]){
                    check_idx(arr1,arr2,size,checked_idx); //앞부분부터 겹치는 요소를 무시하기 위해서 swap마다 실행
                    int same_idx = checked_idx; //겹치는 요소까지의 인덱스
                    int temp = arr1[idx2];
                    arr1[idx2] = arr1[idx2+1];
                    arr1[idx2+1] = temp; // swap 과정
                    swaped = true;
                    if(same_idx>idx2){ //겹치는 요소의 인덱스가 만약 교체에 가담하는 idx2라면 그 다음과정에서 배열이 어긋나기 때문에
                        //즉, 앞부분부터 겹치는 요소중 마지막 요소가 결국 다음 회차에서 swap되면 동일한 배열이 될수없어진다.
                        return false;
                    }
                    if(Check(arr1,arr2,size)){ //매 swap 동작때마다 배열2와 동일한배열인지 확인해준다.
                        return true;
                    }
                }
            }
            if(swaped ==false){
                break;
            }
        }
        return false;
    }


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
        check_idx(arr1,arr2,n,0); // 배열1과 2의 앞부분 부터 연속적으로 겹치는 요소가 있다면 인덱스를 저장한다.

        if(!(bsort(arr1,arr2,n))){ //만약 체크결과 true였던적이 있다면 1을 출력하고 아니면 0을 출력한다.
            System.out.print(0);
        } else{
            System.out.print(1);
        }

    }
}



