import java.util.*;

class Solution {
    
    static int[] dy={1,0,0,-1}; 
    static int[] dx = {0,-1,1,0};
    static String[] direction={"d","l","r","u"}; //하 좌 우 상
    static int N, M, K;
    static String tempAnswer="";
    static int endX,endY;
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        String answer;
        N = n;
        M = m;
        K = k;
        endX=r-1;endY=c-1;
        
        dfs(y-1, x-1, K,"", dist(y-1,x-1));

        if(tempAnswer.equals(""))
            answer = "impossible";
        else
            answer = tempAnswer;
        return answer;
    }
    
    public static boolean dfs(int y, int x, int step, String tempString, int leftDist){
        if(step == 0 && leftDist==0) {
            tempAnswer = tempString;
            return true;
        }
        
        for(int i=0;i<4;i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(nx>=0&&ny>=0&&nx<M&&ny<N&&leftDist<=step){
                if(leftDist %2 == step %2) 
                    if(dfs(ny,nx,step-1,tempString+direction[i], dist(ny, nx)))
                        return true;
            }
        }
        return false;
    }
    
    public static int dist(int y, int x){
        return Math.abs(endY-y)+Math.abs(endX-x);
    }
}

