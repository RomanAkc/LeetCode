import java.util.*;

public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        return fourSum_Stupid(nums, target);
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
        boolean isExist = false;
        for(var v : result) {
            if(v.equals(lst))
                return true;

            /*int m = 0;
            while(m < 4 && v.get(m) == lst.get(m)) {
                m++;
            }

            if(m == 4) {
                isExist = true;
                break;
            }*/
        }

        /*if(isExist)
            return true;*/
        return false;
    }
}
