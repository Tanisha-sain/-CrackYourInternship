// Given an absolute path for a Unix-style file system, which begins with a slash '/', transform this path into its simplified canonical path.


class Solution {
    public String simplifyPath(String path) {
        List<String> dir = new ArrayList<>();
        String[] files = path.split("/");

        for(String file : files){
            if(dir.size() != 0 && file.equals("..")){
                dir.remove(dir.size()-1);
            }else if(!file.equals(".") && !file.equals("") && !file.equals("..")){
                dir.add(file);
            }
        }
        String ans = "";
        for(String file : dir){
            ans += ("/" + file);
        }
        return (ans.length() == 0) ? "/" : ans;
    }
}
