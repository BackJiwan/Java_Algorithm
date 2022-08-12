import java.util.ArrayList;
import  java.util.Collections;

public class Heap {
    public ArrayList<Integer> heapArray = null;

    public Heap(Integer data) { //힙 생성자
        this.heapArray = new ArrayList<Integer>();
        // 배열은 인덱스가 0번부터 시작하지만, 힙 구현의 편의를 위해, root 노드 인덱스 번호를 1로 지정하기 위해,
        // 0번 인덱스에는 강제로 null 을 넣어주기로 함
        this.heapArray.add(null);
        this.heapArray.add(data);
    }


    public boolean move_up(Integer inserted_idx) { // 삽입한 노드가 상위노드로 올라가야하는지를 판별
        if (inserted_idx <= 1) { //삽입된 노드의 인덱스가 1보다 같거나 작다 = 올라갈곳이 없다.
            return false;
        }
        Integer parent_idx = inserted_idx / 2; //인덱스를 2로 나누기 연산 => 부모노드의 인덱스
        if (this.heapArray.get(inserted_idx) > this.heapArray.get(parent_idx)) {
            return true; //삽입된 자식 노드가 부모 노드보다 크다면 위로 올라가야 한다.
        } else {
            return false;
        }
    }

    public boolean insert(Integer data) {
        Integer inserted_idx, parent_idx;
        if (this.heapArray == null) { //만약 배열이 null이라면 힙생성자와 동일한 작업으로 새로운 배열힙을 생성한다.
            this.heapArray = new ArrayList<Integer>();
            // 배열은 인덱스가 0번부터 시작하지만, 힙 구현의 편의를 위해, root 노드 인덱스 번호를 1로 지정하기 위해,
            // 0번 인덱스에는 강제로 null 을 넣어주기로 함
            this.heapArray.add(null);
            this.heapArray.add(data);
            return true;
        }

        this.heapArray.add(data); //추가할 데이터를 배열의 맨뒤에 추가
        inserted_idx = this.heapArray.size() - 1; //추가한 노드의 인덱스를 inserted_idx에 대입 연산

        while (this.move_up(inserted_idx)) { //move_up = true 인동안 부모와 삽입된 노드를 Swap 한다.
            parent_idx = inserted_idx / 2;
            Collections.swap(heapArray, inserted_idx, parent_idx);
            inserted_idx = parent_idx;
        }
        return true;
    }

    public boolean move_down(Integer popped_idx) { //노드가 아래로 내려가야 하는지를 판별
        Integer left_child_popped_idx, right_child_popped_idx;

        left_child_popped_idx = popped_idx * 2; //2로 나누면 해당 노드의 왼쪽 자식노드의 인덱스
        right_child_popped_idx = popped_idx * 2 + 1; //2로 나누고 1더하면 해당 노드의 오른쪽 자식 노드의 인덱스

        // CASE1: 왼쪽 자식 노드도 없을 때, 힙은 왼쪽 부터 채워지기 때문
        if (left_child_popped_idx >= this.heapArray.size()) { // 왼쪽 자식의 인덱스가 사이즈보다 같거나 크다면
            return false;
            // CASE2: 오른쪽 자식 노드만 없을 때 = 왼쪽 자식만 있을때
        } else if (right_child_popped_idx >= this.heapArray.size()) { //오른쪽 자식 노드의 크기가 사이즈보다 같거나 크다면
            if (this.heapArray.get(popped_idx) < this.heapArray.get(left_child_popped_idx)) {
                return true; //왼쪽 자식보다 해당 노드가 더 작다면 아래로 내려가야한다.
            } else {
                return false;
            }
            // CASE3: 왼쪽, 오른쪽 자식 노드 모두 있을 때
        } else {
            if (this.heapArray.get(left_child_popped_idx) > this.heapArray.get(right_child_popped_idx)) {
                if (this.heapArray.get(popped_idx) < this.heapArray.get(left_child_popped_idx)) {
                    return true; //왼쪽자식이 오른쪽 자식보다 크고 해당노드는 왼쪽 자식보다 작아서 내려가야 한다.
                } else {
                    return false;
                }
            } else {
                if (this.heapArray.get(popped_idx) < this.heapArray.get(right_child_popped_idx)) {
                    return true; // 오른쪽 자식이 왼쪽 자식보다 크고 해당 노드는 오른쪽 자식보다 자아서 내려가야 한다.
                } else {
                    return false;
                }
            }
        }
    }

    public Integer pop() {
        Integer returned_data, popped_idx, left_child_popped_idx, right_child_popped_idx;

        if (this.heapArray.size() <= 1) {
            return null;
        }

        returned_data = this.heapArray.get(1); // 루트를 리턴 데이터로 저장
        this.heapArray.set(1, this.heapArray.get(this.heapArray.size() - 1)); // 맨뒤의 노드를 루트로 올려주고
        this.heapArray.remove(this.heapArray.size() - 1); //맨뒤의 노드를 삭제
        popped_idx = 1; // 루트노드를 popped_idx로 대입

        while (this.move_down(popped_idx)) { //내려가야 하는동안 반복한다.
            left_child_popped_idx = popped_idx * 2;
            right_child_popped_idx = popped_idx * 2 + 1;

            // 위의 move_down 메서드와 동일하게 자식노드가 왼쪽만 있는지, 둘다 있는지 확인하고
            // 자식과 해당 노드를 Swap 해야하는 경우에 Swap 하는 조건문이다.
            if (right_child_popped_idx >= this.heapArray.size()) {
                if (this.heapArray.get(popped_idx) < this.heapArray.get(left_child_popped_idx)) {
                    Collections.swap(this.heapArray, popped_idx, left_child_popped_idx);
                    popped_idx = left_child_popped_idx;
                }
            } else {
                if (this.heapArray.get(left_child_popped_idx) > this.heapArray.get(right_child_popped_idx)) {
                    if (this.heapArray.get(popped_idx) < this.heapArray.get(left_child_popped_idx)) {
                        Collections.swap(this.heapArray, popped_idx, left_child_popped_idx);
                        popped_idx = left_child_popped_idx;
                    }
                } else {
                    if (this.heapArray.get(popped_idx) < this.heapArray.get(right_child_popped_idx)) {
                        Collections.swap(this.heapArray, popped_idx, right_child_popped_idx);
                        popped_idx = right_child_popped_idx;
                    }
                }
            }
        }
        return returned_data;
    }

    public static void main(String[] args) {
        Heap heapTest = new Heap(15);
        heapTest.insert(10);
        heapTest.insert(8);
        heapTest.insert(5);
        heapTest.insert(4);
        heapTest.insert(20);
        System.out.println(heapTest.heapArray);

        heapTest.pop();
        System.out.println(heapTest.heapArray);
    }
}
