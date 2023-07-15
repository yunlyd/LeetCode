package com.llllz.leetcode001_010.leetcode006;

/**
 * @create 2023-07-15-10:34
 * 使用一个二维布尔数组 dp，其中 f[i][j] 表示字符串 s 的前 i 个字符和正则表达式 p 的前 j 个字符是否匹配。
 */
public class Solution_1 {
    public boolean isMatch(String s, String p) {
        char[] cs = s.toCharArray();
        char[] cp = p.toCharArray();

        // dp[i][j]:表示s的前i个字符，p的前j个字符是否能够匹配
        boolean[][] dp = new boolean[cs.length + 1][cp.length + 1];

        // 初期值
        // s为空，p为空，能匹配上
        dp[0][0] = true;
        // p为空，s不为空，必为false(boolean数组默认值为false，无需处理)

        // s为空，p不为空，由于*可以匹配0个字符，所以有可能为true
        for (int j = 1; j <= cp.length; j++) {
            if (cp[j - 1] == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }

        // 填格子
        for (int i = 1; i <= cs.length; i++) {
            for (int j = 1; j <= cp.length; j++) {
                // 文本串和模式串末位字符能匹配上
                if (cs[i - 1] == cp[j - 1] || cp[j - 1] == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                // 模式串末位是*
                else if (cp[j - 1] == '*') {
                    // 模式串*的前一个字符能够跟文本串的末位匹配上
                    if (cs[i - 1] == cp[j - 2] || cp[j - 2] == '.') {
                        dp[i][j] = dp[i][j - 2]      // *匹配0次的情况
                                || dp[i - 1][j];     // *匹配1次或多次的情况
                    }
                    // 模式串*的前一个字符不能够跟文本串的末位匹配
                    else {
                        dp[i][j] = dp[i][j - 2];     // *只能匹配0次
                    }
                }
            }
        }
        return dp[cs.length][cp.length];
    }
}
/**
 * a1-例子：s="aab", p="aabb*", 干掉“b*”，p' = "aab" == s；所以，干掉“b*”，相当于*让第2个b重复0次（即抹掉了第二个b），
 * 属于a1情况，这种情况就是，不看p串的末尾两个，就看p(0,j-3)与s(0,i-1)是否相同，相同就是true。
 * 此种情况下，推导公式为：dp(i)(j) = dp(i)(j-2)
 *
 * a2-例子：s="aab",p="aab*"，p(j-1)="*",p(j-2)==s(i-1)=b，*使得b重复1次，属于a2描述情况。此种情况，有两种方法：
 * <1> 仅干掉p串末尾的“*”，看p(0,j-2)与s(0,i-1)是否相同，此时，推导公式为：dp(i)(j) = dp(i)(j-1)；
 *
 * <2> 已知p末尾的*重复它前一个字符去匹配了s串末尾的一个字符。所以，可以同时干掉p串末尾两个字符和s末尾1个字符，
 * 看剩下的p(0,j-3)与s(0,j-2)是否相同。此时，推导公式为：dp(i)(j) = dp(i-1)(j-2);
 *
 * 【注】所以，网上的题解会看到两种状态转移的公式，其实分析明白了，两种都可以得到正确的解（都是一样的）。本文选择的是第2种方法的推导公式，即dp(i)(j) = dp(i-1)(j-2)
 *
 * a3-例子: s="aabb"（或s="aabbb"都行）,p="aab*"。不难看出，p末尾的*使得b重复了2次（或3次），符合情况a3。
 * 这种情况，已知s(i-1)=p(j-2)，*使得p(j-2)这个字符重复1次匹配了s(i-1)，*能不能使得p(j-2)再与s(i-2)字符继续匹配，
 * 那就把s串的末尾字符去掉，查看p(0,j-1)能否继续与s(0,i-2)匹配了。此时，推导公式为：dp(i)(j) = dp(i-1)(j)
 *
 * 【注】对了，依据此文各情况分支的讨论，此分支dp(i)(j) 是a1~a3三种情况的“或运算”，即dp(i)(j) = dp(i)(j-2) || dp(i-1)(j-2) || dp(i-1)(j) 。
 */