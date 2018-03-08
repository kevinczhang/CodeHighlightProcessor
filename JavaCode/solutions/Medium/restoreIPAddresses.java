public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> re = new ArrayList<String>();
        String[] sb = new String[4];
        getIpAddresses(re, sb, s, 0);
        return re;
    }

    public void getIpAddresses(List<String> re, String[] sb, String s, int level) {
        int len = s.length();
        // Too few or too many chars left for rest levels
        // Last level but still has chars left
        if (level < 4 && (len < 4 - level || len > 3 * (4 - level)) || level == 4 && len > 0)
            return;
        // If reach level 4
        if (level == 4) {
            StringBuilder temp = new StringBuilder();
            for (int i = 0; i < 4; i++) {
                temp.append(sb[i]);
                temp.append('.');
            }
            temp.deleteCharAt(temp.length() - 1);
            re.add(temp.toString());
            return;
        }
        // If first char is 0
        if (s.charAt(0) == '0') {
            sb[level] = "0";
            getIpAddresses(re, sb, s.substring(1), level + 1);
            return;
        }
        // Get each possible ip address of 1 to 3 chars
        for (int j = 1; j < 4; j++) {
            if (j > len) break;
            String ipStr = s.substring(0, j);
            if (Integer.parseInt(ipStr) <= 255) {
                sb[level] = ipStr;
                getIpAddresses(re, sb, s.substring(j), level + 1);
            }
        }
    }
}