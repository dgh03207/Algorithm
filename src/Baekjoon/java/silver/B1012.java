package Baekjoon.java.silver;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//유기농 배추
public class B1012 {
	static int T,N,M,K,map[][],answer;
	static boolean[][] visit;
	static Queue<int[]> queue = new LinkedList<>();
	static int[] dr = {0,-1,0,1};
	static int[] dc = {1,0,-1,0};
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			int answer = 0;
			map = new int[N][M];
			visit = new boolean[N][M];
			int [] start = new int[2];
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				map[r][c] = 1;
				queue.add(new int[] {r,c});
			}

			while(!queue.isEmpty()) {
				start = queue.poll();
				if(!visit[start[0]][start[1]]) {
					check(start);
					answer++;
				}
			}
			sb.append(answer+"\n");
		}
		System.out.println(sb.toString());
	}
	
	private static boolean isRange(int r, int c) {
		return r>=0&&r<N&&c>=0&&c<M;
	}
	
	private static void check(int[] now) {
	
		visit[now[0]][now[1]] = true;
		
		for (int i = 0; i < 4; i++) {
			int nr = now[0]+dr[i];
			int nc = now[1]+dc[i];
			
			if(isRange(nr,nc)&&!visit[nr][nc]) {
				if(map[nr][nc]==1) {
					check(new int[] {nr,nc});
				}
			}
		}
		
	}
	
}
