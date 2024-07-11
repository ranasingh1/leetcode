class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> rc = new ArrayList<>();

       combination(k, n, ans, rc, 1);
      return ans;
    }


  public void combination (int k , int n, List<List<Integer>> ans, List<Integer> rc, int index)
  {
    if(n==0 && rc.size()==k)
    {
      ans.add(new ArrayList<>(rc));
       return; 
    }

 for(int i = index; i<10; i++)
 {
   // to not pick
    
    if(i> n) break;

    // to pick 

    rc.add(i);
   combination(k, n-i, ans, rc, i+1);
   rc.remove(rc.size()-1);

  }

  }
}