import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class bj2577 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list1 = new ArrayList<Integer>(Collections.nCopies(10,0));

        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());
        int m1 = a*b*c;
        int m2 = m1;
        int cnt = 0;

        while(m1 != 0){
            m1 = m1/10;
            ++cnt;
        } // 값이 몇자리의 수인지를 측정

        for(int i=1;i<=cnt;i++){
            int n = m2%(10*i);
            int k = list1.get(n)+1;
            list1.set(n,k);
        }
        for(int j=0;j<=cnt;j++){
            System.out.println(list1.get(j));
        }
    }

}
