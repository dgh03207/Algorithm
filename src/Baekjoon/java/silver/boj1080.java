package Baekjoon.java.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj1080 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int answer = 0;
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean[][] matrix2 = new boolean[N][M];
        boolean[][] matrix1 = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String[] temp = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                if (temp[j].equals("1")) matrix1[i][j] = true;
            }
        }
        for (int i = 0; i < N; i++) {
            String[] temp = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                if (temp[j].equals("1")) matrix2[i][j] = true;
            }
        }

        if(N>=3 && M>=3) {
            for (int t = 0; t < N-2; t++) {
                for (int k = 0; k < M-2; k++) {
                    if (matrix1[t][k] != matrix2[t][k]) {
                        for (int i = t; i < t + 3; i++) {
                            for (int j = k; j < k + 3; j++) {
                                if(matrix1[i][j]) matrix1[i][j] = false;
                                else matrix1[i][j] = true;
                            }
                        }
                        answer +=1;
                    }
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(matrix1[i][j] != matrix2[i][j]){
                    answer = -1;
                }
            }
        }
        System.out.println(answer);

    }
}
