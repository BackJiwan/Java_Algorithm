import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class bj1966 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int test = Integer.parseInt(br.readLine()); //테스트케이스의 개수
        for(int i =0;i<test;i++){
            LinkedList<int []> list = new LinkedList<>(); //리스트는 문서의 인덱스와 중요도를 저장
            StringTokenizer st1,st2;

            st1 = new StringTokenizer(br.readLine()," ");
            int n = Integer.parseInt(st1.nextToken());
            int m = Integer.parseInt(st1.nextToken());

            st2 = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<n;j++){
                list.offer(new int[] {j,Integer.parseInt(st2.nextToken())});
            }

            int cnt=0;

            while(!list.isEmpty()){
                int[] temp = list.poll();
                boolean isMax = true;

                for(int k=0;k<list.size();k++){
                    if(temp[1]<list.get(k)[1]){
                        list.offerLast(temp);
                        for(int j=0;j<k;j++){
                            list.offer(list.poll());
                        }
                        isMax = false;
                        break;
                    }
                }
                if(isMax ==false){
                    continue;
                }
                cnt++;
                if(temp[0] == m){
                    break;
                }
            }
            sb.append(cnt+"\n");
        }
        System.out.println(sb);
    }
}
