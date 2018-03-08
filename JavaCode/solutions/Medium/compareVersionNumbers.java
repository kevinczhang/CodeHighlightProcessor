public class Solution {
    public int compareVersion(String version1, String version2) {
        // recursively compare substrings before '.'
        int ver1, ver2;
        ver1 = version1.contains(".") ?
                Integer.parseInt(version1.substring(0, version1.indexOf('.'))) :
                Integer.parseInt(version1);
        ver2 = version2.contains(".") ?
                Integer.parseInt(version2.substring(0, version2.indexOf('.'))) :
                Integer.parseInt(version2);

        if (ver1 > ver2) return 1;
        else if (ver1 < ver2) return -1;

        if (version1.contains(".") && version2.contains("."))
            return compareVersion(version1.substring(version1.indexOf('.') + 1),
                    version2.substring(version2.indexOf('.') + 1));
        else if (version1.contains("."))
            return compareVersion(version1.substring(version1.indexOf('.') + 1), "0");
        else if (version2.contains("."))
            return compareVersion("0", version2.substring(version2.indexOf('.') + 1));
        else return 0;
    }
}