import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int characterReplacement(String s, int k) {
        int maxLength = 0;

        int[] maxFreq = findMaxFreq(s);

        int i = maxFreq[0] - k;
        if(i < 0)
            i = 0;
        int max = maxFreq[1] + k - 1;
        for(; i < max && i < s.length(); i++) {
            //Go right
            int length = 1;
            char symbol = s.charAt(i);

            int p = k;
            int j = i + 1;
            for(; j < s.length() && p > 0; ++j) {
                if(s.charAt(j) != symbol) {
                    p--;
                }
                length++;
            }

            if(p == 0) {
                while(j < s.length() && s.charAt(j) == symbol) {
                    j++;
                    length++;
                }
            }

            //Go left
            j = i - 1;
            for(; j >= 0 && p > 0; --j) {
                if(s.charAt(j) != symbol) {
                    p--;
                }
                length++;
            }

            if(p == 0) {
                while(j >= 0 && s.charAt(j) == symbol) {
                    j--;
                    length++;
                }
            }

            if(length > maxLength)
                maxLength = length;
        }


        return  maxLength;
    }

    public int[] findMaxFreq(String s) {
        int[] result = new int[2];
        int maxFreq = 0;
        int start = -1;

        int curFreq = 0;
        char symbol = 0;
        for(int i = 0; i < s.length(); ++i) {
            if(s.charAt(i) != symbol) {
                if(curFreq > maxFreq) {
                    result[0] = start;
                    maxFreq = curFreq;
                }

                start = i;
                curFreq = 1;
                symbol = s.charAt(i);

            } else {
                curFreq++;
            }
        }

        if(curFreq > maxFreq) {
            result[0] = start;
            maxFreq = curFreq;
        }

        result[1] = result[0] + maxFreq;
        return result;
    }



    public int characterReplacement_Long(String s, int k) {
        //XYZZZZABCZZ k = 1 //answer = 5
        //XYZZZZABCZZ k = 2 //answer = 7
        //XYZZZZABCZZ k = 3 //answer = 10

        int maxLength = 0;
        for(int i = 0; i < s.length(); ++i) {

            //Go right
            int length = 1;
            char symbol = s.charAt(i);

            int p = k;
            int j = i + 1;
            for(; j < s.length() && p > 0; ++j) {
                if(s.charAt(j) != symbol) {
                    p--;
                }
                length++;
            }

            if(p == 0) {
                while(j < s.length() && s.charAt(j) == symbol) {
                    j++;
                    length++;
                }
            }

            //Go left
            j = i - 1;
            for(; j >= 0 && p > 0; --j) {
                if(s.charAt(j) != symbol) {
                    p--;
                }
                length++;
            }

            if(p == 0) {
                while(j >= 0 && s.charAt(j) == symbol) {
                    j--;
                    length++;
                }
            }

            if(length > maxLength)
                maxLength = length;
        }

        return maxLength;
    }

























    public int characterReplacement_FromINTERNET(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        char[] arr = s.toCharArray();
        int left = 0, right = 0;

        int maxLen = 0, mostFreq = 0;

        while (right < s.length()) {
            // start acquiring
            map.put(arr[right], map.getOrDefault(arr[right], 0) + 1);
            mostFreq = Math.max(mostFreq, map.get(arr[right]));

            int canBeReplaced = (right - left + 1) - mostFreq;

            // release from the left
            if (canBeReplaced > k) {
                map.put(arr[left], map.get(arr[left]) - 1);
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }

        return maxLen;
    }

    //Decisions below are incorrect, because I didn't understand the task
    public int characterReplacement_old2(String s, int k) {
        ArrayList<Pair> intervalList = createIntervalList(s);

        int maxLength = 0;
        for(int i = 0; i < intervalList.size(); ++i) {
            int currMaxLength = intervalList.get(i).cnt;
            int p = k;

            char curr = intervalList.get(i).symbol;

            int j = i - 1;
            boolean directionRight = false;

            char change = 0;
            if(j < 0 && i + 1 < intervalList.size()) {
                directionRight = true;
                j = i + 1;
            }

            if(j >= 0)
                change = intervalList.get(j).symbol;

            while (p > 0) {
                if(j < 0 || intervalList.get(j).symbol != curr && intervalList.get(j).symbol != change && !directionRight) {
                    j = i + 1;
                    directionRight = true;
                }

                if(j >= intervalList.size())
                    break;

                if(intervalList.get(j).symbol != curr && intervalList.get(j).symbol != change)
                    break;

                if(intervalList.get(j).symbol == change)
                {
                    if(p < intervalList.get(j).cnt) {
                        currMaxLength += p;
                        p = 0;

                        if(!directionRight) {
                            j = i;
                            directionRight = true;
                        }

                    } else {
                        currMaxLength += intervalList.get(j).cnt;
                        p -= intervalList.get(j).cnt;
                    }
                }
                else
                {
                    currMaxLength += intervalList.get(j).cnt;
                }

                j = j + (directionRight ? 1 : -1);

                if(p == 0 && j >= 0 && j < intervalList.size() && intervalList.get(j).symbol == curr) {
                    currMaxLength += intervalList.get(j).cnt;
                }
            }

            if(currMaxLength > maxLength)
                maxLength = currMaxLength;

            if(maxLength == s.length())
                return maxLength;
        }


        return maxLength;

    }

    private static class Pair {
        char symbol;
        int cnt;

        public Pair(char symbol, int cnt) {
            this.symbol = symbol;
            this.cnt = cnt;
        }
    }

    private ArrayList<Pair> createIntervalList(String s) {
        ArrayList<Pair> intervalList = new ArrayList<>();

        int counter = 0;
        char currentSymbol = 0;

        for(int i = 0; i < s.length(); ++i) {
            if(i == 0) {
                currentSymbol = s.charAt(i);
                counter++;
                continue;
            }

            if(s.charAt(i) == currentSymbol) {
                counter++;
                continue;
            }

            intervalList.add(new Pair(currentSymbol, counter));
            currentSymbol = s.charAt(i);
            counter = 1;
        }

        intervalList.add(new Pair(currentSymbol, counter));

        return intervalList;
    }

    public int characterReplacement_old(String s, int k) {

        String[] arr = s.split("(?<=(.))(?!\\1)");

        int maxLength = 0;
        for(int i = 0; i < arr.length; ++i) {
            int currMaxLength = arr[i].length();
            int p = k;

            char curr = arr[i].charAt(0);

            int j = i - 1;
            boolean directionRight = false;

            char change;
            if(j < 0 && i + 1 < arr.length) {
                directionRight = true;
                j = i + 1;
                change = arr[i + 1].charAt(0);
            } else {
                change = arr[j].charAt(0);
            }

            while (p > 0) {
                if(j < 0 || arr[j].charAt(0) != curr && arr[j].charAt(0) != change && !directionRight) {
                    j = i + 1;
                    directionRight = true;
                }

                if(j >= arr.length)
                    break;

                if(arr[j].charAt(0) != curr && arr[j].charAt(0) != change)
                    break;

                if(arr[j].charAt(0) == change)
                {
                    if(p < arr[j].length()) {
                        currMaxLength += p;
                        p = 0;

                        if(!directionRight) {
                            j = i;
                            directionRight = true;
                        }

                    } else {
                        currMaxLength += arr[j].length();
                        p -= arr[j].length();
                    }
                }
                else
                {
                    currMaxLength += arr[j].length();
                }



                //if(arr[j].charAt(0) == curr || arr[j].charAt(0) == change) {
                    j = j + (directionRight ? 1 : -1);
                //}

                if(p == 0 && j >= 0 && j < arr.length && arr[j].charAt(0) == curr) {
                    currMaxLength += arr[j].length();
                }
            }

            if(currMaxLength > maxLength)
                maxLength = currMaxLength;

            if(maxLength == s.length())
                return maxLength;
        }


        return maxLength;

    }



}
