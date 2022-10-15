package bj11047;

import java.io.*;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        double[] arr = new double[t];
        int[] good = new int[t];
        int[] pp = new int[t];
        for(int i=0;i<t;i++){
            int people = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine()," ");
            double[] arr2 = new double[people];
            double sum=0.0;
            for(int j=0;j<people;j++){
                arr2[j] = (double)Integer.parseInt(st.nextToken());
                sum += arr2[j];
            }
            double avg = (double)sum/people;
            int good_person = 0;
            for(int j=0;j<people;j++){
                if(arr2[j]>=avg){
                    good_person++;
                }
            }
            good[i] = good_person;
            pp[i] = people;
        }
        for(int i=0;i<t;i++){
            System.out.printf("%d/%d",good[i],pp[i]);
            System.out.println();
        }
    }
}
