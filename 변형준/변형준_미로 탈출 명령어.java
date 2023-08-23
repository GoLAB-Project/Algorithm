/*
    https://school.programmers.co.kr/learn/courses/30/lessons/150365
    미로 탈출 명령어 / 2023 KAKAO BLIND RECRUITMENT
        
    참고
    dfs https://scshim.tistory.com/241
    
*/

import java.util.*;
import java.awt.Point;


class Solution {
    static int[] dx = {1, 0, 0, -1}; // 하, 좌, 우, 상
    static int[] dy = {0, -1, 1, 0};
    static String[] way = {"d", "l", "r", "u"}; // 사전 순
    static String result = ""; // 이동 결과
    static int N,M; // Map 크기
    static int cnt = 0; // 움직인 거리
    static int K; // 이동할 거리
    static Point target; // 탈출지점

    
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        N = n;
        M = m;
        Point startP = new Point(x,y);
        target = new Point(r,c);
        K = k;
        int d = distance(startP, target);
        String answer = dfs(startP, d, "", cnt);
        
        return answer;
    }
    
    public int distance(Point startP, Point target) {
        return Math.abs(target.x - startP.x) + Math.abs(target.y - startP.y);  
    }
    
    public String dfs(Point startP, int d, String temp, int cnt){
        int targetD = K - cnt; // 탈출까지의 남은 목표 거리
        
        // dfs 종료지점 남은 거리가 0인 경우.
        if(targetD == 0 && d == 0) {
            result = temp;
            return result;
        }
        
        for(int i = 0; i < 4; i++) { // 하좌우상 순으로(사전 순으로) 이동
            Point nextP = new Point(startP.x + dx[i], startP.y + dy[i]);
            
            // 움직인 좌표가 map을 벗어나는가?
            if(nextP.x > 0 && nextP.y > 0 && nextP.x <= N && nextP.y <= M) {
            // 탈출까지의 거리가 실제 거리보다 크거나 같은가?
            // ex) 탈출까지 허용된 거리 targetD = 3, 실제 남은 거리 d = 4 -> 불가능 impossible
                if(d <= targetD) {
            // 탈출까지의 거리가 실제 거리의 홀짝이 같은가?
            // ex) 최단 루트에서 다른 곳을 갔다가 돌아올 경우에는 짝수 번이 필요. 즉, 두 거리의 홀짝이 다르다면 돌아오는게 불가능.
                    if(d % 2 == targetD % 2) {
                        if(!dfs(nextP, distance(nextP, target), temp + way[i], cnt + 1).equals("impossible")) {
                            return result;                        
                        }
                    }
                }
            }
        }
        
        return "impossible";
    }
}
