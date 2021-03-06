package graph;

import java.util.Arrays;
import java.util.Scanner;

public class dijkstra {

    private static String secDiffTime;

    public static void main(String[] args) {

        long time = System.currentTimeMillis();
        System.out.println(time);

        Scanner sc = new Scanner(System.in);
        System.out.print("V 입력:"); // 정점 입력
        int V = sc.nextInt();
        System.out.print("E 입력:"); // 간선 입력
        int E = sc.nextInt();


        int[][] adj = new int[V][V];

        for (int i = 0; i < E; i++) {
            adj[sc.nextInt()][sc.nextInt()] = sc.nextInt(); // [행][열] = 값
        }

        int[] D = new int[V]; // 배열 D

        Arrays.fill(D, Integer.MAX_VALUE);
        boolean[] check = new boolean[V]; // 배열 초기화

        D[0] = 0;

        for (int i = 0; i < V - 1; i++) { // n-1회
            int min = Integer.MAX_VALUE; // 가장 작은 값
            int index = -1;// 위치

            for (int j = 0; j < V; j++) {
                // 남아있는 점 중 가장 짧은 거리
                if (!check[j] && min > D[j]) {
                    index = j;
                    min = D[j]; // 가장 짧다면 이 값으로 처리 됨
                }
            }

            for (int j = 0; j < V; j++) {
                // 남아있는 점 중 index까지의 거리 + index부터 j까지의 거리가 D[j]보다 짧은 거리
                if (!check[j] && adj[index][j] != 0 && D[index] != Integer.MAX_VALUE
                        && D[index] + adj[index][j] < D[j]) {
                    D[j] = D[index] + adj[index][j];
                }
            }
            check[index] = true; // 처리완료
        }
        System.out.println(Arrays.toString(D)); // 배열 출력

        time = System.currentTimeMillis();
        System.out.println(time);
    }

}