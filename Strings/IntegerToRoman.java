// Given an integer, convert it to a Roman numeral.


class Solution {
    public String intToRoman(int num) {
        HashMap<Integer, Character> map = new HashMap<>();
        map.put(1,'I');
        map.put(5,'V');
        map.put(10,'X');
        map.put(50,'L');
        map.put(100,'C');
        map.put(500,'D');
        map.put(1000,'M');

        int n = num;
        StringBuilder sb = new StringBuilder();
        int i = 1;
        while(n != 0){
            int rem = n%10;
            if(rem == 4){
                sb.insert(0,map.get(5*i));
                sb.insert(0,map.get(1*i));
            }else if(rem == 9){
                sb.insert(0, map.get(10*i));
                sb.insert(0, map.get(1*i));
            }else{
                int x = rem;
                StringBuilder sb2 = new StringBuilder();
                while(x > 0){
                    if(x >= 5){
                        sb2.append(map.get(5*i));
                        x -= 5;
                    }else{
                        sb2.append(map.get(1*i));
                        x -= 1;
                    }
                }
                sb.insert(0,sb2);
            }
            i *= 10;
            n = n/10;
        }
        return sb.toString();
    }
}
