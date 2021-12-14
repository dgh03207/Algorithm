package Baekjoon.java.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//진우의 민트초코우유
public class boj20208 {
	
	static int N,M,H,map[][],result,house[];
	static List<int[]> milks = new ArrayList<>();
	static boolean check_milk[];
	static int[] dr = {0,0,-1,1};		
	static int[] dc = {1,-1,0,0};
	static boolean isvisit[][];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
	
		isvisit = new boolean[N][N];
		map = new int[N][N];
		house = new int[2];
		result = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j]==1) house = new int[] {i,j};
				else if (map[i][j]==2) milks.add(new int[] {i,j});
			}
		}
		
		check_milk = new boolean[milks.size()];
		getMilk(house,0,M);
		
		System.out.println(result);
		
	}
	
	private static void getMilk(int[] prev,int n,int energy) {
		
		int tohome = Math.abs(prev[0]-house[0])+Math.abs(prev[1]-house[1]);
		
		if(prev!=house && tohome<=energy) {
			int cnt = 0;
			for (int i = 0; i < check_milk.length; i++) {
				if(check_milk[i]) {
					cnt+=1;
				}
			}
			if(result<cnt) {
				result = cnt;
			}
		}
		
		for (int i = 0; i < milks.size(); i++) {
			int[] now = milks.get(i);
			int distance = Math.abs(now[0]-prev[0])+Math.abs(now[1]-prev[1]);
			
			if(check_milk[i]) continue;
			
			if(energy >= distance) {
				check_milk[i] = true;
				energy += H-distance;
				getMilk(now,i,energy);
				energy -= H-distance;
				check_milk[i] = false;
			}
			
		}
		
	}
	
}
