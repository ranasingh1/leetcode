class Solution {
    public int kthGrammar(int n, int k) {
        return helper(n,k);
    }
    public int helper(int n,int k){
        if(n==1 && k==1)return 0;
        int mid=(1<<n-1)/2; // finding the mid value
        if(k<=mid){
            	// if k is less than mid then we can simply check k for n-1 row as the string before mid in nth row is the copy of the n-1 th row 
            return helper(n-1,k);
        }
        else{
             	// otherwise we obsereved that the string after the mid is complement of the n-1 th string 
            return helper(n-1,k-mid)==1?0:1;
        }        
    }
}
