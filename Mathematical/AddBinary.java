// Given two binary strings a and b, return their sum as a binary string.



class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int n = a.length();
        int m = b.length();
        char cha = '0', chb = '0';

        int i = n-1, j = m-1;
        char rem = '0';

        while(i >= 0 || j >= 0){
            if(i >= 0) cha = a.charAt(i);
            else cha = '0';
            if(j >= 0) chb = b.charAt(j);
            else chb = '0';
            if((cha == '1' && chb == '1' && rem == '0') || (cha == '0' && chb == '1' && rem == '1') || (cha == '1' && chb == '0' && rem == '1')){
                sb.insert(0,'0');
                rem = '1';
            }else if(cha == '1' && chb == '1' && rem == '1'){
                sb.insert(0,'1');
                rem = '1';
            }else if(cha == '0' && chb == '0' && rem == '0'){
                sb.insert(0,'0');
                rem = '0';
            }else if((cha == '0' && chb == '0' && rem == '1') || (cha == '1' && chb == '0' && rem == '0') || (cha == '0' && chb == '1' && rem == '0')){
                sb.insert(0,'1');
                rem = '0';
            }
            i--;
            j--;
        }

        if(rem == '1') sb.insert(0,'1');

        return sb.toString();

    }
}
