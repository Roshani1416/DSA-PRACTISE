class Solution {
    public List<String> generateParenthesis(int n) {

        List<String> ans = new ArrayList<>();
        solve(ans,"",0,0,n);
        return ans;
        
    }

    public void solve(List<String> ans , String current , int open , int close , int n ){
        if(open==n && close==n){
            ans.add(current);
            return ;
        }

        if(open<n){
            solve(ans,current+"(",open+1,close,n);
        }

        if(close<open){
            solve(ans,current+")",open,close+1,n);
        }
    }
}
