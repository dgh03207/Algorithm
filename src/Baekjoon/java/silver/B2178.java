package Baekjoon.java.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2178 {
	static int map[][],N,M,visited[][];
	static int[] dr = {1,0,-1,0};
	static int[] dc = {0,1,0,-1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new int[N][M];
		for (int i = 0; i < N; i++) {
			String[] templist = br.readLine().split("");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(templist[j]);
			}
		}
		
		bfs();
		System.out.println(map[N-1][M-1]);
		
	}
	private static boolean isRange(int x, int y) {
		return x>=0&&x<M&&y>=0&&y<N;
	}
	
	private static void bfs() {
		Queue<int[]> queue = new LinkedList<>();
		int[] start = {0,0};
		
		queue.add(start);
		visited[start[1]][start[0]] = 1;
		
		while(!queue.isEmpty()) {
			int[] curr = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nx = curr[0]+dr[i];
				int ny = curr[1]+dc[i];
				if(isRange(nx,ny)&&map[ny][nx]!=0&&visited[ny][nx]==0) {
					queue.add(new int[] {nx,ny});
					visited[ny][nx] =1;
					map[ny][nx] = map[curr[1]][curr[0]] + 1;
					if(ny==N&&nx==M) return;
				}
				
			}
		}
	}
	
	private static void print() {
		for (int i = 0; i < N; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
	}
}
