package Baekjoon.java.silver;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B13565 {
	
	static int M,N;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = {0,1,0,-1};
	static int[] dc = {1,0,-1,0};
	static Queue<Node> queue = new LinkedList<>();
	
	static class Node {
		int x;
		int y;
		
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[M][N];
		visited = new boolean[M][N];
		Node start = new Node(0,0);
		for (int i = 0; i < M; i++) {
			String[] inputs = br.readLine().split("");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(inputs[j]);
				if(i==0 && map[i][j] == 0) queue.add(new Node(j,i));
			}
		}
		
  		if(bfs()) System.out.println("YES");
  		else System.out.println("NO");
	}
	
	private static boolean isRange(int x, int y) {
		return x>=0 && x<N && y>=0 && y<M;
	}
	
	private static boolean bfs() {
		while(!queue.isEmpty()) {
			Node now = queue.poll();
			if(now.y==M-1&&map[now.y][now.x]==0) return true;
			
			for (int i = 0; i < 4; i++) {
				int nx = now.x+dc[i];
				int ny = now.y+dr[i];
				
				if(isRange(nx,ny)&&!visited[ny][nx]) {
					if(map[ny][nx]==0) {
						visited[ny][nx]=true;
						queue.add(new Node(nx,ny));
					}
					
				}
			}
		}
		return false;
	}
	
	
}
