import java.util.*;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();

        HashMap<String, ArrayList<String>> hash = new HashMap<>();

        for(int i = 0; i < strs.length; ++i) {
            char[] str_ = strs[i].toCharArray();
            Arrays.sort(str_);
            String str = String.valueOf(str_);

            if(hash.containsKey(str)) {
                hash.get(str).add(strs[i]);
            } else {
                ArrayList<String > list = new ArrayList<>();
                list.add(strs[i]);
                hash.put(str, list);
            }
        }

        for(var kv : hash.entrySet()) {
            result.add(kv.getValue());
        }


        return result;
    }
}
