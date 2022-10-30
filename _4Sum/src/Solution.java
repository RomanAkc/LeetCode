import java.util.*;

public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        return fourSum_New(nums, target);
    }

    private static ArrayList<List<Integer>> fourSum_New(int[] nums, int target) {
        var result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);

        for(int i = 0; i < nums.length; ++i) {
            for(int j = i + 1; j < nums.length; ++j) {
                for(int k = j + 1; k < nums.length; ++k) {
                    if(isExistListWithThreeFirstEqual(result, nums[i], nums[j], nums[k]))
                        continue;

                    long need4 = (long)target - ((long)nums[i] + (long)nums[j] + (long)nums[k]);
                    for(int l = k + 1; l < nums.length; ++l) {
                        if((long)nums[l] == need4) {

                            var lst = new ArrayList<>(Arrays.asList(
                                    nums[i],
                                    nums[j],
                                    nums[k],
                                    nums[l]
                            ));

                            result.add(lst);

                            break;
                        }
                    }
                }
            }
        }
        return result;
    }

    private static boolean isExistListWithThreeFirstEqual(ArrayList<List<Integer>> result, int firstValue, int secondValue, int thirdValue) {
        for(var r : result) {
            if(r.get(0) == firstValue
            && r.get(1) == secondValue
            && r.get(2) == thirdValue) {
                return true;
            }
        }
        return false;
    }

    private static ArrayList<List<Integer>> fourSum_Stupid(int[] nums, int target) {
        var result = new ArrayList<List<Integer>>();

        for(int i = 0; i < nums.length; ++i) {
            for(int j = i + 1; j < nums.length; ++j) {
                for(int k = j + 1; k < nums.length; ++k) {
                    for(int l = k + 1; l < nums.length; ++l) {
                        if(nums[i] + nums[j] + nums[k] + nums[l] == target) {
                            var lst = new ArrayList<>(Arrays.asList(
                                    nums[i],
                                    nums[j],
                                    nums[k],
                                    nums[l]
                            ));
                            Collections.sort(lst);

                            if (isAlreadyExist(result, lst))
                                continue;

                            result.add(lst);
                        }
                    }
                }
            }
        }

        return result;
    }

    private static boolean isAlreadyExist(ArrayList<List<Integer>> result, ArrayList<Integer> lst) {
        for(var v : result) {
            if(v.equals(lst))
                return true;
        }

        return false;
    }
}
