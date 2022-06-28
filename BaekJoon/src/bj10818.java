import java.util.ArrayList;
import java.io.*;
import java.util.StringTokenizer;

public class bj10818 {
    public static void main(String[] args) throws IOException {
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        br.close();

        for(int i=0;i<size;i++){
            list1.add(Integer.parseInt(st.nextToken()));
        } //입력값을 list1에 순차대입

        int min = list1.get(0);
        int max = list1.get(0); //최대최솟값을 배열의 최초값으로 초기화

        for(int j=1;j<size;j++) {
            if (list1.get(j) < min) {
                min = list1.get(j);
                continue;
            } else if (list1.get(j) > max) {
                max = list1.get(j);
                continue;
            } else
                continue;
        }
        System.out.print(min+" "+max);
    }
}
