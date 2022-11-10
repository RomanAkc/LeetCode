public class Solution {
    public int search(int[] nums, int target) {
        return bsearch(nums, target, 0, nums.length - 1);
    }

    private int bsearch(int[] nums, int target, int L, int R) {
        if(L >= R) {
            if(nums[L] == target)
                return L;

            return -1;
        }

        int M = (L + R) / 2;

        if(nums[M] == target)
            return M;

        if(nums[M] > target)
            return bsearch(nums, target, L, M - 1);
        else
            return bsearch(nums, target, M + 1, R);
    }
}
