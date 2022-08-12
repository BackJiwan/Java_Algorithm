import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class bj11279_new2 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        maxHeap2 heap = new maxHeap2(0);

        int n = Integer.parseInt(br.readLine()); //연산의 개수 N
        for(int i=0;i<n;i++){
            int k = Integer.parseInt(br.readLine()); //명령
            if(k==0){
                if(heap.isEmpty()){
                    System.out.println(0);
                } else {
                    System.out.println(heap.pop());
                }
            } else{
                heap.insert(k);
            }
        }
    }

}
class maxHeap2{
    public boolean isEmpty(){
        return heapArray.isEmpty();
    }
    public ArrayList<Integer> heapArray = null;

    public maxHeap2(Integer data){
        this.heapArray = new ArrayList<Integer>();
        this.heapArray.add(data);
    }
    public boolean move_up(Integer inserted_idx){
        if(inserted_idx <= 1){
            return false;
        }
        Integer parent_idx = inserted_idx / 2;
        if(this.heapArray.get(parent_idx) < this.heapArray.get(inserted_idx)){
            return true;
        } else{
            return false;
        }
    }
    public boolean insert(Integer data){
        Integer inserted_idx,parent_idx;

        if(heapArray == null){
            this.heapArray = new ArrayList<Integer>();
            this.heapArray.add(data);
            return true;
        } else{
            this.heapArray.add(data);
            inserted_idx = this.heapArray.size() - 1;

            while(this.move_up(inserted_idx)){
                parent_idx = inserted_idx /2;
                Collections.swap(this.heapArray,inserted_idx,parent_idx);
                inserted_idx = parent_idx;
            }
            return true;
        }
    }
    public boolean move_down(Integer popped_idx) {
        Integer left_child_popped_idx, right_child_popped_idx;

        left_child_popped_idx = popped_idx * 2;
        right_child_popped_idx = popped_idx * 2 + 1;

        //1: 왼쪽 자식 노드도 없을 경우
        if (left_child_popped_idx >= this.heapArray.size()) {
            return false;
        } else if (right_child_popped_idx >= this.heapArray.size()) { //오른쪽 자식만 없는 경우
            if (this.heapArray.get(popped_idx) < this.heapArray.get(left_child_popped_idx)) {
                return true;
            } else {
                return false;
            }
        } else { //왼쪽 오른쪽 자식 모두 있을때
            if (this.heapArray.get(left_child_popped_idx) > this.heapArray.get(right_child_popped_idx)) {
                if (this.heapArray.get(popped_idx) < this.heapArray.get(left_child_popped_idx)) {
                    return true;
                } else {
                    return false;
                }
            } else{
                if (this.heapArray.get(popped_idx) < this.heapArray.get(right_child_popped_idx)) {
                    return true;
                } else {
                    return false;
                }
            }
        }
    }

    public Integer pop(){
        Integer returned_data,popped_idx,left_child_popped_idx, right_child_popped_idx;

        if(this.heapArray.size() <= 1){
            return 0;
        }
        returned_data = this.heapArray.get(1); //루트노드를 저장
        this.heapArray.set(1,this.heapArray.get(this.heapArray.size()-1)); //마지막 노드를 루트로 올려주기
        this.heapArray.remove(this.heapArray.size()-1); // 마지막 노드를 삭제
        popped_idx = 1;

        while (this.move_down(popped_idx)) {
            left_child_popped_idx = popped_idx * 2;
            right_child_popped_idx = popped_idx * 2 + 1;

            if (right_child_popped_idx >= this.heapArray.size()) { //오른쪽 자식만 없는 경우
                if (this.heapArray.get(popped_idx) < this.heapArray.get(left_child_popped_idx)) {
                    Collections.swap(this.heapArray, popped_idx, left_child_popped_idx);
                    popped_idx = left_child_popped_idx;
                }
            } else { //왼쪽 오른쪽 자식 모두 있을때
                if (this.heapArray.get(left_child_popped_idx) > this.heapArray.get(right_child_popped_idx)) {
                    if (this.heapArray.get(popped_idx) < this.heapArray.get(left_child_popped_idx)) {
                        Collections.swap(this.heapArray, popped_idx, left_child_popped_idx);
                        popped_idx = left_child_popped_idx;
                    }  else{
                        if (this.heapArray.get(popped_idx) < this.heapArray.get(right_child_popped_idx)) {
                            Collections.swap(this.heapArray, popped_idx, right_child_popped_idx);
                            popped_idx = right_child_popped_idx;
                        }
                    }
                }
            }
        }
        return returned_data;
    }
}
