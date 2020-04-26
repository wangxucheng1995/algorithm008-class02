class Solution:
    def nthUglyNumber(self, n: int) -> int:
        dp, a, b, c = [1] * n, 0, 0, 0
        for i in range(1, n):
            da = dp[a] * 2
            db = dp[b] * 3
            dc = dp[c] * 5
            dp[i] = min(da, db, dc)
            if dp[i] == da:
                a += 1
            if dp[i] == db:
                b += 1
            if dp[i] == dc:
                c += 1
        return dp[n - 1]
