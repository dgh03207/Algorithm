package Baekjoon.java.silver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//로마 숫자 만들기
public class Boj16922 {

	static int[] target = {1,5,10,50};
	static int N=0;
	static String[] result;
	static List<Integer> numbers = new ArrayList<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		result =new String[N];
		Combi(0,0,0);
		System.out.println(numbers.size());
	}
	
	private static void Combi(int a,int start,int n) {
		
		if(a==N) {
			if(!numbers.contains(n)) {
				numbers.add(n);
			}
			return;
		}
		
		for (int i = start; i < 4; i++) {
			Combi(a+1,i,n+target[i]);
		}
	}
}
