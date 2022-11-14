import java.util.*;

public class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> result = new ArrayList<>();

        HashMap<String, Integer> map = new HashMap<>();


        for(var s : words) {
            int count = 0;
            if(map.containsKey(s)) {
                count = map.get(s) + 1;
            }
            map.put(s, count);

        }

        TreeMap<Integer, ArrayList<String>> reverse = new TreeMap<>(Collections.reverseOrder());

        for(var kv : map.entrySet()) {
            if(reverse.containsKey(kv.getValue())) {
                reverse.get(kv.getValue()).add(kv.getKey());
            } else {
                var list = new ArrayList<String>();
                list.add(kv.getKey());
                reverse.put(kv.getValue(), list);
            }
        }

        for(var kv : reverse.entrySet()) {
            kv.getValue().sort(String::compareTo);

            for(var s : kv.getValue()) {
                result.add(s);
                k--;

                if(k == 0)
                    break;
            }

            if(k == 0)
                break;

        }

        return result;
    }
}
