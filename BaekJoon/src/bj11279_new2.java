import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;

public class bj11279_new2 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(); //출력을 위한 StringBuilder
        int n = Integer.parseInt(br.readLine()); //연산의 개수 N
        maxHeap2 heap = new maxHeap2();


        for(int i=0;i<n;i++){
            int k = Integer.parseInt(br.readLine()); //입력값
            if(k==0){ //입력이 0 이라면 pop 메서드 실행
                sb.append(heap.pop()).append('\n');
            } else{ // 그외에는 insert 메서드 실행
                heap.insert(k);
            }
        }
        System.out.println(sb.toString());
    }
}
class maxHeap2{
    public ArrayList<Integer> heapArray;

    public maxHeap2(){ //계산의 편의를 위해서 index=0의 위치를 임의로 초기값을 설정
        this.heapArray = new ArrayList<Integer>();
        this.heapArray.add(null);
    }

    public void insert(Integer data){
        heapArray.add(data); //입력된 값을 add한다. 완전이진트리의 가장 오른쪽 아래로 위치
        Integer inserted_idx = heapArray.size()-1;

        //삽입된 노드가 루트가 아니고 부모노드보다 클 경우 => 부모와 Swap하고 index를 최신화한다.
        while(inserted_idx>1 && heapArray.get(inserted_idx/2)<heapArray.get(inserted_idx)){
            Integer temp = heapArray.get(inserted_idx/2);
            heapArray.set(inserted_idx/2,heapArray.get(inserted_idx));
            heapArray.set(inserted_idx,temp);
            inserted_idx /= 2;
        }

    }

    public Integer pop(){
        if(heapArray.size()-1<1){ //만약 최대힙이 비어있다면 0을 반환한다.
            return 0;
        }
        Integer root_node = heapArray.get(1);
        Integer end_node_idx = heapArray.size()-1;
        heapArray.set(1,heapArray.get(end_node_idx)); //루트자리에 제일 끝의 노드 값을 삽입
        heapArray.remove(heapArray.size()-1); //제일끝의 노드를 배열에서 삭제
        //특이한 것은 remove메서드의 index로 end_node_idx를 주면 에러가 발생한다. 같은 int 아닌가...

        Integer new_idx = 1; //맨오른쪽 아래의 자식이 루트노드로 올라왔다.
        while((new_idx*2)<heapArray.size()){
            Integer right_child_idx = new_idx*2 +1;
            Integer left_child_idx = new_idx*2;
            //불필요한 조건문을 줄이기 위해 기본적으로 왼쪽 자식노드가 오른쪽 자식노드보다 크다고 가정한다.
            Integer max = heapArray.get(left_child_idx);
            Integer max_idx = left_child_idx;
            //만약 오른쪽 자식노드가 존재하고, 왼쪽보다 오른쪽의 값이 더 크다면 최대값을 오른쪽 자식노드로 수정한다.
            if((right_child_idx<heapArray.size()) && (max<heapArray.get(right_child_idx))){
                max = heapArray.get(right_child_idx);
                max_idx = right_child_idx;
            }
            //부모노드가 자식노드의 최대값보다 크다면 더 이상 내려갈 필요가 없으니 반복문을 나온다.
            if(heapArray.get(new_idx)>max){
                break;
            }
            //최대값을 판별하고 나면 부모 노드를 내리고 더 큰 자식 노드를 위로 올리고 index를 수정한다.
            Integer temp = heapArray.get(new_idx);
            heapArray.set(new_idx,heapArray.get(max_idx));
            heapArray.set(max_idx,temp);
            new_idx = max_idx;
        }
        //루트노드를 반환해준다.
        return root_node;
    }
}

