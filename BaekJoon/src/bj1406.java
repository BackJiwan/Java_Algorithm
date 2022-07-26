import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class bj1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        LinkedList<Character> list = new LinkedList<>();
        StringTokenizer st;

        String input = br.readLine(); // 초기 문자열
        int M = Integer.parseInt(br.readLine()); // 반복횟수


        for (int i = 0; i < input.length(); i++) { //문자열을 char단위로 쪼개서 list에 저장
            list.offer(input.charAt(i));
        }

        int cursor = list.size(); //커서를 n으로 초기화하면 맨 뒤에 위치
        char c; //입력 받는 명령어
        char temp; // 문맥교환용
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " "); // 한줄의 입력을 공백기준으로 나누어서 st에 저장
            c = st.nextToken().charAt(0); //명령어를 C에 담는다.
            switch (c) {
                case 'L': //n개의 배열에서 커서는 0~n까지 가능하다. (3개의 배열에서 배열 인덱스는 0,1,2. 커서는 0,1,2,3가능)
                    if (cursor == 0) { //커서=0 = 문장의 맨앞
                        break;
                    } else {
                        cursor--;
                        break;
                    }
                case 'D':
                    if (cursor == list.size()) { //커서=size = 문장의 맨뒤
                        break;
                    } else {
                        cursor++;
                        break;
                    }
                case 'B':
                    if (cursor == 0) { //커서=0 = 문장의 맨앞
                        break;
                    } else {//커서의 왼쪽 문자를 삭제하고 커서도 1만큼 줄여줘야 줄어든 리스트 사이즈에 맞춰진 원래위치를 찾아갈수있다.
                        list.remove(cursor - 1);
                        cursor--;
                        break;
                    }
                case 'P':
                    if (cursor == 0) {
                        list.offerFirst(st.nextToken().charAt(0));
                        cursor++;
                    } else {//단순히 add를 하면 기존인덱스 뒤에 와야하는데, 기존것을 밀어내고 그자리에 들어가서 뒤로 밀린다.
                        temp = list.get(cursor-1); //따라서 기존 요소를 빼두었다가 반대로 add하여, 새로추가한 요소를 뒤로 밀어낸다.
                        list.set(cursor - 1, st.nextToken().charAt(0));
                        list.add(cursor-1,temp);
                        cursor++;
                    }
                default:
                    break;
            }
        }
        br.close();
        int size = list.size();
        for(int i=0;i<size;i++){
            bw.write(list.poll());
        }
        bw.flush();
        bw.close();
    }
}
/*
1. 리스트의 형태
2. 순환하지 않으므로 deque가 아님
3. 중간값의 삽입삭제를 위해 LinkedList 사용
4. n개의 요소를 가진 리스트는 0~n-1의 인덱스를 가지고, 커서는 0~n 범위로 0을 제외하고 n-1 번째 인덱스의 요소를 다룬다.
* */
