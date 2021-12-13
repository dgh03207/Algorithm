package Baekjoon.java.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class B19699 {
	static int N,M,cows[],selected[];
	static StringBuilder sb = new StringBuilder();
	static boolean check;
	static String ans="";
	static ArrayList<Integer> answer = new ArrayList<>();
	public static void main(String[] args) throws Exception{
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		cows = new int[N];
		selected = new int[M];
		
		
		st =new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			cows[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(cows);
		combi(0,0);
		Collections.sort(answer);
		
		if(!check) sb.append(-1);
		else {
			for (int i = 0; i < answer.size(); i++) {
				sb.append(answer.get(i)+" ");
			}
		}
		System.out.println(sb.toString());
	}
	
	private static void combi(int start, int cnt) {
		if(cnt==M) {
			int sum = Arrays.stream(selected).sum();
			if(ans.length()>0 &&ans.contains(Integer.toString(sum))) return;
			else	
				isprime(sum);
			return;
		}
		
		for (int i = start; i < N; i++) {
			selected[cnt] = cows[i];
			combi(i+1,cnt+1);
		}
		
	}
	
	private static boolean isprime(int sum) {
		for (int i = 2; i*i<=sum; i++) {
			if(sum%i==0) return false;
		}
		ans += sum+" ";
		answer.add(sum);
		check = true;
		return true;
	}
}
