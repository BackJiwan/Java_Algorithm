import java.io.*;
import java.util.Stack;

public class bj10773_1 {
    public static void main(String[] args) throws IOException{
        Stack<Integer> stack = new Stack<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        for(int i=0;i<n;i++){
            int num = Integer.parseInt(br.readLine());
            if(num==0){
                stack.pop();
            } else{
                stack.push(num);
            }
        }
        int sum=0;
        for(int j:stack){
            sum += j;
        }
        System.out.print(sum);
    }
}
