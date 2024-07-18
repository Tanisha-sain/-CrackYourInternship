// Write a function to find the longest common prefix string amongst an array of strings.

class Solution {
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        Arrays.sort(strs);
        String temp = strs[0];
        int m = temp.length();
        // System.out.println(Arrays.toString(strs));
        for(int i = 1; i<n; i++){
            String curr = strs[i];
            // System.out.println(temp + " " + curr);
            int j = 0, l = 0;
            while(j < m){
                if(temp.charAt(j) != curr.charAt(l)) break;
                j++;
                l++;
            }
            if(j == m) continue;
            temp = temp.substring(0,j);
            m = j;
            if(temp == "") return temp;
        }
        return temp;
    }
}
