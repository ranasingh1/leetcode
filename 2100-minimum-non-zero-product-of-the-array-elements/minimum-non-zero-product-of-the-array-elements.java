class Solution {
    public int mod = 1_000_000_007;

    public int minNonZeroProduct(int p) {
        if (p == 1) return 1; // Base case for p = 1

        long mx = (long)(Math.pow(2, p)) - 1; // Largest number, 2^p - 1
        long sm = mx - 1; // Second largest number, 2^p - 2
        long n = sm / 2; // Divide by 2 for balanced multiplication
        long sum = rec(sm, n); // Recursive function to calculate the product

        return (int)(sum * (mx % mod) % mod); // Final result after modulo
    }

    public long rec(long val, long n) {
        if (n == 0) return 1; // Base case for recursion
        if (n == 1) return (val % mod); // Base case for n = 1

        long newVal = ((val % mod) * (val % mod)) % mod; // Squaring step

        if (n % 2 != 0) {
            return ((rec(newVal, n / 2) % mod) * (val % mod)) % mod; // If n is odd
        }

        return rec(newVal, n / 2) % mod; // If n is even
    }
}
