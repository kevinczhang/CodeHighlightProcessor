public class Solution {
    public List<String> findStrobogrammatic(int n) {
        List<String> res = new ArrayList<>();
        if(n == 0) return res;
        if(n % 2 == 1){
            res.add("0");
            res.add("1");
            res.add("8");
        }
        for(int i = (n % 2) + 2; i <= n; i++){
            List<String> temp = new ArrayList<>();
            for(String s : res){
                temp.add("1" + s + "1");
                temp.add("6" + s + "9");
                temp.add("9" + s + "6");
                temp.add("8" + s + "8");
            }
            res = temp;
        }
        return res;
    }
}