package bj2750;
import java.util.ArrayList;
import java.util.Collections;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class bj2750 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ArrayList<Integer> dataList = new ArrayList<Integer>();
        BubbleSort bSort = new BubbleSort();
        InsertionSort iSort = new InsertionSort();
        SelectionSort sSort = new SelectionSort();

        int n = Integer.parseInt(br.readLine());
        for(int i=0;i<n;i++){
            dataList.add(Integer.parseInt(br.readLine()));
        }
        br.close();

        ArrayList<Integer> SortedList = bSort.sort(dataList);
        for(int i=0;i<n;i++){
            bw.write(SortedList.get(i).toString());
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}

class BubbleSort{
    public ArrayList<Integer> sort(ArrayList<Integer> dataList){
        for(int idx=0;idx<dataList.size()-1;idx++){
            boolean swap=false;
            for(int idx2=0;idx2<dataList.size()-1-idx;idx2++){
                if(dataList.get(idx2)>dataList.get(idx2+1)){
                    Collections.swap(dataList,idx2,idx2+1);
                    swap = true;
                }
            }
            if(swap == false)
                break;
        }
        return dataList;
    }
}
class InsertionSort{
    public ArrayList<Integer> sort(ArrayList<Integer> dataList){
        for(int stand=0;stand<dataList.size()-1;stand++){
            for(int idx = stand+1;idx>0;idx--){
                if(dataList.get(idx)<dataList.get(idx-1)){
                    Collections.swap(dataList,idx,idx-1);
                } else{ //기준점의 앞부분은 정렬이 되어 있는 상태이기때문에 한번 막히면 더이상 진행 필요 X
                    break;
                }
            }
        }
        return dataList;
    }
}

class SelectionSort{
    public ArrayList<Integer> sort(ArrayList<Integer> dataList){
        for(int stand=0;stand<dataList.size()-1;stand++){
            int lowest = dataList.get(stand);
            int lowest_idx = stand;
            for(int idx = stand+1;idx<dataList.size();idx++){
                if(dataList.get(idx)<lowest){
                    lowest =dataList.get(idx);
                    lowest_idx = idx;
                }
            }
            Collections.swap(dataList,stand,lowest_idx);
        }
        return dataList;
    }
}