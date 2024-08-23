// You are given an array of variable pairs equations and an array of real numbers values, where equations[i] = [Ai, Bi]
// and values[i] represent the equation Ai / Bi = values[i]. Each Ai or Bi is a string that represents a single variable.
// You are also given some queries, where queries[j] = [Cj, Dj] represents the jth query where you must find the answer for Cj / Dj = ?.
// Return the answers to all queries. If a single answer cannot be determined, return -1.0.
// Note: The input is always valid. You may assume that evaluating the queries will not result in division by zero and that there is no contradiction.
// Note: The variables that do not occur in the list of equations are undefined, so the answer cannot be determined for them.


class Solution {
    public static class Node{
        public String var;
        public double value;
        public Node(String v, double val){
            this.var = v;
            this.value = val;
        }
    }

    double solve(String node, double ans, Set<String> vis, String target, Map<String, List<Node>> map){
        if(vis.contains(node)) return -1.0;
        if(node.equals(target)) return ans;
        vis.add(node);

        for(Node n : map.getOrDefault(node, new ArrayList<>())){
            double val = solve(n.var, ans*n.value, vis, target, map);
            if(val != -1) return val;
        }
        return -1.0;
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<Node>> map = new HashMap<>();
        for(int i = 0; i<equations.size(); i++){
            List<String> edge = equations.get(i);
            List<Node> neigh = map.getOrDefault(edge.get(0), new ArrayList<>());
            neigh.add(new Node(edge.get(1), values[i]));
            map.put(edge.get(0), neigh);
            neigh = map.getOrDefault(edge.get(1), new ArrayList<>());
            neigh.add(new Node(edge.get(0), 1/values[i]));
            map.put(edge.get(1), neigh);
        }

        double[] ans = new double[queries.size()];
        int i = 0;
        for(List<String> query : queries){
            if(map.containsKey(query.get(0)) && map.containsKey(query.get(1))){
                ans[i++] = solve(query.get(0), 1.0, new HashSet<>(), query.get(1), map);
            }else{
                ans[i++] = -1.0;
            }
        }
        return ans;
    }
}
