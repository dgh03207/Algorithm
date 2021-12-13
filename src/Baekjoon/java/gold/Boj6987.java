package Baekjoon.java.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

//월드컵
public class Boj6987 {
	static boolean flag;
	static int win[],lose[],draw[],match[][],w,l,d;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		match = new int[15][2];
		int idx = 0;
		for (int i = 0; i < 5; i++) {
			for (int j = i+1; j < 6; j++) {
				match[idx][0] = i;
				match[idx][1] = j;
				idx++;
			}
		}
		
		for (int T = 0; T < 4; T++) {
			st = new StringTokenizer(br.readLine());
			win = new int[6];
			lose = new int[6];
			draw = new int[6];
			flag = false;
			w=0;
			l=0;
			d=0;
			
			for (int i = 0; i < 6; i++) {
				w+= win[i] = Integer.parseInt(st.nextToken());
				d+= draw[i] = Integer.parseInt(st.nextToken());
				l+= lose[i] = Integer.parseInt(st.nextToken());
			}
			if(w+d+l!=30) flag = false;
			else dfs(0);
			
			if(flag) sb.append(1+" ");
			else sb.append(0+" ");
			
		}
		System.out.println(sb.toString());
	}
	
	private static void dfs(int cnt) {
		if(flag) return;
		if(cnt==15) {
			flag = true;
			return;
		}
		
		int a = match[cnt][0];
		int b = match[cnt][1];
		
		if(win[a]>0 && lose[b]>0) {
			win[a]--;
			lose[b]--;
			dfs(cnt+1);
			win[a]++;
			lose[b]++;
		}
		if(draw[a]>0 && draw[b]>0) {
			draw[a]--;
			draw[b]--;
			dfs(cnt+1);
			draw[a]++;
			draw[b]++;
		}
		if(lose[a]>0 && win[b]>0) {
			lose[a]--;
			win[b]--;
			dfs(cnt+1);
			lose[a]++;
			win[b]++;
		}
		
		
	}

}
