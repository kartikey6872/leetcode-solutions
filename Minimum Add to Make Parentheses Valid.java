class Solution {
    public int minAddToMakeValid(String s) {
        int top =0;
        int depth =0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                depth++;
            }
            else{
                if(depth>0)
                    depth--;
                
            
            else
                top++;
            }
            

        }
        return top + depth;
        
    }
}
