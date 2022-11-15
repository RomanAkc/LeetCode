import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public List<Integer> partitionLabels(String s) {
        ArrayList<Integer> result = new ArrayList<>();

        HashMap<Character, Pair> hash = new HashMap<>();

        for(int i = 0; i < s.length(); ++i) {
            if(hash.containsKey(s.charAt(i))) {
                var  p = hash.get(s.charAt(i));
                p.high = Math.max(p.high, i);
                p.low = Math.min(p.low, i);
            } else {
                Pair p = new Pair();
                p.high = i;
                p.low = i;
                hash.put(s.charAt(i), p);
            }
        }

        ArrayList<Pair> list = new ArrayList<>();
        for(var v : hash.entrySet()) {
            list.add(v.getValue());
        }

        list.sort(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return Integer.compare(o1.low, o2.low);
            }
        });

        int minIndex = list.get(0).low;
        int maxIndex = list.get(0).high;
        for(int i = 1; i < list.size(); ++i) {
            if(list.get(i).low < maxIndex) {
                maxIndex = Math.max(list.get(i).high, maxIndex);
            } else {
                result.add(maxIndex - minIndex + 1);
                minIndex = list.get(i).low;
                maxIndex = list.get(i).high;
            }
        }

        result.add(maxIndex - minIndex + 1);

        return result;
    }

    private static class Pair {
        public int low;
        public int high;
    }
}
