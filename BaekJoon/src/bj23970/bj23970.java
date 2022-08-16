//package bj23970;
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//import java.io.IOException;
////는 시간초과
//
//public class bj23970 {
//    public static void main(String[] args) throws IOException{
//        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st1,st2;
//        int n = Integer.parseInt(br.readLine()); //배열의 크기
//
//        st1 = new StringTokenizer(br.readLine()," "); // 배열1
//        st2 = new StringTokenizer(br.readLine()," "); // 배열2
//        int[] arr1 = new int[n];
//        int[] arr2 = new int[n];
//        for(int i=0;i<n;i++){ //배열1과 배열2를 채워준다.
//            arr1[i] = Integer.parseInt(st1.nextToken());
//            arr2[i] = Integer.parseInt(st2.nextToken());
//        }
//
//        BubbleSort bSort = new BubbleSort();
//        bSort.sort(arr1,arr2,n); //배열1을 버블 정렬 해준다.
//
//        if(bSort.check){ //만약 체크결과 true였던적이 있다면 1을 출력하고 아니면 0을 출력한다.
//            System.out.println(1);
//        } else{
//            System.out.println(0);
//        }
//
//    }
//}
//
//class BubbleSort{
//    Check c = new Check();
//    boolean check = false; //정렬도중 배열2와 같은 배열이 되는 경우가 있는지를 판별한다.
//    public void sort(int[] arr1,int[] arr2,int size){
//        for(int idx=0;idx<size-1;idx++){
//            boolean swaped= false;
//            for(int idx2=0;idx2<size-1-idx;idx2++){
//                if(arr1[idx2]>arr1[idx2+1]){
//                    int temp = arr1[idx2];
//                    arr1[idx2] = arr1[idx2+1];
//                    arr1[idx2+1] = temp;
//                    swaped = true;
//                    if(c.check(arr1,arr2,size)){ //매 swap 동작때마다 배열2와 동일한배열인지 확인해준다.
//                        check = true;
//                    }
//                }
//            }
//            if(swaped ==false){
//                break;
//            }
//        }
//    }
//}
//class Check{
//    public boolean check(int[] arr1,int[]arr2,int size){
//        int cnt = 0;
//        for(int i=0;i<size;i++){
//            if(arr1[i] == arr2[i]){
//                cnt++; //배열의 구성요소가 같다면 1추가하는데 이것이 배열의 크기와 동일해야 같은 배열이다.
//            } else{
//                continue;
//            }
//        }
//        if(cnt == size){
//            return true;
//        } else{
//            return false;
//        }
//    }
//}