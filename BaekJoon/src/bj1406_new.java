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

        ListIterator<Character> iter = list.listIterator();

        while(iter.hasNext()){
            iter.next();
        }

        for (int i = 0; i < M; i++) {
            String str = br.readLine();
            char c = str.charAt(0); //명령어를 C에 담는다.
            switch (c) {
                case 'L': //n개의 배열에서 커서는 0~n까지 가능하다. (3개의 배열에서 배열 인덱스는 0,1,2. 커서는 0,1,2,3가능)
                    if (iter.hasPrevious()) //역방향 탐색시 하나앞의 요소를 가지고 있다면
                        iter.previous();
                    break;
                case 'D':
                    if (iter.hasNext())  //커서=size = 문장의 맨뒤
                        iter.next();
                    break;
                case 'B':
                    if (iter.hasPrevious()) { //커서=0 = 문장의 맨앞
                        iter.previous();
                        iter.remove();
                    }
                    break;
                case 'P':
                    char temp = str.charAt(2);
                    iter.add(temp);
                    break;
                default:
                    break;
            }
        }
        for(Character chr : list){
            bw.write(chr);
        }
        bw.flush();
        bw.close();
    }
}
