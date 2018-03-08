public class Solution {
    public int countSegments(String s) {
        String trimmed = s.trim();
        return trimmed.length() == 0 ? 0 : trimmed.split("\\s+").length;
    }
}