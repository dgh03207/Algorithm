package Baekjoon.java.silver;
import java.util.Arrays;
import java.util.Scanner;

public class B1065 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int target = sc.nextInt();
		int answer = 0;
		for (int num = 1; num <= target; num++) {
			if(num<10) answer++;
			else if(check(num)) {
				answer++;
			}
		}
		System.out.println(answer);
	}
	
	static boolean check(int num) {
		String[] target = Integer.toString(num).split("");
		int prev = Integer.parseInt(target[0]);
		int term = Integer.parseInt(target[1])-prev;
		for (int i = 1; i < target.length; i++) {
			int now = Integer.parseInt(target[i]);
			if(now-prev!=term) {
				return false;
			}
			prev=now;
		}
		
		return true;
	}

}
