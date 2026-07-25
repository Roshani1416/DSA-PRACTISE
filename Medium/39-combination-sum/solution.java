class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> ans = new ArrayList<>();

        backtrack(candidates, target, 0, new ArrayList<>(), ans);

        return ans;
    }


    public void backtrack(int[] candidates,
                          int target,
                          int index,
                          List<Integer> current,
                          List<List<Integer>> ans) {


        // base case
        if(target == 0) {
            ans.add(new ArrayList<>(current));
            return;
        }


        if(target < 0) {
            return;
        }


        for(int i = index; i < candidates.length; i++) {


            // choose
            current.add(candidates[i]);


            // recurse
            backtrack(
                candidates,
                target - candidates[i],
                i,          // same index allowed
                current,
                ans
            );


            // undo
            current.remove(current.size()-1);
        }
    }
}
