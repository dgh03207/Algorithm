package Baekjoon.java.gold;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B4485 {
	
	static int N, map[][],cost[][];
	static boolean[][] visited;
	static int[] dr = {0,1,0,-1};
	static int[] dc = {1,0,-1,0};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		
		int cnt = 1;
		
		while(true) {
			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			if(N==0) break;
			
			map = new int[N][N];
			sb.append("Problem "+(cnt++)+": ");
			cost = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
				Arrays.fill(cost[i], Integer.MAX_VALUE);
			}
			
			dij();
			sb.append(cost[N-1][N-1]+"\n");
		}
		
		System.out.println(sb.toString());
	
	}
	
	private static boolean isRange(int x, int y) {
		return x>=0 && x<N && y>=0 && y<N;
	}
	
	private static void dij() {
		PriorityQueue<Edge> queue = new PriorityQueue<Edge>();
		cost[0][0] = map[0][0];
		
		queue.add(new Edge(0,0,cost[0][0]));
		
		while(!queue.isEmpty()) {
			Edge now = queue.poll();
			
			for (int i = 0; i < 4; i++) {
				int nx = now.x+dc[i];
				int ny = now.y+dr[i];
				
				if(isRange(nx,ny)) {
					if(cost[ny][nx] > cost[now.y][now.x]+map[ny][nx]) {
						cost[ny][nx] = cost[now.y][now.x]+map[ny][nx];
						queue.add(new Edge(nx,ny,cost[ny][nx]));
					}
				}
			}
		}
	
	}
	
	static class Edge implements Comparable<Edge>{
		int x;
		int y;
		int w;

		public Edge(int x, int y, int w) {
			super();
			this.x = x;
			this.y = y;
			this.w = w;
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return this.w-o.w;
		}
		
	}
	
}
