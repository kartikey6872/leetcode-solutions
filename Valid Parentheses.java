class Solution {
    public boolean isValid(String s) {
        for(int i=0;i<s.length()-1;i++){
           if((s.charAt(i) == '(' && s.charAt(i+1) == ')') ||
               (s.charAt(i) == '[' && s.charAt(i+1) == ']') ||
               (s.charAt(i) == '{' && s.charAt(i+1) == '}')) {
                s = s.replace(s.substring(i, i + 2), "");
                i = -1;
            }
        }

        return s.length() == 0;
        }

        
    }
