public class Solution {
    public int findMin(int[] nums) {
        //0,1,2,3,4 - Indices
        //1,2,3,4,5
        //<,<,<,<,<
        //5,1,2,3,4
        //>,<,<,<,<
        //4,5,1,2,3
        //<,>,<,<,<
        //3,4,5,1,2
        //<,<,>,<,<
        //2,3,4,5,1
        //<,<,<,>,<

        //Find a place where a[i - 1] > a[i];
        //binarySearch - O(log N)
        return nums[binarySearch(nums, 0, nums.length - 1)];
    }

    private int binarySearch(int[] nums, int L, int R) {
        if(L >= R) {
            return L;
        }

        int M = (L + R) / 2;
        if(nums[M] > nums[R])
            return binarySearch(nums, M + 1, R);
        else
            return binarySearch(nums, L, M);
    }
}
