class Solution {
    List <List <Integer>> result;
    public void combinationUtil (int [] candidates, int i, int target, List <Integer> tmp) {
        if (i >= candidates.length || target < 0)
            return;
        if (target == 0) {
            this.result.add (new ArrayList <>(tmp));
            return;
        }
        
        for (int j = i; j < candidates.length; j += 1) {
            tmp.add (candidates[j]);
            combinationUtil (candidates, j, target - candidates[j], tmp);
            tmp.remove (tmp.size () - 1);
        }
    }
    
    public List <List <Integer>> combinationSum (int [] candidates, int target) {
        this.result = new ArrayList <>();
        combinationUtil (candidates, 0, target, new ArrayList <Integer>());
        return this.result;
    }
}