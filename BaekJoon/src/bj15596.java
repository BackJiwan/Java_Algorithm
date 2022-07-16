public class bj15596 {
    public long sum(int[] a){
        long sum=0;
        for(int i=0;i<a.length;i++){
            sum += (long)a[i];
        }
        return sum;
    }
}
