import javax.net.ssl.SNIHostName;
import java.util.Scanner;

/**
 * @author promise
 * @date 2020/9/13 - 21:20
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        String text1 = "cat";
        String text2 = "pig";
        String text3 = "horse";

        if(longestCommonSubsequence(text1,str)>1){
            System.out.println(text1);
        }
        if(longestCommonSubsequence(text2,str)>1){
            System.out.println(text2);
        }
        if(longestCommonSubsequence(text3,str)>1){
            System.out.println(text3);
        }


    }

    public static int longestCommonSubsequence(String text1, String text2) {
        if(text1 == null || text2 == null) return 0;
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        for(int i = 1;i <= m;i++) {
            for(int j = 1;j <= n;j++) {
                if(text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }
}
