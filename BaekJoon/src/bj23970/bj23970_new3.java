package bj23970;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
import java.io.IOException;
import java.util.Arrays;

public class bj23970_new3 {
    static int size;
    static ArrayList<Integer> array = new ArrayList<Integer>();
    static int cnt;
    public static int check_idx(int[] arr1,int[] arr2,int n){
        size = n;
        int idx=0;
        for(int i=0;i<size;i++){
            if(arr1[i] == arr2[i]){
                idx++;
            }  else{
                break;
            }
        }
        return idx;
    }
    public static boolean Check(int[] arr1,int[] arr2,int n){
        size = n;
        int a = check_idx(arr1,arr2,size);
        for(int i=a;i<size;i++){
            if(arr1[i] != arr2[i]){
                return false; //한번이라도 요소가 다르면 바로 빠져나온다.
            } else{
                continue;
            }
        }
        return true; //다른적이 없다면 같은 배열이다.
    }
    public static boolean bsort(int[] arr1,int[] arr2,int n){
        size = n;
        boolean checked = false; //정렬도중 배열2와 같은 배열이 되는 경우가 있는지를 판별한다.
        if(Arrays.equals(arr1,arr2)){ //배열1,2가 같은 배열인지 확인
            checked = true;
            return true;
        }
        int[] arr3 = new int[size];
        int[] arr4 = new int[size];
        arr3 = arr1.clone();
        arr4 = arr2.clone();
        Arrays.sort(arr3);
        Arrays.sort(arr4);
        if(!Arrays.equals(arr3,arr4)){
            return false;
        }
        int size2=size;
        cnt=0;
        for(int i=size2-1;i>0;i--){
            if(arr3[i]==arr2[i]){
                size--;
                array.add(arr3[i]);
                cnt++;
            } else{
                break;
            }
        }
        for(int i=0;i<size2;i++){
            for(int j=0;j<cnt;j++){
                if(arr1[i] == array.get(j)){
                    arr1[i] = 0;
                }
            }
        }
        int j=0;
        for(int i=0;i<size2;i++){
            if(arr1[i]==0){
                j=i;
                while(arr1[j]!=0){
                    j++;
                }
            }
        }


        for(int idx=0;idx<size-1;idx++){
            boolean swaped= false;
            for(int idx2=0;idx2<size-1-idx;idx2++){
                if(arr1[idx2]>arr1[idx2+1]){
                    int same_idx = check_idx(arr1,arr2,size);
                    int temp = arr1[idx2];
                    arr1[idx2] = arr1[idx2+1];
                    arr1[idx2+1] = temp;
                    swaped = true;
                    if(same_idx>idx2){
                        return false;
                    }
                    if(Check(arr1,arr2,size)){ //매 swap 동작때마다 배열2와 동일한배열인지 확인해준다.
                        checked = true;
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


        if(!(bsort(arr1,arr2,n))){ //만약 체크결과 true였던적이 있다면 1을 출력하고 아니면 0을 출력한다.
            System.out.print(0);
        } else{
            System.out.print(1);
        }

    }
}



