package bfs_dfs.dfsAlgo.example;

public class IslandRecursive {
    static int answer = 0;
    static int[][]graph={
            {1, 1, 0, 1, 0},
            {1, 1 ,1, 1, 0},
            {0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0}
    };
    static int dx[]={-1,1,0,0}; // 상 하 좌 우
    static int dy[]={0,0,-1,1}; // 상 하 좌 우

    public static void main(String[] args) {
        int x=0,y=0;
        System.out.println("섬의 개수는 "+solution(x,y));
    }
    public static int solution(int x,int y) {
        int answer=0;
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                if (graph[i][j] == 1) { // 육지인 경우
                    answer++; // 새로운 섬 발견
                    dfs_recursive(i, j); // 현재 육지에서 DFS로 연결된 모든 육지를 탐색
                }
            }
        }
        return answer;
    }

    public static void dfs_recursive(int x,int y){

        graph[x][y] = 0;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < graph.length && ny < graph[0].length && graph[nx][ny] == 1) { // 범위 조건
                dfs_recursive(nx, ny);
            }
        }

    }

}
