// A celebrity is a person who is known to all but does not know anyone at a party. If you go to a party of N people, 
// find if there is a celebrity in the party or not.
// A square NxN matrix M[][] is used to represent people at the party such that if an element of row i and column j 
// is set to 1 it means ith person knows jth person. Here M[i][i] will always be 0.
// Return the index of the celebrity, if there is no celebrity return -1.


class Solution {
    // Function to find if there is a celebrity in the party or not.
    int celebrity(int M[][], int n) {
        // code here
        int top = 0, bottom = n-1;
        while(top < bottom){
            if(M[top][bottom] == 1) top++;
            else if(M[bottom][top] == 1) bottom--;
            else{
                top++;
                bottom--;
            }
        }
        if(top > bottom) return -1;
        for(int i = 0; i<n; i++){
            if(i == top) continue;
            if(M[top][i] == 0 && M[i][top] == 1){
                continue;
            }else{
                return -1;
            }
        }
        return top;
    }
}
