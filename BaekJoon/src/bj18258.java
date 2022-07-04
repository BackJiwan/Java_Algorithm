import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class bj18258 {
    private static ArrayList<Integer> queue = new ArrayList<>();
    public static void push(int item){
        queue.add(item);
    }
    public static Integer pop(){
        if(queue.isEmpty()){
            return -1;
        } else{
            Integer num = queue.get(0);
            queue.remove(0);
            return num;
        }
    }
    public static Integer size(){
        return queue.size();
    }
    public static Integer empty(){
        if(queue.isEmpty())
            return 1;
        else
            return 0;
    }
    public static Integer front(){
        if(queue.isEmpty()){
            return -1;
        } else{
            Integer num = queue.get(0);
            return num;
        }
    }
    public static Integer back(){
        if(queue.isEmpty()){
            return -1;
        } else{
            Integer num = queue.get(queue.size()-1);
            return num;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            switch(s){
                case "push":
                    int param = Integer.parseInt(st.nextToken());
                    push(param);
                    break;
                case "pop":
                    sb.append(pop()).append("\n");
                    break;
                case "size":
                    sb.append(size()).append("\n");
                    break;
                case "empty":
                    sb.append(empty()).append("\n");
                    break;
                case "front":
                    sb.append(front()).append("\n");
                    break;
                case "back":
                    sb.append(back()).append("\n");
                    break;
            }
        }
        System.out.print(sb);
    }
}
