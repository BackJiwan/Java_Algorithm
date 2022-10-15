package bj11047;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main2 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(),"");
        ArrayList<Character> arr = new ArrayList<>();
        int cnt=1;
        for(int i=0;i<n;i++){
            arr.add((st.nextToken().charAt(0)));
        }
        for(int i=1;i<n;i++){
            if(arr.get(i-1)==arr.get(i)){
                cnt++;
            }
        }
        System.out.println(cnt);
    }


}
