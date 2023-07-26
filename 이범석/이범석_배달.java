import java.util.ArrayList;
import java.util.PriorityQueue;
	
	class pair implements Comparable<pair>{
		int end;
		int weight;
		public pair(int end, int weight) {
			this.end = end;
			this.weight = weight;
		}
		
		public int compareTo(pair o) {
			return this.weight-o.weight;
		}
	}
	
	class Solution {
	    public int solution(int N, int[][] road, int K) {
	        int answer = 0;
            
          final int INF = 500002;
	        
	        int[] cost = new int[N];
	        for(int i=0; i<N; i++){
	            cost[i] = INF;
	        }
	        cost[0] = 0;
	        
	        ArrayList<pair> arrList[] = new ArrayList[N];
	        for(int i=0; i<N; i++) {
	        	arrList[i] = new ArrayList<>();
	        }
	        
	        for(int i=0; i<road.length; i++) {
	        	arrList[road[i][1]-1].add(new pair(road[i][0]-1,road[i][2]));
	          arrList[road[i][0]-1].add(new pair(road[i][1]-1,road[i][2]));
	        }
	        
	        PriorityQueue<pair> pq = new PriorityQueue<>();
	        pq.add(new pair(0, 0));
	        while(!pq.isEmpty()) {
	        	pair current = pq.poll();
	        	if(current.weight>cost[current.end]) continue;
            
	        	for(int i=0; i<arrList[current.end].size(); i++) {
	        		pair next = arrList[current.end].get(i);
	        		if(cost[next.end]>current.weight+next.weight) {
	        			cost[next.end] = current.weight + next.weight;
	        			pq.add(new pair(next.end, cost[next.end]));
	        		}
	        	}
	        }
	        for(int i=0; i<N; i++){
	            if(cost[i] <= K) answer++;
	        }
	        return answer;
	    }
	}
