import java.util.*;

class camera implements Comparable<camera> {
    int start;
    int end;
    
    public camera(int start, int end) {
        this.start = start;
        this.end = end;
    }
    
    public int compareTo(camera o){
        return this.end - o.end;
    }
}

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        
        ArrayList<camera> arrList = new ArrayList<>();
        for(int car[]:routes){
            camera c = new camera(car[0],car[1]);
            arrList.add(c);
        }
        Collections.sort(arrList);
        
        int nowIndex = -30001;
        for(int i=0; i<arrList.size(); i++) {
            camera next = arrList.get(i);
            if(nowIndex<next.start){
                nowIndex = next.end;
                answer++;
            }
        }
        return answer;
    }
}
