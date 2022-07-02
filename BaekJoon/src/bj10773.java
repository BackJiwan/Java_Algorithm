import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

public class bj10773 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();

        int n = Integer.parseInt(br.readLine());
        int sum=0;
        for(int i=0;i<n;i++){
            int num = Integer.parseInt(br.readLine());
            if(num == 0){
                stack.pop();
            }
            else {
                stack.push(num);
            }
        }

        for(int k:stack){
            sum += k;
        }
        System.out.print(sum);
    }
}
