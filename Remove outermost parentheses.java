class Solution {
    public String removeOuterParentheses(String s) {
        Stack<Character> st = new Stack <>();
        String ans = "";
        for(int i = 0;i<s.length(); i++){
            if(s.charAt(i)=='('){
            if(st.size()>0)
                ans+="(";
                st.push('(');
            }
            else{
                st.pop();
            
            if(st.size()>0) ans+=")";
            }


        }
        return ans;
    }
}
