package bfs_dfs.bfsAlgo.queue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class QueueBFS {
    static int[][]graph = {
            {2, 3},
            {5},
            {5},
            {},
            {6, 7},
            {},
            {3}};



    static StringBuilder sb = new StringBuilder();

    static boolean []visited=new boolean[graph.length+1];
    static Queue<Integer>queue=new LinkedList<>();
    public static void main(String[] args) {

        bfs(1);
        String []answer=sb.toString().split("");
        System.out.println(Arrays.toString(answer));
    }
    public static void bfs(int node) {
        queue.add(node);
        visited[node]=true;
        while(!queue.isEmpty()){ // 큐가 비어있을때 까지 순회
            int pop = queue.poll(); // 맨 왼쪽노드 빼기
            sb.append(pop);
            
            for(int nextNode:graph[pop-1]){ // 큐에서 뺀 노드가 가지고 있는 노드들 순회
                if(!visited[nextNode]) { // 방문한적 없는 경우
                    queue.add(nextNode);
                    visited[nextNode] = true;
                }
            }
        }
    }
}
