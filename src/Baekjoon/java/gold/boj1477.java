package Baekjoon.java.gold;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj1477 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        if(N==0){
            System.out.println(((int)Math.ceil(L/(double)(M+1))));
        }else {
            int[] stores = new int[N + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                stores[i] = Integer.parseInt(st.nextToken());
            }
            stores[N] = L;
            Arrays.sort(stores);
            int answer = Integer.MAX_VALUE;
            int left = 1;
            int right = L;

            while (left <= right) {
                int mid = (left + right) / 2;
                int prev = 0;
                int add = 0;
                for (int i = 0; i <= N; i++) {
                    if (add > M) break;
                    if (stores[i] - prev > mid) {
                        int poss = (int) Math.ceil((stores[i] - prev) / (double) mid) - 1;
                        add += poss;
                    }
                    prev = stores[i];
                }
                if (add == 0) {
                    answer = Math.min(answer, mid);
                    right = mid - 1;
                } else if (add < 0) {
                    left = mid + 1;
                } else if (add > 0) {
                    right = mid - 1;
                }
            }
            System.out.println(answer);
        }

    }

}
