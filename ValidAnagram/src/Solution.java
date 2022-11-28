import java.util.Arrays;
import java.util.HashMap;

public class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;

        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); ++i) {
            int val = map.getOrDefault(s.charAt(i), 0);
            map.put(s.charAt(i), ++val);
        }

        for(int i = 0; i < t.length(); ++i) {
            int val = map.getOrDefault(t.charAt(i), 0);
            if(val == 0)
                return false;
            if(val == 1) {
                map.remove(t.charAt(i));
                continue;
            }
            map.put(t.charAt(i), --val);
        }

        return map.isEmpty();
    }

    public boolean isAnagram_log(String s, String t) {
        if(s.length() != t.length())
            return false;

        var s_arr = s.toCharArray();
        Arrays.sort(s_arr);

        var t_arr = t.toCharArray();
        Arrays.sort(t_arr);

        int i = s_arr.length - 1;
        while (i >= 0) {
            if(s_arr[i] != t_arr[i])
                break;

            i--;
        }
        return i < 0;
    }
}
