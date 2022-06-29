import java.io.*;
import java.util.ArrayList;

public class bj2562 {
    public static void main(String[] args) throws IOException{
        ArrayList<Integer> list1 = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0;i<9;i++){
            list1.add(Integer.parseInt(br.readLine()));
        }

        Integer max=list1.get(0);
        Integer index = 0;
        for(int j=1;j<9;j++){
            if(max<list1.get(j)){
                max = list1.get(j);
                index = j;
                continue;

            } else
                continue;
        }
        System.out.println(max);
        System.out.print(index+1);
    }
}
