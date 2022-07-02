import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;


public class bj10828 {
    private static ArrayList<Integer> stack = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        while(n > 0){
            st = new StringTokenizer(br.readLine()," ");
            String s = st.nextToken();
            switch(s) {
                case "push":    push(Integer.parseInt(st.nextToken()));
                                break;
                case "pop" :    System.out.println(pop());
                                break;
                case "size":    System.out.println(size());
                                break;
                case "empty":   System.out.println(empty());
                                break;
                case "top" :    System.out.println(top());
                                break;

            }
            n--;
        }


    }
    public static void push(int item){
        stack.add(item);
    }
    public static int pop(){
        if(stack.isEmpty()){
            return -1;
        }
        else{
            return stack.remove(stack.size()-1);
        }
    }
    public static int size() {
        return stack.size();
    }
    public static int empty(){
        if(stack.isEmpty()){
            return 1;
        } else{
            return 0;
        }
    }
    public static int top(){
        if(stack.isEmpty()){
            return -1;
        } else{
            return stack.get(stack.size()-1);
        }
    }
}
