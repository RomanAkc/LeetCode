public class Solution extends GuessGame {
    public Solution(int picked) {
        super(picked);
    }

    public int guessNumber(int n) {
        return check(0, n);
    }

    private int check(int L, int R) {
        if(L >= R)
            return L;

        int M = (int)(((long)L + (long)R) / (long)2);
        int res = guess(M);

        if(res == 0)
            return M;

        if(res == -1) {
            return check(L, M - 1);
        } else {
            return check(M + 1, R);
        }
    }
}
