package Baekjoon.java.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

//가르침
public class boj1062 {
	static int N,K,answer;
	static String[] words;
	static boolean[] alphabets = new boolean[26];
	static ArrayList<Character> candidate = new ArrayList<>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		answer = 0;
		alphabets['a'-97] = true;
		alphabets['n'-97] = true;
		alphabets['t'-97] = true;
		alphabets['i'-97] = true;
		alphabets['c'-97] = true;
		
		if(K>=5) {
			words = new String[N];
			
			for (int i = 0; i < N; i++) {
				String line = br.readLine();
				words[i] = line.substring(4,line.length()-4);
				for (int j = 0; j < words[i].length(); j++) {
					char cand = words[i].charAt(j);
					if(!candidate.contains(cand)&&!alphabets[cand-97]) {
						candidate.add(cand);
					}
				}
			}
			

			if(candidate.size()+5<K) K = 5+candidate.size();
			solve(5,0);
			System.out.println(answer);
		}else {
			System.out.println(0);
		}
	}
	
	private static void solve(int cnt,int start) {
		if(cnt==K) {
			int match = 0;
			for (String word : words) {
				boolean flag = true;
				
				if(word.length()>0) {
					
					for (int i = 0; i < word.length(); i++) {
						if(!alphabets[word.charAt(i)-97]) {
							flag = false;
							break;
						}
					}
				}
				if(flag) match++;
			}
			if(answer < match) answer = match;
			return;
		}
		
		for (int i = start; i < candidate.size(); i++) {
			int now = candidate.get(i)-97;
			if(!alphabets[now]) {
				alphabets[now] = true;
				solve(cnt+1,i+1);
				alphabets[now] = false;
			}
		}
	}
}
