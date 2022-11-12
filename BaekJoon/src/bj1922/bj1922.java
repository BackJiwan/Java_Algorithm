package bj1922;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//각 컴퓨터끼리의 연결 가중치의 최소합을 구하기 위함 = Spanning Tree = 크루스칼
class Edge implements Comparable<Edge>{
    int weight;
    int a;
    int b;

    public Edge(int weight,int a,int b){
        this.weight = weight;
        this.a = a;
        this.b = b;
    }

    @Override
    public int compareTo(Edge edge){
        return this.weight - edge.weight;
    }
}

public class bj1922 {
    static int n;
    static int m;
    static int result;
    static PriorityQueue<Edge> queue;
    static int[] parent;
    public static void main(String[] args) throws  IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        //가중치를 정렬하기 위해 우선순위 큐를 사용
        queue = new PriorityQueue<Edge>();
        //부모배열
        parent = new int[n+1];

        //부모배열 초기화
        for(int i=1; i<parent.length;i++){
            parent[i] = i;
        }

        for(int i=0;i<m;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            //간선의 가중치 정보를 우선순위 큐에 저장한다. 이때 정렬기준은 가중치이다.
            queue.offer(new Edge(weight,a,b));
        }

        while(!queue.isEmpty()){
            //우선수위 큐에서 하나씩 노드를 꺼낸다.
            Edge edge = queue.poll();
            //만약 두 노드가 부모가 다르다면 = 사이클이 없다면
            //정렬된 우선순위 큐 이기 때문에 꺼내어지고 사이클이 없다면 result에 저장
            if(find(edge.a) != find(edge.b)){
                union(edge.a,edge.b);
                result += edge.weight;
            }
        }
        System.out.println(result);
    }
    //부모노드를 비교하여 두개의 노드를 하나로 합쳐주는 Union 메소드
    static void union(int a,int b){
        int parentA = find(a);
        int parentB = find(b);

        if(parentA<parentB){
            parent[parentB] = parentA;
        } else{
            parent[parentA] = parentB;
        }
    }
    //부모노드를 찾아서 리턴하는 메소드 find
    static int find(int e){
        if(parent[e] ==e){
            return e;
        }
        return parent[e] = find(parent[e]);
    }
}
