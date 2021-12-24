package Baekjoon.java.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

//좌표 압축
public class boj18870 {

	public static void main(String[] args) throws Exception{
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] sorted = new int[N];
		int[] example = new int[N];
		Map<Integer,Integer> map = new TreeMap<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(st.nextToken());
			sorted[i] = n;
		}
		example = sorted.clone();
		Arrays.sort(sorted);
		
		int idx = 0;
		for (int i = 0; i < N; i++) {
			if(!map.containsKey(sorted[i])) {
				map.put(sorted[i],idx++);
			}
		}
		
		for (int i = 0; i < N; i++) {
			sb.append(map.get(example[i])+" ");
		}
		System.out.println(sb.toString());
	}
}
