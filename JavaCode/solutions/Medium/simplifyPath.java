public class Solution {
    public String simplifyPath(String path) {
        String[] sts = path.split("/");
        Deque<String> pathDeque = new ArrayDeque<String>();
        for (String st : sts) {
            st = st.trim();
            if (st.length() == 0 || st.equals(".")){
                continue;
            } else if (st.equals("..")){
                if (pathDeque.isEmpty())
                    continue;
                else
                    pathDeque.removeLast();
            } else {
                pathDeque.addLast(st);
            }
        }
        StringBuilder result = new StringBuilder("/");
        if (pathDeque.isEmpty()) return result.toString();
        while (!pathDeque.isEmpty()){
            result.append(pathDeque.removeFirst() + "/");
        }
        return result.substring(0, result.length()-1);
    }
}