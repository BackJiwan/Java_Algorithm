import java.util.Scanner;
public class Main{
    public static void main(String[]args) {
       Scanner sc = new Scanner(System.in);

       int n,a,b;
       n = sc.nextInt();
       String[] s = new String[n];

       for(int i=1;i<=n;i++){
           a=sc.nextInt();
           b=sc.nextInt();
           s[i-1] = String.format("Case #%d: %d",i,a+b);
       }
       for(int i=0;i<n;i++){
           System.out.println(s[i]);
       }
    }
}

