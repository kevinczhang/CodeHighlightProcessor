public class Solution {
    public boolean isValidSerialization(String preorder) {
        List<String> list = new ArrayList<String>();
		for(String x : preorder.split(",")){
			list.add(x);
			while(list.size() >= 3 && list.get(list.size()-1).equals("#") && 
					list.get(list.size()-2).equals("#") && 
					!list.get(list.size()-3).equals("#")){
				list.remove(list.size()-1);
				list.remove(list.size()-1);
				list.remove(list.size()-1);
				list.add("#");
			}
		}		        
        return (list.size() == 1) && (list.get(list.size()-1).equals("#"));
    }
}