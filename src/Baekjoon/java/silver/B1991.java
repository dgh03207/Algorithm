package Baekjoon.java.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

//트리순회

//참고 사이트  : https://geehye.github.io/baekjoon-1991/#
public class B1991 {
	static StringBuilder sb = new StringBuilder();

	static Map<String, List<String>> map = new HashMap<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			String[] tmp = br.readLine().split(" ");
			List<String> list = new ArrayList<>();

			list.add(tmp[1]);
			list.add(tmp[2]);
			map.put(tmp[0], list);
		}

		preorder("A");
		sb.append("\n");
		inorder("A");
		sb.append("\n");
		postorder("A");
		
		System.out.println(sb.toString());
	}

	private static void preorder(String v) {
		if (v.equals("."))
			return;

		sb.append(v);
		preorder(map.get(v).get(0));
		preorder(map.get(v).get(1));
	}

	private static void inorder(String v) {
		if (v.equals("."))
			return;

		inorder(map.get(v).get(0));
		sb.append(v);
		inorder(map.get(v).get(1));

	}

	private static void postorder(String v) {
		if (v.equals("."))
			return;

		postorder(map.get(v).get(0));
		postorder(map.get(v).get(1));
		sb.append(v);
	}

}
