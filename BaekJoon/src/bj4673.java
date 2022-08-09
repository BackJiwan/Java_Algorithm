public class bj4673 {
    public static void main(String[] args){
        boolean[] list = new boolean[10001];
        for(int i=1;i<10001;i++){
            int n = d(i);

            if(n<10001){
                list[n] = true;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<10001;i++){
            if(!list[i]){
                sb.append(i).append('\n');
            }
        }
        System.out.println(sb);
    }
    public static int d(int n){
        int sum = n;

        while(n != 0){
            sum = sum + (n%10);
            n = n/10;
        }
        return sum;
    }
}
