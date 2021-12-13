package Baekjoon.java.silver;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B13265 {

	static Queue<Integer> queue;
	static ArrayList<ArrayList<Integer>> graph;
	static int N, M, color[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(st.nextToken());
		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			graph = new ArrayList<>();
			color = new int[N + 1];
			queue = new LinkedList<>();
			// 인접리스트 초기화
			for (int i = 0; i <= N; i++) {
				graph.add(new ArrayList<>());
			}
			int start = 0;
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int n1 = Integer.parseInt(st.nextToken()) - 1;
				int n2 = Integer.parseInt(st.nextToken()) - 1;
				graph.get(n1).add(n2);
				graph.get(n2).add(n1);
				if(start==0) start = n1;
			}

			queue.add(start);
			color[start]=1;
			if (bfs())
				sb.append("possible\n");
			else
				sb.append("impossible\n");
		}

		System.out.println(sb.toString());

	}

	private static boolean bfs() {
		

		while (!queue.isEmpty()) {
			int now = queue.poll();
			
			for (int i : graph.get(now)) {
				if (color[i] == 0 & now != i) {
					if (color[now] == 1)
						color[i] = 2;
					else if (color[now] == 2)
						color[i] = 1;
					queue.add(i);
				}else if(color[i]==color[now]) return false;
			}
		}

		return true;
	}

}
