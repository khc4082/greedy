package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
public class dijkstra_queue {

        static class Edge implements Comparable<Edge> {

            int v, weight;

            public Edge(int v, int weight) {
                this.v = v;
                this.weight = weight;
            }

            @Override
            public int compareTo(Edge o) {
                // TODO Auto-generated method stub
                return Integer.compare(this.weight, o.weight);
            }

            @Override
            public String toString() {
                return weight + "";
            }

        }



        public static void main(String[] args) {

            long time = System.currentTimeMillis();
            System.out.println(time);

            Scanner sc = new Scanner(System.in);

            System.out.print("V 입력:"); // 정점 입력
            int V = sc.nextInt();
            System.out.print("E 입력:"); // 간선 입력
            int E = sc.nextInt();

            List<Edge>[] adj = new ArrayList[V];
            for (int i = 0; i < V; i++)
                adj[i] = new ArrayList<>();
            for (int i = 0; i < E; i++) {
                // 출발, 도착, 가중치
                adj[sc.nextInt()].add(new Edge(sc.nextInt(), sc.nextInt()));
            }

            PriorityQueue<Edge> pq = new PriorityQueue<>(); // 우선순위 큐

            boolean[] check = new boolean[V];
            Edge[] D = new Edge[V];
            // 0번에서 출발

            for (int i = 0; i < V; i++) {
                // 정점
                if (i == 0) { // 초기화
                    D[i] = new Edge(i, 0);
                } else { // 나머지 최대값으로 초기화
                    D[i] = new Edge(i, Integer.MAX_VALUE);
                }
                pq.add(D[i]);
            }
            while (!pq.isEmpty()) {
                Edge edge = pq.poll();

                for (Edge next : adj[edge.v]) {
                    // 방문 되지 않고 D[next.v]가 D[edge.v] + next.weight 보다 더 크다면 갱신
                    if (!check[next.v] && D[next.v].weight > D[edge.v].weight + next.weight) {
                        D[next.v].weight = D[edge.v].weight + next.weight;

                        pq.remove(D[next.v]); // 제거
                        pq.add(D[next.v]); // 삽입
                    }
                }
                check[edge.v] = true; // 노드
            }
            System.out.println(Arrays.toString(D));

            time = System.currentTimeMillis();
            System.out.println(time);

        }

}
