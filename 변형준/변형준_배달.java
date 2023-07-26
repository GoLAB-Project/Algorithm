/**
	https://school.programmers.co.kr/learn/courses/30/lessons/12978
	배달 - Summer/Winter Coding(~2018)

    - DFS 깊이 우선 탐색
    참고  https://hudi.blog/dfs-bfs/ 
**/

import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    static int answer;
    static int K=1;
    static ArrayList<ArrayList<int[]>> list = new ArrayList<>();
    static int[] time; // 각 마을에 걸리는 시간


    public int solution(int N, int[][] road, int K) {
        answer = 1;
        this.K = K;
        
        // 1. 최댓값으로 초기화
        time = new int[N+1];
        for(int i = 0; i < time.length; i++){
            time[i] = Integer.MAX_VALUE;
        }
        
        // 2. 인접 list road 기반 초기화
        for(int i=0;i<N+1;i++){
            list.add(new ArrayList<>());
        }
        for(int i=0;i<road.length;i++) {
            list.get(road[i][0]).add(new int[]{road[i][1],road[i][2]});
            list.get(road[i][1]).add(new int[]{road[i][0],road[i][2]});
        }
        
        // 3. dfs
        dfs(1, 0);
        
        return answer;
    }

    public void dfs(int n, int weight){
        // 지금까지의 시간
        time[n] = weight;

        for(int[] node : list.get(n)){
            // 현재 시간에 다음 마을을 가는 시간을 더한 값    
            int sum = node[1] + weight;
            
            // 1. sum이 만약 K를 넘어가거나 node[0]번 마을의 지금까지의 최솟값보다 크다면 진행
            if(K < sum || time[node[0]] < sum) continue;
            // 2. 방문하지 않은 경우  
            if(time[node[0]] == Integer.MAX_VALUE) answer++; // 배달이 가능하기 때문에 +1
            
            dfs(node[0], node[1] + weight); //재귀
        }
    }
}
