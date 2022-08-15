import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class bj11279 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        maxHeap heap = new maxHeap(0);
        heap.pop();

        int n = Integer.parseInt(br.readLine()); //연산의 개수 N
        for(int i=0;i<n;i++){
            int k = Integer.parseInt(br.readLine()); //명령
            if(k>0){
                heap.insert(k);
            } else{
                if(heap.heapArray.size() == 1){
                    sb.append('0').append('\n');
                }else {
                    sb.append(heap.pop()).append('\n');
                }
            }
        }
        System.out.println(sb.toString());
    }
    static class maxHeap{
        public ArrayList<Integer> heapArray = null;

        public maxHeap(Integer data){
            heapArray = new ArrayList<Integer>();
            heapArray.add(null);
            heapArray.add(data);
        }
        public boolean move_up(Integer inserted_idx){
            if(inserted_idx <= 1){
                return false;
            }
            Integer parent_idx = inserted_idx / 2;
            if(heapArray.get(parent_idx) < heapArray.get(inserted_idx)){
                return true;
            } else{
                return false;
            }
        }
        public boolean insert(Integer data){
            Integer inserted_idx,parent_idx;

            if(heapArray == null){
                heapArray = new ArrayList<Integer>();
                heapArray.add(null);
                heapArray.add(data);
                return true;
            } else{
                heapArray.add(data);
                inserted_idx = heapArray.size() - 1;

                while(move_up(inserted_idx)){
                    parent_idx = inserted_idx /2;
                    Collections.swap(heapArray,inserted_idx,parent_idx);
                    inserted_idx = parent_idx;
                    if(inserted_idx == 1)
                        break;
                }
                return true;
            }
        }
        public boolean move_down(Integer popped_idx) {
            Integer left_child_popped_idx, right_child_popped_idx;

            left_child_popped_idx = popped_idx * 2;
            right_child_popped_idx = popped_idx * 2 + 1;

            //1: 왼쪽 자식 노드도 없을 경우
            if (left_child_popped_idx >= heapArray.size()) {
                return false;
            } else if (right_child_popped_idx >= heapArray.size()) { //오른쪽 자식만 없는 경우
                if (heapArray.get(popped_idx) < heapArray.get(left_child_popped_idx)) {
                    return true;
                } else {
                    return false;
                }
            } else { //왼쪽 오른쪽 자식 모두 있을때
                if (heapArray.get(left_child_popped_idx) > heapArray.get(right_child_popped_idx)) {
                    if (heapArray.get(popped_idx) < heapArray.get(left_child_popped_idx)) {
                        return true;
                    } else {
                        return false;
                    }
                } else{
                    if (heapArray.get(popped_idx) < heapArray.get(right_child_popped_idx)) {
                        return true;
                    } else {
                        return false;
                    }
                }
            }
        }

        public Integer pop(){
            Integer returned_data,popped_idx,left_child_popped_idx, right_child_popped_idx;

            if(heapArray.size() <= 1){
                return 0;
            }
            returned_data = heapArray.get(1); //루트노드를 저장
            heapArray.set(1,heapArray.get(heapArray.size()-1)); //마지막 노드를 루트로 올려주기
            heapArray.remove(heapArray.size()-1); // 마지막 노드를 삭제
            popped_idx = 1;

            while (move_down(popped_idx)) {
                left_child_popped_idx = popped_idx * 2;
                right_child_popped_idx = popped_idx * 2 + 1;

                if (right_child_popped_idx >=heapArray.size()) { //오른쪽 자식만 없는 경우
                    if (heapArray.get(popped_idx) < heapArray.get(left_child_popped_idx)) {
                        Collections.swap(heapArray, popped_idx, left_child_popped_idx);
                        popped_idx = left_child_popped_idx;
                    }
                } else { //왼쪽 오른쪽 자식 모두 있을때
                    if (heapArray.get(left_child_popped_idx) > heapArray.get(right_child_popped_idx)) {
                        if (heapArray.get(popped_idx) < heapArray.get(left_child_popped_idx)) {
                            Collections.swap(heapArray, popped_idx, left_child_popped_idx);
                            popped_idx = left_child_popped_idx;
                        }  else{
                            if (heapArray.get(popped_idx) < heapArray.get(right_child_popped_idx)) {
                                Collections.swap(heapArray, popped_idx, right_child_popped_idx);
                                popped_idx = right_child_popped_idx;
                            }
                        }
                    }
                }
            }
            return returned_data;
        }
    }
}

