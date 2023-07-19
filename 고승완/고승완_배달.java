/**
 * 푼 시간: 20~30분
 * 시도: 1회
 * 
 * 인터넷 검색: 레퍼런스 보고 싶었는데 지원을 안해서 Integer.max_value, 2중 ArrayList 검색 해봄
 * 아쉬운 점: (a->b)와 (b->a)로 주어지는 중?복 길에 대한 처리를 일단 넣고 '가중치 기반 정렬'로 처리함. 여기서 최적화를 할 수 있을 것 같다.
 */
import java.util.*;

class Solution {
    public static final int INF = 1000000001;
    public static int[] dist;
    public static ArrayList<Edge>[] graph;
    
    public static void dijkstra(int start) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(start, 0));
        dist[start] = 0;
        
         while(!pq.isEmpty()) {
             int s = pq.peek().dest;
             int w = pq.poll().weight;
             
             if(dist[s] < w) continue;
             
             for(Edge next : graph[s]) {
                 int e = next.dest;
                 int nw = w + next.weight;
                 
                 if(dist[e] < nw) continue;
                 dist[e] = nw;
                 pq.add(new Edge(e, nw));
             }
         }
    }
    
    public int solution(int N, int[][] road, int K) {
        // 초기화
        dist = new int[N + 1];
        graph = new ArrayList[N + 1];
        Arrays.fill(dist, INF);
        for(int i = 0; i <= N; ++i)
            graph[i] = new ArrayList<>();
        
        // road -> graph
        for(var r : road) {
            int s = r[0];
            int e = r[1];
            int w = r[2];
            
            graph[s].add(new Edge(e, w));
            graph[e].add(new Edge(s, w));
        }
        
        // 인접그래프 정렬
        for(int i = 1; i <= N; ++i)
            Collections.sort(graph[i]);   
        
        // 다익스트라
        dijkstra(1);
        
        // 출력
        int answer = 0;
        for(int i = 1; i <= N; ++i)
            if(dist[i] <= K) ++answer;
        return answer;
    }
    
    public static class Edge implements Comparable<Edge> {
        int dest;
        int weight;
        
        public Edge(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }
        
        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }
}