import java.util.ArrayList;

public class Solution {
    public int[][] merge(int[][] intervals) {
        sort(intervals);

        var startEnd = new ArrayList<Integer>();
        int start = intervals[0][0];
        int end = intervals[0][1];
        for(int i = 1; i < intervals.length; ++i) {
            if(intervals[i][0] <= end) {
                if(intervals[i][1] > end)
                    end = intervals[i][1];
                continue;
            }

            startEnd.add(start);
            startEnd.add(end);

            start = intervals[i][0];
            end = intervals[i][1];
        }

        startEnd.add(start);
        startEnd.add(end);

        var res = new int[startEnd.size() / 2][2];
        for(int i = 0; i < startEnd.size() / 2; ++i) {
            res[i][0] = startEnd.get(i * 2);
            res[i][1] = startEnd.get(i * 2 + 1);
        }

        return res;
    }

    void sort(int[][] intervals) {
        quiksort(0, intervals.length - 1, intervals);
    }

    void quiksort(int l, int r, int[][] intervals) {
        if(l >= r)
            return;

        int m = split(l, r, intervals);
        quiksort(l, m - 1, intervals);
        quiksort(m + 1, r, intervals);
    }

    int split(int l, int r, int[][] intervals) {
        var pivot = intervals[r];

        int m = l - 1;

        for(int j = l; j <= r; ++j) {
            if(intervals[j][0] <= pivot[0])
                swap(++m, j, intervals);
        }

        return m;
    }

    void swap(int l, int r, int[][] intervals) {
        var tmp = intervals[l];
        intervals[l] = intervals[r];
        intervals[r] = tmp;
    }
}
