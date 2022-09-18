package bj2751;

import java.io.*;

public class bj2751_new2 {
    static int[] sorted = new int[1000001];
    //하나의 큰 sorted 필드를 만들지 않으면 merge 작업을 할때마다
    //배열의 전체크기 또는 right 길이만큼을 메모리에 할당하고 해제하기 때문에
    //시간복잡도가 증가한다. (N크기의 메모리를 할당하는시간 * N번 merge 작업)
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        int[] arr = new int[n]; //패캠 강의처럼 ArrayList를 이용하면 왜 인지 틀린다. 그냥 배열사용

        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        sort(arr,0,n-1);
        for(int i=0;i<arr.length;i++){
            bw.write(Integer.toString(arr[i])+"\n");
        }
        bw.close();

    }
    static int[] sort(int arr[],int left,int right){
        if(arr.length == 1){ //더 이상 쪼갤 필요 없을때에 return
            return arr;
        }
        if(left<right){ //
            int medium = (left+right) / 2;
            arr = sort(arr,left,medium); //왼쪽 리스트 - 재귀
            arr = sort(arr,medium+1,right); //오른쪽 리스트 - 재귀
            arr = merge(arr,left,medium,right); // 병합 -> 각 재귀 과정에서 쪼개지는 과정이후에는 병합되어서 보귀한다.
        }
        return arr;
    }
    static int[] merge(int[] arr,int left,int medium,int right){
        int l = left; //왼쪽 리스트의 시작
        int r = medium+1; //오른쪽 리스트의 시작
        int idx = left; // 정렬된 배열의 채워넣어지는 위치 인덱스

        while(l<=medium && r<=right){ //왼쪽 또는 오른쪽 리스트를 순차접근하면서 작은값을 sorted 배얄에 대입후 포인터이동
            if(arr[l] <= arr[r]){ //오른쪽이 더 클경우
                sorted[idx++] = arr[l++]; //sorted배열에 왼쪽값 저장
            } else{ //왼쪽이 더 클경우는 오른쪽 값을 저장
                sorted[idx++] = arr[r++];
            }
        }
        if(l > medium){ //오른쪽 리스트가 남아있는 경우 = 왼쪽에서 뽑은 횟수가 중간값을 넘긴다.
            for(int i=r;i<=right;i++){
                sorted[idx++] = arr[i]; // 남아있는 오른쪽 리스트는 정렬되어 있는 상태이므로 전부 대입
            }
        } else{
            for(int i=l;i<=medium;i++){
                sorted[idx++] = arr[i]; //남아있는 왼쪽 리스트는 정렬되어 있는 상태이므로 전부 대입
            }
        }
        for(int i=left;i<=right;i++){
            arr[i] = sorted[i]; //sorted에서 길이만큼만 arr에 저장
        }
        return arr;
    }
}
