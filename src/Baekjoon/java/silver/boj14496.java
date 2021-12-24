package Baekjoon.java.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//그대,그머가 되어
public class boj14496 {
	static class Node implements Comparable<Node>{
		int n;
		int distance;
		
		
		public Node(int n) {
			this.n = n;
			this.distance =Integer.MAX_VALUE;
		}


		public Node(int n, int distance) {
			this.n = n;
			this.distance = distance;
		}

		@Override
		public int compareTo(Node o) {
			return this.distance-o.distance;
		}
		
	}
	
	static int N,M,start,connect[][],end,answer;
	static Node[] words;
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		start = Integer.parseInt(st.nextToken())-1;
		end = Integer.parseInt(st.nextToken())-1;
		
		answer = Integer.MAX_VALUE;
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		connect = new int[N][N];
		words = new Node[N];
		
		for (int i = 0; i < N; i++) {
			words[i] = new Node(i);
			Arrays.fill(connect[i], -1);
		}
		
		words[start].distance = 0;
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			connect[a][b] = 1;
			connect[b][a] = 1;
		}
		
		bfs(words[start]);
		if(answer>N) System.out.println(-1);
		else System.out.println(answer);
	}
	
	
	public static void bfs(Node start) {
		
		PriorityQueue<Node> queue = new PriorityQueue<>();
		
		queue.add(start);
		
		while(!queue.isEmpty()) {
			Node now = queue.poll();
			
			if(now.n==end) {
				if(now.distance<answer) answer = now.distance;
				continue;
			}
			
			for (int i = 0; i < N; i++) {
				if(now.n!=i && connect[now.n][i]>0 &&words[i].distance>now.distance+1) {
					words[i].distance=now.distance+1;
					queue.add(words[i]);
				}
			}
			
		}
	}
}
