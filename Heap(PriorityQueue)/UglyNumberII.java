// An ugly number is a positive integer whose prime factors are limited to 2, 3, and 5.
// Given an integer n, return the nth ugly number.

class Solution {
    public int nthUglyNumber(int n) {
        int[] ugly = new int[n];
        ugly[0] = 1;

        int two = 0, three = 0, five = 0;

        for(int i = 1; i<n; i++){
            int num1 = 2 * ugly[two];
            int num2 = 3 * ugly[three];
            int num3 = 5 * ugly[five];
            int min = Math.min(num1, Math.min(num2, num3));
            ugly[i] = min;

            if(min == num1) two++;
            if(min == num2) three++;
            if(min == num3) five++;
        }

        return ugly[n-1];
    }
}
