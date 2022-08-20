package bj23970;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;
import java.util.Arrays;

class Arr implements Comparable<Arr> {
    int num; // 값
    int idx; // 인덱스

    Arr(int num, int idx) {
        this.num = num;
        this.idx = idx;
    }

    @Override
    public int compareTo(Arr o) { //인덱스를 무시하고 값을 가지고만 Sort할수 있도록 Override해준다.
        return num - o.num;
    }

}

public class bj23970_new3 {
    public static int check_idx(Arr[] arr1,Arr[] arr2,int size){
        int idx=0;
        for(int i=1;i<=size;i++){
            if(arr1[i].num == arr2[i].num){
                idx++;
            }  else{
                break;
            }
        }
        return idx;
    }
    public static boolean Check(Arr[] arr1,Arr[] arr2,int size){
        int a = check_idx(arr1,arr2,size);
        for(int i=a+1;i<=size;i++){
            if(arr1[i].num != arr2[i].num){
                return false; //한번이라도 요소가 다르면 바로 빠져나온다.
            } else{
                continue;
            }
        }
        return true; //다른적이 없다면 같은 배열이다.
    }
    public static boolean bsort(Arr[] arr1,Arr[] arr2,int size,int max3,Arr[] arr3,Arr[] arr4){
        boolean checked = false; //정렬도중 배열2와 같은 배열이 되는 경우가 있는지를 판별한다.
        if(Check(arr1,arr2,size)){ //시작하는 배열부터 동일한지 확인해준다.
            checked = true;
            return true;
        }

        if(!Arrays.equals(arr3,arr4)){
            return false;
        }

        for(int idx=1;idx<=size-1;idx++){
            boolean swaped= false;
            for(int idx2=1;idx2<=size-2-idx-max3;idx2++){
                if(arr1[idx2].num>arr1[idx2+1].num){
                    int same_idx = check_idx(arr1,arr2,size);
                    int temp = arr1[idx2].num;
                    arr1[idx2].num = arr1[idx2+1].num;
                    arr1[idx2+1].num = temp;
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

        Arr[] arr1 = new Arr[n+1];
        Arr[] arr2 = new Arr[n+1];

        for(int i=1;i<=n;i++){ //배열1과 배열2를 채워준다.
            arr1[i] = new Arr(Integer.parseInt(st1.nextToken()),i);
            arr2[i] = new Arr(Integer.parseInt(st2.nextToken()),i);
        }
        Arr[] arr3 = arr1.clone(); //arr3은 arr1을 정렬한 결과를 담을 것이다.
        Arr[] arr4 = arr2.clone(); //arr4는 arr2를 정렬한 결과를 담을 것이다.
        Arrays.sort(arr3,1,n+1); //arr3을 값을 기준으로 오름차순 정렬한다.
        Arrays.sort(arr4,1,n+1); //arr4를 값을 기준으로 오름차순 정렬한다.


        int max1 = 0;
        int max2 = 0;
        for(int i=1;i<=n;i++){
            max1 = Math.max(max1,arr3[i].idx-i);
            max2 = Math.max(max2,arr4[i].idx-i);
        }
        // (max1+1) 은 arr1의 정렬과정에서 가장많이 이동한 요소의 이동횟수이다.
        // (max2+1)은 arr2의 정렬과정에거 가장 많이 이동한 요소의 이동횟수이다.
        // max1-max2를 하면 arr1이 arr2가 되기까지 필요한 단계의 횟수이다.
        int max3=max2-max1;
        //n-(n-max3)

        for(int idx=1;idx<=max3-1;idx++){
            boolean swaped= false;
            for(int idx2=1;idx2<=n-1-idx;idx2++){
                if(arr1[idx2].num>arr1[idx2+1].num){
                    int temp = arr1[idx2].num;
                    arr1[idx2].num = arr1[idx2+1].num;
                    arr1[idx2+1].num = temp;
                    swaped = true;
                }
            }
            if(swaped ==false){
                break;
            }
        }//arr1을 직전 단계까지 진행시킨다.


        if(!(bsort(arr1,arr2,n,max3,arr3,arr4))){ //만약 체크결과 true였던적이 있다면 1을 출력하고 아니면 0을 출력한다.
            System.out.print(0);
        } else{
            System.out.print(1);
        }

    }
}



