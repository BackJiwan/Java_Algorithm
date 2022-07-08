import java.util.ArrayList;
import java.util.LinkedList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;


public class bj1021 {
    public static void main(String[] args) throws IOException{
        LinkedList<Integer> list = new LinkedList<>();
        ArrayList<Integer> arr = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1,st2;

        st1 = new StringTokenizer(br.readLine());
        Integer n = Integer.parseInt(st1.nextToken()); //큐의 크기
        Integer m = Integer.parseInt(st1.nextToken()); //뽑는 숫자의 개수
        st2 = new StringTokenizer(br.readLine());
        int cnt =0;
        for(int i=1;i<=n;i++){
            list.add(i);
        }
        for(int i=0;i<m;i++){
            arr.add(Integer.parseInt(st2.nextToken()));
        }
        for(int i=0;i<m;i++){ //i는 뽑고자하는 수의 인덱스
            int idx = list.indexOf(arr.get(i));
            int half;

            if(list.size() % 2 == 0){
                half = list.size()/2 - 1;
            }else{
                half = list.size()/2;
            }

            if(idx <= half){ //왼쪽으로 이동이 더 빠르다.
                for(int j =0;j<idx;j++){
                    list.addLast(list.poll());
                    cnt++;
                }
            } else{//오른쪽으로 이동이 더 빠르다.
                for(int j=0;j<list.size()-idx;j++){
                    list.addFirst(list.pollLast());
                    cnt++;
                }
            }
            list.poll();
        }
        System.out.println(cnt);
    }
}
