package bj4485;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class bj4485 {
    static int N; //동굴의 크기 N*N
    static int[][] cave; //동굴 2차원 배열
    static int[][] rupy; //루피 최솟값 다익스트라
    static int[] dirX = {0,0,-1,1}; //4번에 걸쳐서 하,상,좌,우 로 한번씩 탐색해보기 위한 일차원 배열
    static int[] dirY = {-1,1,0,0}; //대각선이동은 불가능하기 때문에 1과 -1은 공존할 수 없다. 같은위치에

    static class Edge implements Comparable<Edge>{
        int x;
        int y;
        int weight;

        public Edge(int x,int y,int weight){
            this.x = x;
            this.y = y;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge e){
            return weight - e.weight;
        } //최소비용을 위한 minHeap 구현을 위해서 오름차순으로 수정한다.
    }

    static boolean isVaild(int x,int y){
        if(x<0 || x>=N || y<0 || y>=N){
            return false; //만약 존재할수 없는 좌표일 경우
        }
        return true;
    }

    public static int dijkstra(){
        PriorityQueue<Edge> queue = new PriorityQueue<Edge>(); //루피값을 가지는 일차원 우선순위큐 큐의 각 요소는 Edge 타입이며 좌표와 가중치를 가진다.
        rupy[0][0] = cave[0][0];
        queue.offer(new Edge(0,0,cave[0][0])); //우선순위큐의 시작위치를 저장한다. cave[i][j] 위치에는 가중치가 저장되어 있다.

        while (!queue.isEmpty()){
            Edge edge = queue.poll();

            for(int i=0;i<4;i++){
                int nextX = edge.x + dirX[i];
                int nextY = edge.y + dirY[i];

                if(isVaild(nextX,nextY)){
                    if(rupy[nextX][nextY]>rupy[edge.x][edge.y]+cave[nextX][nextY]){ //만약 기존츼 가중치보다 작은 경우라면
                        rupy[nextX][nextY] = rupy[edge.x][edge.y]+cave[nextX][nextY]; //(지금까지 이동해온 경로 가중치 + 새로운 경로 가중치) 값으로 교환해준다.
                        queue.offer(new Edge(nextX,nextY,rupy[nextX][nextY])); //큐에 추가한다. (이 방향으로 이동한다.)
                    }
                }
            }
        }
        return rupy[N-1][N-1];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int cnt=0;
        while(true) {
            N = Integer.parseInt(br.readLine());
            if (N == 0) {
                break;
            } //N=0이 입력받으면 코드를 종료한다.
            cave = new int[N][N];
            rupy = new int[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    cave[i][j] = Integer.parseInt(st.nextToken()); //입력받은 값으로 동굴 좌표를 초기화한다.
                    rupy[i][j] = Integer.MAX_VALUE; //다익스트라의 루피의 최소값을 정수 최대치로 초기화
                }
            }
            cnt++;
            sb.append("Problem " + cnt + ": " + dijkstra() + "\n");
        }
        br.close();
        System.out.println(sb);
    }
}
