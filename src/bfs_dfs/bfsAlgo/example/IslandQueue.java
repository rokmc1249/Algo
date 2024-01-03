package bfs_dfs.bfsAlgo.example;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class IslandQueue {
    static int answer = 0;
    static int[][] graph = {
            {1, 1, 0, 1, 0},
            {1, 1 ,1, 1, 0},
            {0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0}
    };
    static int dx[] = {-1, 1, 0, 0}; // 상 하 좌 우
    static int dy[] = {0, 0, -1, 1}; // 상 하 좌 우
    static Queue<List<Integer>> queue = new LinkedList<>();

    public static void main(String[] args) {
        int x = 0, y = 0;
        System.out.println("섬의 개수는 " + solution(x, y));
    }

    public static int solution(int x, int y) {
        int answer = 0;
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                if (graph[i][j] == 1) {
                    answer++;
                    List<Integer> nodes = new ArrayList<>();
                    nodes.add(i);
                    nodes.add(j);
                    graph[i][j] = 0;
                    bfs_queue(nodes);
                }
            }
        }
        return answer;
    }

    public static void bfs_queue(List<Integer> nodes) {
        queue.add(nodes);

        while (!queue.isEmpty()) {
            List<Integer> top = queue.poll();
            graph[top.get(0)][top.get(1)] = 0; // 방문한 곳 0
            for (int i = 0; i < 4; i++) {
                int nx = top.get(0) + dx[i];
                int ny = top.get(1) + dy[i];
                if (nx >= 0 && ny >= 0 && nx < graph.length && ny < graph[0].length && graph[nx][ny] == 1) { // 범위 조건
                    List<Integer> newNodes = new ArrayList<>();
                    newNodes.add(nx);
                    newNodes.add(ny);
                    if(!queue.contains(newNodes)){
                        queue.add(newNodes);
                    }
                }
            }

        }
    }
}