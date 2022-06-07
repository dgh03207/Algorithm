package Baekjoon.java.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;

public class boj1342 {
    static int N;
    static int answer;
    static int[] chars;
    static List<String> answers;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] S = br.readLine().toCharArray();
        N = S.length;
        chars = new int[26];
        answers = new ArrayList<>();
        for (int i = 0; i < S.length; i++) {
            chars[S[i]-'a']+=1;
        }

        dfs(0,"");
        System.out.println(answer);
    }
    private static void dfs(int cnt,String result){
        if(cnt==N){
            answer+=1;
            return;
        }

        for (int i = 0; i < 26; i++) {
            if(chars[i]==0) continue;
            if(result!=""&&result.charAt(cnt-1)==(char)('a'+i)) continue;

            chars[i]-=1;
            dfs(cnt+1,result+(char)(i+'a'));
            chars[i]+=1;
        }
    }

}
