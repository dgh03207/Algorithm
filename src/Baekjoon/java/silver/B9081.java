package Baekjoon.java.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B9081 {
	static int N;
	static char[] words;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			String input = br.readLine();
			words = input.toCharArray();
			N = words.length;
			int t_idx = -1;
			int prev = words[N-1];
			for (int j = N-2; j >=0; j--) {
				int now = words[j];
				if(prev > now) {
					t_idx = j;
					break;
				}
				prev = now;
			}
			System.out.println(t_idx);
			if(t_idx==-1) {
				sb.append(input);
			}else {
				int min = Integer.MAX_VALUE;
				int idx = N-1;
				
				for (int j = t_idx+1; j < N; j++) {
					if(words[i] >words[t_idx]&&words[j]-words[t_idx] < min) {
						min = words[j]-words[t_idx];
						idx = j;
					}
				}
				char temp = words[t_idx];
				words[t_idx] = words[idx];
				words[idx] = temp;
				char[] t_arr = new char[N-t_idx-1];
				int t = 0;
				for (int j = t_idx+1; j < N; j++) {
					t_arr[t++] = words[j];
				}
				Arrays.sort(t_arr);
				System.out.println(Arrays.toString(words));
				t = 0;
				for (int j = 0; j < N; j++) {
					if(j>=t_idx) {
						sb.append(words[j]);
					}else {
						sb.append(t_arr[t]);
						t++;
					}
				}
				sb.append("\n");
			}
			System.out.println(sb.toString());
			
		}
	}
	
}
