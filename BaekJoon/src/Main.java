import java.util.Scanner;

public class Main{
    public static void main(String[]args) {
        int a,b,cnt;
        Scanner sc = new Scanner(System.in);

        cnt = sc.nextInt();
        for(int i = 0;i<cnt;i++){
            a = sc.nextInt();
            b = sc.nextInt();
            System.out.println(a+b);
        }
    }
}
