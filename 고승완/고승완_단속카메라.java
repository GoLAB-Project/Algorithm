import java.util.*;

class Solution {
	static LinkedList<Inout> highway = new LinkedList<>();

	public int solution(int[][] routes) {
		int answer = 1;

		for(int[] route : routes)
			highway.add(new Inout(route[0], route[1]));
		Collections.sort(highway);

		int camera = highway.poll().o;
		for(Inout route : highway) {
			if (camera >= route.i) continue;
			++answer;
			camera = route.o;
		}

		return answer;
	}
}

class Inout implements Comparable<Inout> {
	int i;
	int o;

	public Inout(int i, int o) {
		this.i = i;
		this.o = o;
	}

	@Override
	public int compareTo(Inout o) {
		if (this.o == o.o)
			return this.i - o.i;
		return this.o - o.o;
	}
}