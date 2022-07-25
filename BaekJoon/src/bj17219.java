import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;


public class bj17219 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine()," "); //저장된 사이트의 수 + 비밀번호를 찾으려는 사이트의수 입력받기
        Map<String, String> hash = new HashMap<>(); // 해쉬탬 클래스 사용 Map<key,Value>

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        StringTokenizer st2;
        for(int i =0;i<n;i++){ //사이트 주소와 비밀번호를 입력받는다. n번
            st2 = new StringTokenizer(br.readLine()," ");
            hash.put(st2.nextToken(),st2.nextToken());
        }

        for(int i=0;i<m;i++){ //m개의 줄에 걸쳐 비밀번호를 hash맵에서 가져온다.
            bw.write(hash.get(br.readLine()));
            bw.newLine();
        }
        br.close();
        bw.flush();
        bw.close();
    }
}