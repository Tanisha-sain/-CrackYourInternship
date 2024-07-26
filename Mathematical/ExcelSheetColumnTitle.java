// Given an integer columnNumber, return its corresponding column title as it appears in an Excel sheet.

class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder res = new StringBuilder();
        while(columnNumber > 0){
            char ch = (char)(Math.ceil((columnNumber - 1) % 26 + 65));
            res.insert(0,ch);;
            columnNumber = (columnNumber - 1)/26;
        }
        return res.toString();
    }
}
