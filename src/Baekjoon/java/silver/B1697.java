package Baekjoon.java.silver;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1697 {
	static int posX,posT,time;
	static int[] visited;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		posX = Integer.parseInt(st.nextToken());
		posT = Integer.parseInt(st.nextToken());
		visited = new int[100001];
		bfs();
		System.out.println(visited[posT]-1);
	}
	
	private static void bfs() {
		Queue<Integer> queue = new LinkedList<>();
		
		queue.add(posX);
		visited[posX] = 1;
		
		while(!queue.isEmpty()) {
			int now = queue.poll();
			
			if(now==posT) return;
			
			if(now*2 <= 100000 && visited[now*2]==0) {
				queue.add(now*2);
				visited[now*2] = visited[now]+1;
			}
			if(now+1 <= 100000 && visited[now+1]==0) {
				queue.add(now+1);
				visited[now+1] = visited[now]+1;
			}
			if(now-1 >= 0 && visited[now-1]==0) {
				queue.add(now-1);
				visited[now-1] = visited[now]+1;
			}
		}
	
	}
}
