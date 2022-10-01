package bj1260;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class bj1260 {
    static int N,M,V;
    static ArrayList<ArrayList<Integer>> map = new ArrayList<>();
    static StringBuilder sb1 = new StringBuilder();
    static StringBuilder sb2 = new StringBuilder();

    static boolean[] visited1,visited2;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken()); //정점의 개수
        M = Integer.parseInt(st.nextToken()); //간선의 개수
        V = Integer.parseInt(st.nextToken()); //탐색을 시작할 정점의 번호

        for(int i=0;i<N+1;i++){ //
            map.add(i,new ArrayList<Integer>()); //map에 순서대로 비어있는 ArrayList를 추가한다.
            //각, 정점은 연결되어 있는 다른 정점의 목록을 ArrayList로 가진다.
        }

        visited1 = new boolean[N+1];
        visited2 = new boolean[N+1];

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            map.get(a).add(b);
            map.get(b).add(a); //양방향 간선이기 때문에 두 가지의 경우를 모두 저장
        }

        for(int i=0;i<N+1;i++){ //정점번호가 작은것을 먼저 방문하기 위해서 map의 각 정점들의 연결된 정점들의 목록을 정렬한다.
            Collections.sort(map.get(i));
        }
        dfsFunc(V);
        System.out.println(sb1);
        bfsFunc(V);
        System.out.println(sb2);
    }

    public static void dfsFunc(int startNode){
        visited1[startNode] = true; //시작 정점을 방문했음에 체크
        sb1.append(startNode + " "); //시작 정점을 스트링빌더에 추가
        for(int i=0;i<map.get(startNode).size();i++){ //시작 노드에 연결된 방문 가능한 노드만큼 반복
            if(!visited1[map.get(startNode).get(i)]){
                dfsFunc(map.get(startNode).get(i)); //방문하지 않은 노드라면 재귀호출
            }
        }
    }
    public static void bfsFunc(int startNode){
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.add(startNode);
        visited2[startNode] = true;

        while(!queue.isEmpty()){
            int val = queue.poll(); //큐의 첫 노드 값 빼기(초기에는 startNode가 들어온다.)
            sb2.append(val+" "); //첫 노드 출력

            for(int i=0;i<map.get(val).size();i++){ //큐에서 첫 노드에 연결된 노드들을 모두 방문한다.
                if(!visited2[map.get(val).get(i)]){ //방문한적 없다면
                    visited2[map.get(val).get(i)] = true; //큐의 다음 요소를 방문체크하고
                    queue.add(map.get(val).get(i)); //한번 방문한 노드는 거기에 연결된 노드 리스트를 큐의 맨뒤에 추가
                }
            }
        }
    }

}
