package Baekjoon.java.gold;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1922 {
	static int N,M,result;
	static Edge[] edgeList;
	static class Edge implements Comparable<Edge>{
		int start,end,weight;

		public Edge(int start, int end, int weight) {
			super();
			this.start = start;
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return this.weight-o.weight;
		}
		
		
		
	}
	

	static int[] parents;
	
	private static void make() {
		for (int i = 0; i < N; i++) {
			parents[i] = i;
		}
	}
	
	private static int find(int a) {
		if(parents[a]==a) return a;
		return parents[a] = find(parents[a]);
	}
	
	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot==bRoot) return false;
		
		parents[bRoot] = aRoot;
		
		return true;
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(br.readLine());
		parents = new int[N];
		edgeList = new Edge[M];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a= Integer.parseInt(st.nextToken())-1;
			int b= Integer.parseInt(st.nextToken())-1;
			int w= Integer.parseInt(st.nextToken());
			
			edgeList[i] = new Edge(a,b,w);
		
		}
		
		Arrays.sort(edgeList);
		
		make();
		
		int cnt = 0;
		
		for (Edge edge : edgeList) {
			if(union(edge.start,edge.end)) {
				result+= edge.weight;
				if(++cnt==N-1) break;
			}
		}
		System.out.println(result);
	}
}
