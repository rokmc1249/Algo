package bfs_dfs.dfsAlgo.recursive;

import java.util.Arrays;

public class RecursiveDFS {
    static int[][]graph = {
            {2, 3, 4},
            {5},
            {5},
            {},
            {6, 7},
            {},
            {3}
    };
    static StringBuilder sb = new StringBuilder();

    static boolean []visited=new boolean[graph.length];

    public static void main(String[] args) {
        dfs(1);
        String []answer=sb.toString().split("");
        System.out.println(Arrays.toString(answer));
    }


    public static void dfs( int node) {
        visited[node - 1] = true;
        sb.append(node);

        for (int nextNode : graph[node - 1]) {
            if (!visited[nextNode - 1]) { // 방문한 노드가 아니면 해당 노드 재귀함수 실행
                dfs(nextNode); // 재귀함수
            }
        }
    }
}
