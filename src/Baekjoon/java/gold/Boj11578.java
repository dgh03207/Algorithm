package Baekjoon.java.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

//팀원 모집
public class Boj11578 {
	
	static int N,M;
	static Map<Integer,int[]> map = new HashMap<>();
	static boolean[] isSelected;
	static int result = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//문제의 수
		N = Integer.parseInt(st.nextToken());
		//고를 수 있는 학생들의 수
		M = Integer.parseInt(st.nextToken());
		
		isSelected = new boolean[M];
		
		map = new HashMap<>();
		
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int prob = Integer.parseInt(st.nextToken());
			int[] probs = new int[prob];
			for (int j = 0; j < prob; j++) {
				int n = Integer.parseInt(st.nextToken());
				probs[j] = n;
			}
			map.put(i, probs);
			
		}
		getTeam(0);
		System.out.println(result);
	}
	
	private static void getTeam(int cnt) {
		
		if(cnt==M) {
			List<Integer> check = new ArrayList<>();
			int result_cnt = 0;
			for (int i = 0; i < M; i++) {
				if(isSelected[i]) {
					result_cnt++;
					int[] problems = map.get(i);
					for (int j = 0; j < problems.length; j++) {
						if(!check.contains(problems[j])) {
							check.add(problems[j]);
						}
					}
				}
			}
			if(check.size()==N) {
				if(result_cnt<result) result = result_cnt;
			}
		}
		
		isSelected[cnt] = true;
		getTeam(cnt+1);
		isSelected[cnt+1] = false;
		getTeam(cnt+1);
		
	}

}
