package dijkstra.priorityQueueAlgo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class DijkstraPQ {
    static ArrayList<int[]>[] graph;
    public static int[] dijkstra(int n,int[][]example){
        int[]dist=new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE); // 처음 가중치 MAX_VALUE로 설정

        graph = new ArrayList[n+2]; // 1부터 6에 해당하는 각 인접노드 및 해당 비용

        for(int i=1;i<=n+1;i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0;i < example.length;i++){
            int v1 = example[i][0]; // start
            int v2 = example[i][1]; // end
            int weight = example[i][2]; // weight
            graph[v1].add(new int[]{v2,weight}); // 인접노드인 v2와 가중치인 weight를 배열에 넣어줌
        }

        priorityQueueDijkstra(dist,1); // 우선순위큐를 이용해 1부터 시작
        return dist;
    }

    public static void  priorityQueueDijkstra(int[]dist,int start){
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) ->o1[1]-o2[1]);  // 최소 비용인 애를 먼저 꺼내기 위해 우선순위 큐 사용
        pq.offer(new int[]{start, 0}); // 1부터 시작이고 해당 비용은 0인거를 먼저 pq에 삽입
        dist[start-1] = 0;

        while(!pq.isEmpty()){ // 우선순위 큐가 비어있을때 까지 반복

            int[] arr = pq.poll(); // 우선순위가 높은(=최소 비용인 배열 먼저 추출)
            int current = arr[0]; // 현재 노드
            int acc = arr[1]; // 가중치

            if(dist[current-1]<acc){ //  현재 dist 배열에 있는 노드의 가중치가 pq에서 꺼내 축적된 가중치 보다 작을 경우 (무시하고 다음 반복 실행)
                continue;
            }

            for(int[]neighbor:graph[current]){ //해당 노드의 인접노드 추출
                int adj = neighbor[0]; // 인접 노드
                int cost = acc + neighbor[1]; // 축척된 가중치 + 인접 노드의 가중치
                if(dist[adj-1]>cost){
                    dist[adj-1] = cost; // 최소비용 업데이트
                    pq.offer(new int[]{adj,cost}); // 새롭게 pq에 추가
                }
            }

        }
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
