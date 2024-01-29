package floyd.algo;

import java.util.Arrays;

public class Floyd {

    public static int[][] floyd(int n,int[][]example){
        int[][] graph = new int[n][n];

        // x, y가 같은 수면 0으로 넣고 나머지 INF값 넣기
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
               if(i!=j){
                   graph[i][j] = 500001;
               }
            }
        }

        // example배열에서 직접적으로 연결된 x, y에 해당하는 가중치 값 업데이트
        for(int i=0;i< example.length;i++){
            int x = example[i][0]-1;
            int y = example[i][1]-1;
            graph[x][y] = example[i][2];
        }

        // min((a->b),(a->k)+(k->b)) a->b로 직접적으로 거쳐간 가중치의 값과 a->k->b로 거쳐간 가중치 값 비교
        for(int k=0;k<n;k++){
            for(int a=0;a<n;a++){
                for(int b=0;b<n;b++){
                    int min = Math.min(graph[a][b],graph[a][k]+graph[k][b]);
                    graph[a][b] = min;
                }
            }
        }
        return graph;
    }
    public static void main(String[] args) {
        int n = 4;
        int[][]example = {
                {1, 2, 4},
                {1 ,4, 6},
                {2, 1, 3},
                {2, 3, 7},
                {3, 1, 5},
                {3, 4, 4},
                {4, 3, 2}
        };
        int[][] answer = floyd(n,example);

        for(int i=0;i< answer.length;i++){
            System.out.println(Arrays.toString(answer[i]));
        }

    }
}
