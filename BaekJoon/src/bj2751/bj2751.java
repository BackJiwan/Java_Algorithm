package bj2751;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public class bj2751 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        ArrayList<Integer> list = new ArrayList<Integer>();

        for(int i = 0; i < n; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }
        br.close();

        MergeSort mSort = new MergeSort();
        mSort.mergeSplitFunc(list);
        int s = list.size();
        for(int i=s-1;i>=0;i--) {
            sb.append(list.get(i)).append('\n');
        }
        System.out.println(sb);
    }

}
class MergeSort {
    public ArrayList<Integer> mergeFunc(ArrayList<Integer> leftList, ArrayList<Integer> rightList) {
        ArrayList<Integer> mergedList = new ArrayList<Integer>();
        Integer leftPoint = 0;
        Integer rightPoint = 0;

        // case1 - left/right 둘다 있을때
        while (leftList.size() > leftPoint && rightList.size() > rightPoint) {
            if (leftList.get(leftPoint) > rightList.get(rightPoint)) {
                mergedList.add(rightList.get(rightPoint));
                rightPoint += 1;
            } else {
                mergedList.add(leftList.get(leftPoint));
                leftPoint += 1;
            }
        }

        // case2 - right 데이터가 없을 때
        while (leftList.size() > leftPoint) {
            mergedList.add(leftList.get(leftPoint));
            leftPoint += 1;
        }

        // case3 - left 데이터가 없을 때
        while (rightList.size() > rightPoint) {
            mergedList.add(rightList.get(rightPoint));
            rightPoint += 1;
        }

        return mergedList;
    }

    public ArrayList<Integer> mergeSplitFunc(ArrayList<Integer> dataList) {
        if (dataList.size() <= 1) {
            return dataList;
        }
        int medium = dataList.size() / 2;

        ArrayList<Integer> leftArr = this.mergeSplitFunc(new ArrayList<Integer>(dataList.subList(0, medium)));
        ArrayList<Integer> rightArr = this.mergeSplitFunc(new ArrayList<Integer>(dataList.subList(medium, dataList.size())));

        return this.mergeFunc(leftArr, rightArr);
    }
}