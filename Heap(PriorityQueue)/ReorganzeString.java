// Given a string s, rearrange the characters of s so that any two adjacent characters are not the same.
// Return any possible rearrangement of s or return "" if not possible.


class Solution {
    class Pair{
        char ch;
        int freq;
        Pair(char ch, int freq){
            this.ch = ch;
            this.freq = freq;
        }
    }
    public String reorganizeString(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch : s.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> b.freq - a.freq);
        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            pq.add(new Pair(entry.getKey(), entry.getValue()));
        }
        StringBuilder sb = new StringBuilder();
        Pair curr = pq.poll();
        sb.append(curr.ch);
        curr.freq--;
        Pair block = curr;
        while(pq.size() > 0){
            curr = pq.poll();
            sb.append(curr.ch);
            curr.freq--;
            if(block.freq > 0) pq.add(block);
            block = curr;
        }
        if(pq.size() == 0 && block.freq > 0) return "";
        return sb.toString();
    }
}
