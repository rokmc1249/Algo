package dijkstra.nativeAlgo;

import java.util.ArrayList;
import java.util.Arrays;

public class DijkstraNative {
    static ArrayList<int[]>[] graph;
    static boolean[] visited;
    static int[] dist;
    public static int[] dijkstra(int n,int[][]example) {
        dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE); // 처음 가중치 MAX_VALUE로 설정

        graph = new ArrayList[n + 2]; // 1부터 6에 해당하는 각 인접노드 및 해당 비용

        for (int i = 1; i <= n + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < example.length; i++) {
            int v1 = example[i][0]; // start
            int v2 = example[i][1]; // end
            int weight = example[i][2]; // weight
            graph[v1].add(new int[]{v2, weight}); // 인접노드인 v2와 가중치인 weight를 배열에 넣어줌
        }

        nativeDijkstra(1,n);
        return dist;
    }

    public static void nativeDijkstra(int start,int n){
        visited = new boolean[n + 1]; // 방문한 노드 표시하기 위한 배열
        dist[start-1] = 0;
        visited[start-1] = true;

        for(int[]array:graph[start]){ // 시작노드에서 인접한 노드의 가중치 값을 dist배열에 넣기
            dist[array[0]-1]=array[1];
        }

        for(int i=1;i<=n;i++){ // 시작노드를 제외하고 n까지 반복
            int current = minNode();
            visited[current-1] = true; // 최소 노드는 방문했으니 true

            for(int[]neighbor:graph[current]){ //해당 노드의 인접노드 추출
                int adj = neighbor[0]; // 인접 노드
                int cost = dist[current-1] + neighbor[1]; // 축척된 가중치 + 인접 노드의 가중치
                if(dist[adj-1]>cost){
                    dist[adj-1] = cost; // 최소비용 업데이트
                }
            }
        }
    }
    public static int minNode(){ // 최소 가중치인 노드 찾는 메서드
        int min = Integer.MAX_VALUE;
        int index = 0; // 최소 가중치인 노드를 반환
        for(int i=1;i < visited.length;i++){
            if(!visited[i]&&dist[i]<min){ // 방문안했으면서 dist배열의 i번 인덱스의 값이 min보다 작을 경우
                min = dist[i]; // dist[i]로 min초기화
                index = i; // 해당 인덱스 i로 초기화
            }
        }
        return index+1;
    }
    public static void main(String[] args) {
        int n =5;
        int[][] example = {
                {1, 2, 2},
                {1, 3, 5},
                {1, 4, 1},
                {2, 3, 3},
                {2, 4, 2},
                {3, 2, 3},
                {3, 6, 5},
                {4, 3, 3},
                {4, 5, 1},
                {5, 3, 1},
                {5, 6, 2}
        };
        System.out.println(Arrays.toString(dijkstra(n,example)));
    }
}
