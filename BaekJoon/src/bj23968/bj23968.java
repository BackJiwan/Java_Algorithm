package bj23968;
import java.util.ArrayList;
import java.util.Collections;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class bj23968 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> dataList = new ArrayList<Integer>();
        BubbleSort bSort = new BubbleSort();

        StringTokenizer st =new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        StringTokenizer st2 =new StringTokenizer(br.readLine()," ");
        for(int i=0;i<n;i++){
            dataList.add(Integer.parseInt(st2.nextToken()));
        }
        bSort.sort(dataList,k);
        if(bSort.swap2 == false){
            System.out.print("-1");
        } else{
            System.out.print(bSort.a+" "+bSort.b);
        }

    }
}

class BubbleSort{
    int a=0,b=0;
    boolean swap2 = false;
    public void sort(ArrayList<Integer> dataList,int k){
        int n = 0;
        for(int idx=0;idx<dataList.size()-1;idx++){
            boolean swap = false;
            for(int idx2=0;idx2<dataList.size()-1-idx;idx2++){
                if(dataList.get(idx2)>dataList.get(idx2+1)){
                    Collections.swap(dataList,idx2,idx2+1);
                    swap = true;
                    n++;
                }
                if(n == k){
                    a = dataList.get(idx2);
                    b = dataList.get(idx2+1);
                    swap2 = true;
                    n++;
                }
            }
            if(swap ==false){
                break;
            }
        }
    }
}
