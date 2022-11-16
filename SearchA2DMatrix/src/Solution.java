public class Solution {
    public boolean searchMatrix2(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int l = 0, r = m * n - 1;
        while (l != r) {
            int mid = (l + r - 1) / 2;
            if (matrix[mid / m][mid % m] < target)
                l = mid + 1;
            else
                r = mid;
        }
        if(matrix[r / m][r % m] == target)
            return true;
        else
            return false;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int k = 0;

        int[] A = new int[matrix.length * matrix[0].length];
        for(int i = 0; i < m; ++i) {
            for(int j = 0; j < n; j++) {
                A[k++] = matrix[i][j];
            }
        }

        return bsearch(A, 0, A.length - 1, target);
    }

    boolean bsearch(int[] A, int L, int R, int target) {
        if(L >= R) {
            return target == A[L];
        }

        int M = (L + R) / 2;

        if(A[M] == target) {
            return true;
        }

        if(target > A[M]) {
            return bsearch(A, M + 1, R, target);
        } else {
            return bsearch(A, L, M - 1, target);
        }
    }
}
