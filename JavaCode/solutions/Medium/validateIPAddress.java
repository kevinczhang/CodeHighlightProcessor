public class Solution {
    public String validIPAddress(String IP) {
        if (isValidIPv4(IP))
            return "IPv4";
        else if (isValidIPv6(IP))
            return "IPv6";
        else
            return "Neither";
    }

    private boolean isValidIPv4(String ip) {
        String[] tokens = ip.split("\\.");
        if (ip.length() < 7 || ip.charAt(0) == '.' ||
                ip.charAt(ip.length() - 1) == '.' || tokens.length != 4)
            return false;
        for (String token : tokens) {
            if (token.startsWith("0") && token.length() > 1)
                return false;
            try {
                int parsedInt = Integer.parseInt(token);
                if (parsedInt < 0 || parsedInt > 255 ||
                        parsedInt == 0 && token.charAt(0) != '0')
                    return false;
            } catch (NumberFormatException nfe) {
                return false;
            }
        }
        return true;
    }

    private boolean isValidIPv6(String ip) {
        String[] tokens = ip.split(":");
        if (ip.length() < 15 || ip.charAt(0) == ':' ||
                ip.charAt(ip.length() - 1) == ':' || tokens.length != 8)
            return false;
        for (String token : tokens) {
            if (token.length() > 4 || token.length() == 0)
                return false;
            char[] chars = token.toCharArray();
            for (char c : chars) {
                if (!Character.isDigit(c) && !((c - 'A') >= 0 && (c - 'A') <= 5) &&
                        !((c - 'a') >= 0 && (c - 'a') <= 5))
                    return false;
            }
        }
        return true;
    }
}