package bj2751;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj2751_new {
    static int n;
    static int[] sorted;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        sort(arr,0,n-1);
        for(int i=0;i<n;i++){
            System.out.println(arr[i]);
        }

    }
    static void sort(int arr[],int left,int right){
        if(left<right){
            int medium = (left+right) / 2;
            sort(arr,left,medium);
            sort(arr,medium+1,right);
            merge(arr,left,medium,right);
        }
    }
    static void merge(int arr[],int left,int medium,int right){
        int l = left; //왼쪽 리스트의 시작
        int r = medium+1; //오른쪽 리스트의 시작
        int idx = left; // 정렬된 배열의 채워넣어지는 위치 인덱스
        sorted = new int[n];
        while(l<=medium && r<=right){ //왼쪽 또는 오른쪽 리스트를 순차접근하면서 작은값을 sorted에 대입후 포인터이동
            if(arr[l] <= arr[r]){
                sorted[idx] = arr[l];
                l++;
            } else{
                sorted[idx] = arr[r];
                r++;
            } //대입 작업이 둘중 하나라도 발생하였으면 sorted의 대입하는 idx포인터 1증가
            idx++;
        }
        if(l > medium){ //오른쪽 리스트가 남아있는 경우 = 왼쪽에서 뽑은 횟수가 중간값을 넘긴다.
            for(int i=r;i<=n;i++){
                sorted[idx] = arr[i];
                idx++;
            }
        } else{
            for(int i=l;i<=medium;i++){
                sorted[idx] = arr[i];
                idx++;
            }
        }
        for(int i=left;i<=right;i++){
            arr[i] = sorted[i];
        }
    }
}
