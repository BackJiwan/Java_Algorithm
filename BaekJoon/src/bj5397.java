import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.ListIterator;


public class bj5397 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));



       int n = Integer.parseInt(br.readLine()); //테스트케이스의 개수
       String[] arr = new String[2];
       for(int i=0;i<n;i++){
           arr[i] = br.readLine();
       }

       for(int i=0;i<n;i++){
           String s = arr[i];
           for(int j =0;j<s.length();j++){ //char 단위로 쪼개서 리스트에 저장
                LinkedList<Character> list = new LinkedList<Character>();
                ListIterator<Character> iter = list.listIterator();
                char c = s.charAt(i);
                switch(c){
                    case '<' :
                        if(iter.hasPrevious())
                            iter.previous();
                        break;
                    case '>' :
                        if(iter.hasNext())
                            iter.next();
                        break;
                    case '-' :
                        if(iter.hasPrevious()){
                            iter.previous();
                            iter.remove();
                        }
                        break;
                    default:
                        iter.add(c);
                        break;
                }
                while(iter.hasPrevious()){
                    iter.previous();
                }
                while(iter.hasNext()){
                    bw.write(iter.next());
                }
                bw.newLine();
           }
       }
       br.close();
       bw.flush();
       bw.close();
    }
}
