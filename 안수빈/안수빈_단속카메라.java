import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        Arrays.sort(routes,(o1,o2)->o1[1]-o2[1]); //도착지점 기준으로 오름차순 정렬
        int endPoint = -30001;
        
        for(int i=0;i<routes.length;i++){
            if(endPoint < routes[i][0]){
                answer++;
                endPoint = routes[i][1];
            }
        }
        
        return answer;
    }
}
