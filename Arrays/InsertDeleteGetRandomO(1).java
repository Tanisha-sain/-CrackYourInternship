// RandomizedCollection is a data structure that contains a collection of numbers, possibly duplicates (i.e., a multiset). 
// It should support inserting and removing specific elements and also reporting a random element.
// You must implement the functions of the class such that each function works on average O(1) time complexity.


class RandomizedCollection {

    HashMap<Integer, Integer> map;
    java.util.Random random = new java.util.Random();
    List<Integer> keys;

    public RandomizedCollection() {
        map = new HashMap<>();
        keys = new ArrayList<>();
    }
    
    public boolean insert(int val) {
        boolean ans = false;
        if(!map.containsKey(val)) ans = true;
        map.put(val, map.getOrDefault(val,0)+1);
        keys.add(val);
        return ans;
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val)) return false;
        int occ = map.get(val);
        if(occ > 1){
            map.put(val, occ-1);
        }else{
            map.remove(val);
        }
        keys.remove(Integer.valueOf(val));
        return true;
    }
    
    public int getRandom() {
        int index = random.nextInt(keys.size());
        return keys.get(index);
    }
}
