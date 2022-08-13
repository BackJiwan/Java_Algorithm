//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.io.IOException;
//import java.util.Collections;
//import java.util.PriorityQueue;
//import java.util.StringTokenizer;
//
//public class bj2075_temp {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st;
//        int n = Integer.parseInt(br.readLine());
//        //int[][] arr = new int[n][n];
//
//        PriorityQueue[] heap = new PriorityQueue<>[n];
//        for(int i=0;i<n;i++){
//            st = new StringTokenizer(br.readLine()," ");
//            for(int j=0;j<n;j++){
//                heap[i].add(Integer.parseInt(st.nextToken()));
//            }
//        }
//
////        for (int i = 0; i < n; i++) {
////            st = new StringTokenizer(br.readLine()," ");
////            for (int j = 0; j < n; j++) {
////                arr[i][j] = Integer.parseInt(st.nextToken());
////            }
////        }
//    }
//}