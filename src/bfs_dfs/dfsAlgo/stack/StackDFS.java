package bfs_dfs.dfsAlgo.stack;

import java.util.Arrays;
import java.util.Stack;

public class StackDFS {
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
    static Stack<Integer>stack = new Stack<>();
    static boolean []visited=new boolean[graph.length];

    public static void main(String[] args) {
        dfs(1);
        String []answer=sb.toString().split("");
        System.out.println(Arrays.toString(answer));
    }
    public static void dfs(int node) {

        stack.add(node);
        while (!stack.empty()){ // 스택이 비어있을때 까지 반복

            int top = stack.pop();
            visited[top-1] = true;
            sb.append(top);

            for(int nextNode:graph[top-1]){
                if (!visited[nextNode - 1]) { // 방문한 노드가 아니면 해당 노드 스택에 추가
                    stack.add(nextNode);
                }
            }
        }
    }
}
