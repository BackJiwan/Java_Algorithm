import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.ListIterator;

public class bj1406_new {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        String input = br.readLine(); // 초기 문자열
        int M = Integer.parseInt(br.readLine()); // 반복횟수

        LinkedList<Character> list = new LinkedList<Character>();
        for (int i = 0; i < input.length(); i++) { //문자열을 char단위로 쪼개서 list에 저장
            list.add(input.charAt(i));
        }

        ListIterator<Character> iter = list.listIterator(); //list 객체에 listIterator() 메소드를 적용한 반환값을 iter 객체에 대입

        while(iter.hasNext()){ //리스트 요소에 다음값이 없을때까지 next요소로 넘어가면서 커서의 위치를 맨뒤로 위치시킨다.
            iter.next();
        }

        for (int i = 0; i < M; i++) {
            String str = br.readLine();
            char c = str.charAt(0); //명령어를 C에 담는다.
            switch (c) {
                case 'L': //n개의 배열에서 커서는 0~n까지 가능하다. (3개의 배열에서 배열 인덱스는 0,1,2. 커서는 0,1,2,3가능)
                    if (iter.hasPrevious()) //만약 이전 요소가 존재한다면 커서를 하나 이전으로 이동
                        iter.previous();
                    break;
                case 'D':
                    if (iter.hasNext())  //만약 이후 요소가 존재한다면 커서를 한번 앞으로 이동
                        iter.next();
                    break;
                case 'B':
                    if (iter.hasPrevious()) { //이전요소가 존재한다면 커서를 하나 이전으로 이동하면서 지나친 요소를 삭제
                        iter.previous();
                        iter.remove();
                    }
                    break;
                case 'P':
                    char temp = str.charAt(2); //추가하고자 하는 문자를 add한다.
                    iter.add(temp);
                    break;
                default:
                    break;
            }
        }
        for(Character chr : list){ //for - each 문을 사용한다.
            bw.write(chr);
        }
        bw.flush();
        bw.close();
    }
}
