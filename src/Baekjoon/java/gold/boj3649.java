package Baekjoon.java.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj3649 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String x;
        while((x=br.readLine())!=null) {
            int X = Integer.parseInt(x) * 10000000;
            int N = Integer.parseInt(br.readLine());
            int[] lego = new int[N];
            int answer = -1;
            int l1 = -1;
            int l2 = -1;
            for (int i = 0; i < N; i++) {
                lego[i] = Integer.parseInt(br.readLine());
            }
            Arrays.sort(lego);
            for (int i = 0; i < N; i++) {
                int now = lego[i];
                int left = i;
                int right = N - 1;
                while (left <= right) {
                    int mid = (left + right) / 2;
                    if (mid != i) {
                        if (lego[mid] == X - now) {
                            if (answer < Math.abs(now - lego[mid])) {
                                answer = Math.abs(now - lego[mid]);
                                l2 = Math.max(now, lego[mid]);
                                l1 = Math.min(now, lego[mid]);
                            }
                            left = mid + 1;
                        } else if (lego[mid] > X - now) {
                            right = mid - 1;
                        } else if (lego[mid] < X - now) {
                            left = mid + 1;
                        }
                    } else {
                        left = mid + 1;
                    }
                }
            }
            if (answer != -1) {
                sb.append("yes ").append(l1).append(" ").append(l2);
            } else {
                sb.append("danger");
            }
            System.out.println(sb.toString());
            sb.setLength(0);
        }
    }
}
