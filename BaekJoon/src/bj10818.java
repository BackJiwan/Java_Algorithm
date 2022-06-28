import java.util.ArrayList;
import java.io.*;
import java.util.StringTokenizer;

public class bj10818 {
    public static void Main(String[] args) throws IOException {
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        int size = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine()," ");
        br.close();

        for(int i=0;i<size;i++){
            list1.set(i, Integer.parseInt(st.nextToken()));
        }

        int min = list1.get(0);
        int max = list1.get(0);

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
    }
}
