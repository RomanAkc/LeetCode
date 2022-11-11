public class GuessGame {
    public GuessGame(int picked) {
        this.picked = picked;
    }

    protected int guess(int num) {
        if(num > picked)
            return -1;

        if(num < picked)
            return 1;

        return 0;
    }

    private int picked;
}
