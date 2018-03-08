public class Solution {
    public int hIndex(int[] citations) {
        if (citations.length == 0)
			return 0;
		if (citations.length == 1)
			return citations[0] > 0 ? 1 : 0;

		// Map for citations numbers with paper count
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int currentHIdex = 0, resHIndex;
		for (int c : citations) {
			if (c == 0)
				continue;
			if (map.containsKey(c))
				map.put(c, map.get(c) + 1);
			else
				map.put(c, 1);
		}

		if (map.size() == 0)
			return 0;
		int[] uniqueCitations = new int[map.size()];
		int index = 0;
		for (int i : map.keySet()) {
			uniqueCitations[index++] = i;
		}
		Arrays.sort(uniqueCitations);

		if (uniqueCitations[uniqueCitations.length - 1] <= 
		    map.get(uniqueCitations[uniqueCitations.length - 1]))
			return uniqueCitations[uniqueCitations.length - 1];
		resHIndex = currentHIdex = map.get(uniqueCitations[uniqueCitations.length - 1]);
		for (int i = uniqueCitations.length - 2; i >= 0; i--) {
			map.put(uniqueCitations[i], 
			    map.get(uniqueCitations[i]) + map.get(uniqueCitations[i + 1]));
			currentHIdex = uniqueCitations[i] <= map.get(uniqueCitations[i]) ? 
			    uniqueCitations[i] : map.get(uniqueCitations[i]);
			resHIndex = currentHIdex > resHIndex ? currentHIdex : resHIndex;
		}
		return resHIndex;
    }
}