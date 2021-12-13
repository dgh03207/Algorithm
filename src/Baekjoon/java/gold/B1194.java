package Baekjoon.java.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1194 {
	
	static int N,M,move[][],start[];
	static char[][] maze;
	static boolean[] keys = new boolean[25];
	static boolean key = false;
	static int[] dr = {0,1,0,-1};
	static int[] dc = {1,0,-1,0};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		move = new int[N][M];
		start = new int[2];
		for (int i = 0; i < N; i++) {
			int j = 0;
			for (String s : br.readLine().split("")) {
				maze[i][j++] = s.charAt(0);
				if(s.equals(0)) {
					start[0] = j;
					start[1] = i;
				}
			}
		}
		
		
	}
	private static boolean isRange(int x, int y) {
		return x>=0 && x<M && y>=0 && y<N;
	}
	private static void bfs() {
		
		Queue<int[]> queue = new LinkedList<>();
		queue.add(start);
		
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			
			for (int i = 0; i < 4; i++) {
				int nx = now[0]+dc[i];
				int ny = now[1]+dr[i];
				
				if(isRange(nx,ny)) {
					if(maze[ny][nx]=='#') continue;
					
					if((int)maze[ny][nx]>=97&&(int)maze[ny][nx]<=122) {
						int key = (int)maze[ny][nx]-97;
						keys[key] = true;
						
					}
				}
			}
		}
		
	}
}
