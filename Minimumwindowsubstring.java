

class Solution {
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) return "";

        // Step 1: build need frequency map
        HashMap<Character, Integer> needFreq = new HashMap<>();
        for (char c : t.toCharArray()) {
            needFreq.put(c, needFreq.getOrDefault(c, 0) + 1);
        }

        int required = needFreq.size();
        int formed = 0;
        HashMap<Character, Integer> windowFreq = new HashMap<>();

        int left = 0;
        int minLen = Integer.MAX_VALUE;
        int minLeft = 0;

        for (int right = 0; right < s.length(); right++) {
            // expand: add s[right] to window
            char c = s.charAt(right);
            windowFreq.put(c, windowFreq.getOrDefault(c, 0) + 1);

            // check if this character's requirement is now satisfied
            if (needFreq.containsKey(c) &&
                windowFreq.get(c).equals(needFreq.get(c))) {
                formed++;
            }

            // shrink from left while window is valid
            while (formed == required) {
                // update best window
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    minLeft = left;
                }

                // remove s[left] from window
                char leftChar = s.charAt(left);
                windowFreq.put(leftChar, windowFreq.get(leftChar) - 1);
                if (needFreq.containsKey(leftChar) &&
                    windowFreq.get(leftChar) < needFreq.get(leftChar)) {
                    formed--;
                }
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minLen);
    }
}
